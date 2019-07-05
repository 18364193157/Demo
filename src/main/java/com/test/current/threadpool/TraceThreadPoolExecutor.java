package com.test.current.threadpool;

import java.util.concurrent.*;

/**
 * 描述:
 * 扩展线程池
 *
 * @author langyonghe
 * @create 2019-03-11 14:28
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }

    private Runnable wrap(Runnable task, final Exception clientStack, String clientThreadName) {

        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                }catch (Exception e){
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }
    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }


    public static void main(String[] args) {
        TraceThreadPoolExecutor pools = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++){
            pools.execute(new DivThreadPool.DivTask(100,i));
        }
    }
}
