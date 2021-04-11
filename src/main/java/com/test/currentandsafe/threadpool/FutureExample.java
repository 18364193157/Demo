package com.test.currentandsafe.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author langyonghe
 * @date 2021/3/8 15:16
 */
@Slf4j
public class FutureExample {



    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("Done something in Callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<String> future = executorService.submit(new MyCallable());
//        log.info("do something in main");
//        Thread.sleep(1000);
//        String result = future.get();
//        log.info("result: {}", result);


        FutureTask<String> futureTask = new FutureTask<>((Callable<String>) () -> {
            log.info("Done something in Callable");
            Thread.sleep(5000);
            return "Done";
        });
        executorService.submit(futureTask);
        log.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result: {}", result);

    }
}
