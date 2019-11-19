package com.test.current.threadsafe;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 【读锁与读锁不互斥，读锁与写锁互斥，写锁与写锁互斥】
 * @author langyonghe
 * @date 2019-11-19 15:35
 */
public class ReadWrite {
    private Object data = null;

    ReadWriteLock rwlock = new ReentrantReadWriteLock();

    /**
     * 读数据，可以多个线程同时读， 所以上读锁即可
     */
    public void get() {
        /* 上读锁 */
        rwlock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " 准备读数据!");
            /* 休眠 */
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "读出的数据为 :" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }

    }

    /**
     * 写数据，多个线程不能同时 写 所以必须上写锁
     *
     * @param data
     */
    public void put(Object data) {

        /* 上写锁 */
        rwlock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " 准备写数据!");
            /* 休眠 */
            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " 写入的数据: " + data);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }
    }



}
