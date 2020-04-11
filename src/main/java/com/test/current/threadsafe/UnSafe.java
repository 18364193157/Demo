package com.test.current.threadsafe;

import com.google.common.collect.Lists;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

/**
 * @author langyonghe
 * @date 2020-04-11 10:31
 */
public class UnSafe {
    public static void main(String[] args) {
        List<String> list = Lists.newCopyOnWriteArrayList();
        list.add("123");
        list.add("456");
        list.add("789");
//        System.out.println(list);


    }
}
