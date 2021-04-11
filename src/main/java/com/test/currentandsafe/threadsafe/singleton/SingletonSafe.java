package com.test.currentandsafe.threadsafe.singleton;

/**
 * 描述: 饿汉模式单例线程安全
 * 缺点：如果这个构造方法中存在过多的逻辑，加载就会比较慢，可能会出现性能问题，如果没有调用，更会造成资源浪费
 *
 *
 * @author langyonghe
 * @create 2019-03-12 10:05
 */
public class SingletonSafe {
    private SingletonSafe() {
    }

    private static class SingletonHolder{
        private static SingletonSafe instance = new SingletonSafe();
    }

    public static SingletonSafe getInstance(){
        return SingletonHolder.instance;
    }
}
