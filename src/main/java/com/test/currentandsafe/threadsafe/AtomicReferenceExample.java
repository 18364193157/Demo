package com.test.currentandsafe.threadsafe;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author langyonghe
 * @date 2020-04-11 10:31
 */
@Slf4j
public class AtomicReferenceExample {


    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    /**
     * 比较一个对象中的某个字段的值，同时传入该字段的值必须被volatile修饰，如果是
     */
    private static AtomicIntegerFieldUpdater<AtomicReferenceExample> atomicIntegerFieldUpdater
            = AtomicIntegerFieldUpdater.newUpdater(AtomicReferenceExample.class, "count");
    @Getter
    private volatile int count = 100;

    public static void main(String[] args) {

        AtomicReferenceExample atomicReferenceExample = new AtomicReferenceExample();
        atomicIntegerFieldUpdater.compareAndSet(atomicReferenceExample,100,200);


        atomicReference.compareAndSet(0,2);
        atomicReference.compareAndSet(0,1);
        atomicReference.compareAndSet(1,3);
        atomicReference.compareAndSet(2,4);

    }
}
