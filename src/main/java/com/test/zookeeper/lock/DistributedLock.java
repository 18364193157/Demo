package com.test.zookeeper.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/7/5 14:50
 */
public class DistributedLock implements Lock,Watcher{

    private ZooKeeper zk = null;
    private String ROOT_LOCK = "/locks";//定义根节点
    private String WAIT_LOCK;//等待前一个锁
    private String CURRENT_LOCK;//表示当前的锁
    private CountDownLatch countDownLatch; //

    public DistributedLock() {
        try {
            zk = new ZooKeeper("192.168.232.128:2181",4000,
                    this);
            //判断根节点是否存在
            Stat stat = zk.exists(ROOT_LOCK, false);
            if(null == stat) {
                zk.create(ROOT_LOCK,"0".getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lock() {
        if(this.tryLock()){
            System.out.println(Thread.currentThread().getName()+"->"+CURRENT_LOCK+"->获得锁成功");
            return;
        }
        try {
            waitForLock(WAIT_LOCK); //没有获得锁，继续等待获得锁
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean waitForLock(String prev) throws KeeperException, InterruptedException {
        //监听当前节点的上一个节点
        Stat stat = zk.exists(prev, true);
        if(null != stat) {
            System.out.println(Thread.currentThread().getName()+"->等待锁"+ROOT_LOCK+"/"+prev+"释放");
            countDownLatch=new CountDownLatch(1);
            countDownLatch.await();
            //TODO  watcher触发以后，还需要再次判断当前等待的节点是不是最小的
            System.out.println(Thread.currentThread().getName()+"->获得锁成功");
        }
        return true;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 尝试竞争锁
     * @return
     */
    @Override
    public boolean tryLock() {
        try {
            CURRENT_LOCK = zk.create(ROOT_LOCK + "/","0".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(Thread.currentThread().getName() + "->" + CURRENT_LOCK + ",尝试竞争锁");
            List<String> childrens = zk.getChildren(ROOT_LOCK, false);
            SortedSet<String> sortedSet = new TreeSet();
            for (String children : childrens) {
                sortedSet.add(ROOT_LOCK+"/"+children);
            }
            //获取当前排序节点中最小的节点
            String firstNode = sortedSet.first();
            //判断当前获取的是不是最小的节点(获取当前锁前面的所有节点，如果)
            SortedSet<String> lessThenMe= sortedSet.headSet(CURRENT_LOCK);
            //如果相等表明自己是最小的节点
            if(firstNode.equals(CURRENT_LOCK)){
                return true;
            }
            //如果有比自己更小的节点,就将自己设置为等待锁
            if(!lessThenMe.isEmpty()) {
                WAIT_LOCK = lessThenMe.last();
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        System.out.println(Thread.currentThread().getName()+"->释放锁"+CURRENT_LOCK);
        try {
            zk.delete(CURRENT_LOCK,-1);
            CURRENT_LOCK=null;
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(this.countDownLatch!=null){
            this.countDownLatch.countDown();
        }

    }
}
