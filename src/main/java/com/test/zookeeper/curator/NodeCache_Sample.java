package com.test.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @Description：节点数据监听
 * @Author: lenho
 * @Date：2018/7/5 10:41
 */
public class NodeCache_Sample {
    static String path = "/zk-book/nodecache";
    //连接重试策略
    static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
    //创建连接
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.130.11:2181,192.168.130.13:2181,192.168.130.13:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(retryPolicy)
            .build();

    public static void main(String[] args) throws Exception {
        client.start();
        client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath(path,"inti".getBytes());
        final NodeCache nodeCache = new NodeCache(client,path,false);
        //默认是false,设置为true，那么NodeCache在第一次启动的时候就会立刻从Zookeeper上读取对应节点的数据内容,并保存到Cache
        nodeCache.start(true);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("Node data update, new data:" + new String(nodeCache.getCurrentData().getData()));
            }
        });
        client.setData().forPath(path,"u".getBytes());
        Thread.sleep(1000);
        client.delete().deletingChildrenIfNeeded().forPath(path);
        Thread.sleep(Integer.MAX_VALUE);

    }
}
