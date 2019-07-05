package com.test.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/6/23 17:29
 */
public class ZKConnector {
    //连接重试策略
    static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
    //创建连接
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.232.22:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(retryPolicy)
            .build();
    public static void main(String[] args) throws Exception {


        //创建连接
//        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.232.128:2181,192.168.232.130:2181",
//                5000, 3000, retryPolicy);

        client.start();
        //创建节点
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath("/zk-book/c1","init".getBytes());
//        Stat stat = new Stat();
//        client.getData().storingStatIn(stat).forPath("/zk-book/c1");
//        client.delete().guaranteed().deletingChildrenIfNeeded().withVersion(stat.getVersion()).forPath("/zk-book/c1");
        client.close();
    }
}
