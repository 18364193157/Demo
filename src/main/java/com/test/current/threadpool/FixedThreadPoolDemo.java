package com.test.current.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 * 1552272663: Thread ID:15
 * 1552272663: Thread ID:11
 * 1552272663: Thread ID:12
 * 1552272663: Thread ID:13
 * 1552272663: Thread ID:14
 * 1552272664: Thread ID:14
 * 1552272664: Thread ID:13
 * 1552272664: Thread ID:12
 * 1552272664: Thread ID:11
 * 1552272664: Thread ID:15
 *
 * 前5个任务和后5个任务正好相差1秒钟，并且线程ID也是完全一致的，说明这10个任务分成2批次执行的。
 *
 * @author langyonghe
 * @create 2019-03-11 10:45
 */
public class FixedThreadPoolDemo {

    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() /1000 + ": Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++){
            es.submit(myTask);
        }
    }
}
