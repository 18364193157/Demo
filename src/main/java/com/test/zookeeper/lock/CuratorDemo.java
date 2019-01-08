//package com.test.zookeeper.lock;
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * @Description：
// * @Author: lenho
// * @Date：2018/7/5 16:45
// */
//public class CuratorDemo {
//    public static void main(String[] args) throws Exception {
//        CountDownLatch countDownLatch=new CountDownLatch(10);
//        for(int i=0;i<10;i++){
//            new Thread(()->{
//                try {
//                    countDownLatch.await();
//                    DistributedLock distributedLock=new DistributedLock();
//                    distributedLock.lock(); //获得锁
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            },"Thread-"+i).start();
//            countDownLatch.countDown();
//        }
//        System.in.read();
//
//    }
//}
