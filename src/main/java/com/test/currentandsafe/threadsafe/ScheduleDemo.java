package com.test.currentandsafe.threadsafe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-03-07 9:26
 */
@Slf4j
public class ScheduleDemo {

    public static void main(String[] args) {
//        周期性执行
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(8000);
                System.out.println(System.currentTimeMillis()/1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },0,2, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("==================");
            ses.shutdown();
        }));
    }
}
