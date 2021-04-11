package com.test.currentandsafe;

import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/12/13 10:19
 */
public class ThreadOne {
    public static void main(String[] args)  {
        Thread thread = new Thread(()-> {
            try {
                System.out.println("开始睡眠");
                Thread.sleep(1000);
                System.out.println("before:" + Thread.interrupted()); //true
                System.out.println("睡眠结束");
            } catch (InterruptedException e) {
                System.out.println("睡眠异常");
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("c超时出现错误");
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("after:" + Thread.interrupted());//false 线程复位
    }
}
