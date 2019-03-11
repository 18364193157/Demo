package com.test.current.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *  如果周期设定的太短，那么下一个任务就会立即执行
 *
 * @author langyonghe
 * @create 2019-03-11 11:02
 */
public class ScheduleThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService ese = Executors.newScheduledThreadPool(10);
        //如果前面的任务没有完成，调度也不会启动
        ese.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis()/1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);



        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis()/1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },0,2,TimeUnit.SECONDS);
    }
}
