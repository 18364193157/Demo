package com.test.currentandsafe.threadsafe;

import java.util.Random;

/**
 * @author langyonghe
 * @date 2019-11-19 15:37
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {

        /* 创建ReadWrite对象 */
        final ReadWrite readWrite = new ReadWrite();

        /* 创建并启动3个读线程 */
        for (int i = 0; i < 3; i++) {
            new Thread(() -> readWrite.get()).start();

            /*创建3个写线程*/
            new Thread(() -> {
                /*随机写入一个数*/
                readWrite.put(new Random().nextInt(8));

            }).start();
        }
    }
}
