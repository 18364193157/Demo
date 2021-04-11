package com.test.currentandsafe;

import java.util.concurrent.CountDownLatch;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/12/26 14:32
 */
public class CountDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() ->{
            System.out.println("11111111111111");
            countDownLatch.countDown();
        }).start();
        new Thread(() ->{
            System.out.println("22222222222222");
            countDownLatch.countDown();
        }).start();
        new Thread(() ->{
            System.out.println("33333333333333");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("执行完毕");
    }


}

