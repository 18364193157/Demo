package com.test.currentandsafe.threadsafe;

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


        countAdd();
    }

    /**
     * var1:当前对象count，var2，当前对象count的值，var4要增加的数值（比如 count = 2 + 1，var2就是2，var4就是1）
     * public final int getAndAddInt(Object var1, long var2, int var4) {
     *         int var5;
     *         do {
     *             //获取底层(主内存)的count对象的值，如果没有其他线程的干预，var5的值应该是和var2相等的，也就是2，如果var2 = var5，那么执行var5 + var4
     *             var5 = this.getIntVolatile(var1, var2);
     *         } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
     *
     *         return var5;
     *     }
     */
    private static void countAdd() {
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
