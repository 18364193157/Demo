package com.test.current.threadsafe;

import java.util.concurrent.TimeUnit;

/**
 * @Description：可见性问题
 * @Author: lenho
 * @Date：2018/12/13 10:42
 */
public class VisableDemo {
    private static volatile boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() ->{
//            int i = 0;
//            while (!stop) {
//               i++;
//                System.out.println(i);
//            }
//        });
//        thread.start();
//        TimeUnit.SECONDS.sleep(3);
//        stop = true;


        new Thread(() ->{
            System.out.println("Ordinary A is running...");
            while (!stop) ;
            System.out.println("Ordinary A is terminated.");
        }).start();


        Thread.sleep(10);
        new Thread(() -> {
            System.out.println("Ordinary B is running...");
            stop = true;
            System.out.println("Ordinary B is terminated.");
        }).start();
    }
}
