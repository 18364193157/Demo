package com.test.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/6/18 16:28
 */
public class ZookeeperWatch {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("192.168.130.11:2181,192.168.130.13:2181,192.168.130.13:2181",
                4000, watchedEvent -> {
            if(watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                System.out.println(watchedEvent.getType()); //NodeDeleted
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getState());

        Stat stat = new Stat();
        zooKeeper.create("/zookeeper-persit-lenho","0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Thread.sleep(1000);

       // zooKeeper.exists("/zookeeper-persit-lenho",true); //如果为true就是运用连接时默认的监听
        zooKeeper.exists("/zookeeper-persit-lenho", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType() + "- >" + watchedEvent.getPath()); //NodeDataChanged- >/zookeeper-persit-lenho
                try {
                    zooKeeper.exists("/zookeeper-persit-lenho",true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Stat stat1 = zooKeeper.setData("/zookeeper-persit-lenho", "1".getBytes(), stat.getVersion());
        zooKeeper.delete("/zookeeper-persit-lenho",stat1.getVersion());
    }
}
