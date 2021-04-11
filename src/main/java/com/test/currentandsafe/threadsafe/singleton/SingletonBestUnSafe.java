package com.test.currentandsafe.threadsafe.singleton;

/**
 *  双重检查情况下，如果指令重排是线程不安全的
 *
 *
 * @author langyonghe
 * @create 2019-03-12 10:05
 */
public class SingletonBestUnSafe {

    private SingletonBestUnSafe() {
    }

    private static SingletonBestUnSafe instance = null;

    /**
     * synchronized加到方法上，只会允许一个线程调用，性能较差，如下便会有较好的实现，双重校验机制
     * 如下：线程也不安全，因为在 new SingletonBestUnSafe();分三步
     * 第一 分配内存空间memory
     * 第二 初始化对象instance
     * 第三 设置instance指向分配的内存 instance = memory
     *
     * 单线程的情况下的指令重排不影响
     * jvm和CPU发生指令重排，出现的顺序变为
     * 第一 分配内存空间memory
     * 第三 设置instance指向分配的内存 instance = memory
     * 第二 初始化对象instance
     * @return
     */
    public static SingletonBestUnSafe getInstance(){
        if(instance == null) { //当A线程到下面的状态，B线程到这里发现instance不为null，直接返回了instance，但是B还没进行初始化对像，这样调用会发生错误
            synchronized(SingletonBestUnSafe.class){
                if(instance == null ){
                    instance = new SingletonBestUnSafe();//当A线程走到这里的运行到三
                }
            }
        }
        return instance;
    }
}
