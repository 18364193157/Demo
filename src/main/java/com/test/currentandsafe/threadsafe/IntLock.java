package com.test.currentandsafe.threadsafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *      死锁
 *
 * @author langyonghe
 * @create 2019-03-06 14:05
 */
public class IntLock implements Runnable{

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            if(lock == 1){
                lock1.lockInterruptibly();
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                }
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                }
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
                System.out.println(Thread.currentThread().getId() + ": 线程退出");
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread thread1 = new Thread(r1);//线程1首先占用lock1，然后占用lock2
        Thread thread2 = new Thread(r2);//线程2首先占用lock2，然后占用lock1
        thread1.start();thread2.start();
        Thread.sleep(1000);
        //中断其中的一个线程
        thread2.interrupt();
    }
}
