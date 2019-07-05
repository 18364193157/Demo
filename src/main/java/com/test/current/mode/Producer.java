package com.test.current.mode;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-03-12 11:16
 */
public class Producer implements Runnable {

    private volatile Boolean isRunning = true;
    private BlockingDeque<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingDeque<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("start producer id=" + Thread.currentThread().getId());
        try{
            while (isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());
                System.out.println(data + "is put in to queue");
                //提交数据到缓冲区中
                if(!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("failed to put data:" + data);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void  stop(){
        isRunning = false;
    }
}
