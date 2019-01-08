package com.test.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @Description：节点监听
 * @Author: lenho
 * @Date：2018/7/5 11:18
 */
public class PathChildCache_Sample {
    static String path = "/zk-book";
    //连接重试策略
    static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
    //创建连接
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.232.128:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(retryPolicy)
            .build();

    public static void main(String[] args) throws Exception {
        client.start();
        PathChildrenCache childrenCache = new PathChildrenCache(client,path,true);
        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        childrenCache.getListenable().addListener((curatorFramework, event) -> {
            switch (event.getType()){
                case CHILD_ADDED:
                    System.out.println("CHILD_ADDED，" + event.getData().getPath());
                    break;
                case CHILD_UPDATED:
                    System.out.println("CHILD_UPDATED, "+ event.getData().getPath());
                    break;
                case CHILD_REMOVED:
                    System.out.println("CHILD_REMOVED, " + event.getData().getPath());
                    break;
                    default:
                        break;
            }
        });
        client.create().withMode(CreateMode.PERSISTENT).forPath(path);
        Thread.sleep(1000);
        client.create().withMode(CreateMode.PERSISTENT).forPath(path + "/c1");
        Thread.sleep(1000);
        client.delete().forPath(path + "/c1");
        Thread.sleep(1000);
        client.delete().forPath(path);
        Thread.sleep(Integer.MAX_VALUE);

    }
}
