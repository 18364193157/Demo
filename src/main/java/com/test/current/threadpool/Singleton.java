package com.test.current.threadpool;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-03-12 10:05
 */
public class Singleton  {
    private Singleton() {
    }

    private static class SingletonHolder{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
