package com.test.current.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description：原子性问题
 * @Author: lenho
 * @Date：2018/12/13 10:52
 */
public class AtomicDemo {
    private static AtomicInteger count = new AtomicInteger(0);
    public static void inc()  {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.incrementAndGet();
    }

    public static  void main(String[] args) throws InterruptedException {
        for(int i = 0; i<1000; i++) {
            new Thread(AtomicDemo::inc).start();
        }
        Thread.sleep(4000);
        System.out.println(count);
    }
}
