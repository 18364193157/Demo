package com.test.currentandsafe.threadsafe.singleton;

/**
 *
 *
 *
 * @author langyonghe
 * @create 2019-03-12 10:05
 */
public class SingletonBestSafe {

    private SingletonBestSafe() {
    }

    /**
     * 禁止该对象发生指令重排即可
     */
    private volatile static SingletonBestSafe instance = null;


    public static SingletonBestSafe getInstance(){
        if(instance == null) {
            synchronized(SingletonBestSafe.class){
                if(instance == null ) {
                    instance = new SingletonBestSafe();
                }
            }
        }
        return instance;
    }
}
