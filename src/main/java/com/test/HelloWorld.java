package com.test;

import com.alibaba.fastjson.JSON;
import com.test.lenho.City;
import com.test.lenho.CityCopy;
import com.test.lenho.One;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-03-21 11:52
 */
public class HelloWorld {

    static int count = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        });
        thread.start();
        thread1.start();
        thread1.join();
        System.out.println(count);
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        for (Integer integer : list){
//            System.out.println(integer);
//        }
//        CityCopy cityCopy = new CityCopy();
//        cityCopy.setName("zhongnanhai");
//        cityCopy.setSize(true);
//        City city = new City();
//        city.setName("12");
//        city.setAge(2L);
//        city.setJson(JSON.toJSONString(cityCopy));
//        System.out.println(JSON.toJSONString(city));
//        Map map = new ConcurrentHashMap();
//        map.put("sdf",null);
    }
}
