package com.test.atomic;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author langyonghe
 * @date 2021/3/23 16:48
 */
public class AtomicTest {

    private static AtomicReference<String> atomicReference = new AtomicReference<>();

    public static void getJSON() {
        if(Objects.isNull(atomicReference.get())) {
            atomicReference.set("success");
            throw new RuntimeException("123");
        }
        System.out.println(132);
    }

    public static void sout(){
        System.out.println(atomicReference.get());
    }


    public static void main(String[] args) {
//        getJSON();
        String[] split = "12.1.0.2.0".split("\\.");
        System.out.println(split[0]);
    }
}
