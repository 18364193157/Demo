package com.test.current.threadpool;

import java.util.concurrent.*;

/**
 * 描述:
 * 在线程池寻找堆栈信息
 *
 * @author langyonghe
 * @create 2019-03-11 14:10
 */
public class DivThreadPool {
    public static class DivTask implements Runnable{
        int a;
        int b;
        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a/b;
            System.out.println(re);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++){
//            Future<?> f = pools.submit(new DivTask(100, i));
//            f.get();
            pools.execute(new DivTask(100,i));
        }
    }
}
