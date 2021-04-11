package com.test.currentandsafe.threadsafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *      重入锁
 *          1.重入的概念是针对一个线程来说的重入锁保护临界区资源i,一个线程可以连续两次获得同一把锁，如果不允许的话，那么同一个线程的第二次获取锁时，将会和自己产生死锁；
 *          2.可以中断一个线程对锁的请求（如果一个线程正在等待锁，那么它依然可以收到一个通知，高知无须等待，可以停止工作，对处理死锁有一定的帮助）；
 * @author langyonghe
 * @create 2019-03-06 13:46
 */
public class ReenterLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public  void  run() {
        for (int j=0;j<1000000;j++){
            lock.lock();
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock t1 = new ReenterLock();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t1);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
