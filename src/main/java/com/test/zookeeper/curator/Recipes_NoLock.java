package com.test.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @Description：分布式锁
 * @Author: lenho
 * @Date：2018/7/5 11:38
 */
public class Recipes_NoLock {
    static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("HH:mm:ss|SSS"));
    static String lock_path = "/curator_recipes_lock_path";
    //连接重试策略
    static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
    //创建连接
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(retryPolicy)
            .build();
    public static void main(String[] args) {
        client.start();
        final InterProcessLock lock = new InterProcessMutex(client,lock_path);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    lock.acquire();
                } catch (Exception e) {}
                SimpleDateFormat simpleDateFormat = threadLocal.get();
//                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                String orderNo = simpleDateFormat.format(new Date());
                System.out.println("生成的订单号 ：" + orderNo);
                try {
                    lock.release();
                } catch (Exception e) {}
            }).start();
        }
        countDownLatch.countDown();
    }
}
