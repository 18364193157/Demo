package com.test.current.threadpool;

import java.util.concurrent.*;

/**
 * 描述:
 *      自定义线程池拒绝策略和线程池工厂
 * @author langyonghe
 * @create 2019-03-11 11:20
 */
public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() +":Thread ID:" + Thread.currentThread().getId());
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        //使用无界队列容易把内存撑爆，自定义拒绝策略中，不可抛出异常，因为万一任务提交端没有进行异常处理，则有可能使得整个系统崩溃
        ThreadPoolExecutor es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(10), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                System.out.println("create" + thread);
                return thread;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + "is discard");
            }
        });

        for (int i = 0; i<Integer.MAX_VALUE; i++){
           es.submit(myTask);
           Thread.sleep(10);
        }


    }
}
