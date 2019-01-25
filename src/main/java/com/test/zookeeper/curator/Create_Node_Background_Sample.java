package com.test.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description：利用线程池来执行回调事件
 *      zookeeper如果不传入线程池，所有的异步通知事件都是由EventThread这个线程
 *      来处理的——EventThread线程用于串行处理所有的事件通知，一旦碰上复杂的处理
 *      单元，就会消耗过长的处理时间，从而影响对其他时间的处理。
 * @Author: lenho
 * @Date：2018/7/5 10:02
 */
public class Create_Node_Background_Sample {

    static String path = "/zk-book";

    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.232.128:2181,192.168.232.129:2181")
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000,3))
            .build();
    static CountDownLatch semaphore = new CountDownLatch(2);
    static ExecutorService tp = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws Exception {
        client.start();
        System.out.println("Main thread: " + Thread.currentThread().getName());
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("event[code: " + event.getResultCode() + ", type:"
                + event.getType() +"]");
                System.out.println("Thread of processResult:" + Thread.currentThread().getName());
                semaphore.countDown();
            }
        },tp).forPath(path,"init".getBytes());

        //没有传入线程池
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("event[code: " + event.getResultCode() + ", type:"
                        + event.getType() +"]");
                System.out.println("Thread of processResult:" + Thread.currentThread().getName());
                semaphore.countDown();
            }
        }).forPath(path,"init".getBytes());
    }
}
