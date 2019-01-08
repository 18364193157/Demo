//package com.test.zookeeper;
//
//import org.apache.zookeeper.*;
//import org.apache.zookeeper.data.Stat;
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * @Description：
// * @Author: lenho
// * @Date：2018/6/18 15:38
// */
//public class ZookeeperConnect {
//    public static void main(String[] args) {
//        try {
//            CountDownLatch countDownLatch = new CountDownLatch(1);
//            ZooKeeper zooKeeper = new ZooKeeper("192.168.232.128:2181,192.168.232.139:2181",
//                    4000, watchedEvent -> {
//                        if(watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
//                            countDownLatch.countDown();
//                        }
//                    });
//            countDownLatch.await();
//            System.out.println(zooKeeper.getState());
//
//            zooKeeper.create("/zookeeper-persit-lenho","0".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            Thread.sleep(1000);
//            Stat stat = new Stat();
//            byte[] bytes = zooKeeper.getData("/zookeeper-persit-lenho", null, stat);
//            System.out.println("value: " + new String(bytes));
//            System.out.println("stat.version: " + stat.getAversion());
//            Stat stat1 = zooKeeper.setData("/zookeeper-persit-lenho", "1".getBytes(), stat.getVersion());
//            System.out.println(stat.getAversion());
//            zooKeeper.delete("/zookeeper-persit-lenho",stat1.getVersion());
//            zooKeeper.close();
//            System.in.read();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
