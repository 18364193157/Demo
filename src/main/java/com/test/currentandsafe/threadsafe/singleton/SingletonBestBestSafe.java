package com.test.currentandsafe.threadsafe.singleton;

/**
 * 最推荐的，
 * @author langyonghe
 * @date 2021/3/8 11:19
 */
public class SingletonBestBestSafe {

    private SingletonBestBestSafe(){}

    /**
     * 相比懒汉，线程安全
     * 相比饿汉，只有被使用的时候会被调用，因为饿汉会直接定义为static模式
     * @return
     */
    public static SingletonBestBestSafe getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        /**/
        INSTANCE;

        private SingletonBestBestSafe singletonBestBestSafe;

        /**
         * JVM保证该方法绝对只会被调用一次， 只有被使用的时候会被调用
         */
        Singleton() {
            singletonBestBestSafe = new SingletonBestBestSafe();
        }

        public SingletonBestBestSafe getInstance() {
            return singletonBestBestSafe;
        }
    }
}
