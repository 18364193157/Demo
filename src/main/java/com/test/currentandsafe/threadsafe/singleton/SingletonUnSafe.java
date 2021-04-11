package com.test.currentandsafe.threadsafe.singleton;

/**
 * 描述:线程不安全的单例，不安全的事17到19行。
 * 原因：当两个线程同时调用getInstance()方法的时候，同时走到18行，两个线程都会判断instance为null，
 *       这时候，私有构造方法就会被调用两次，如果私有构造的方法内部存在比较多的逻辑（资源处理、数据准备等），如果
 *       运算两次就可能出现错误。
 *
 * @author langyonghe
 * @create 2019-03-12 10:05
 */
public class SingletonUnSafe {

    private SingletonUnSafe() {
    }

    private static SingletonUnSafe instance = null;

    public static SingletonUnSafe getInstance(){
        if(instance == null) {
            instance = new SingletonUnSafe();
        }
        return instance;
    }
}
