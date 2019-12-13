package com.test;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.lenho.City;
import com.test.lenho.CityCopy;
import com.test.lenho.One;
import org.joda.time.DateTimeUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-03-21 11:52
 */
public class HelloWorld {

    static int count = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        Map map = new HashMap();
//        map.put("sdf",null);
//        System.out.println(map);
//        GsonBuilder builder = new GsonBuilder();
//        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        builder.disableHtmlEscaping();
//        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
//
//
//        City city = new City();
//        city.setTime(new Date());
//        city.setALong(3L);
//        Gson gson = builder.create();
//        String s = gson.toJson(city);
//        System.out.println(s);
//
//        System.out.println(System.currentTimeMillis());
//        String json = "{\n" +
//                "\t\"time\": \"2019-12-10 11:19:01\",\n" +
//                "\t\"a_double_double\": 0.0,\n" +
//                "\t\"a_long\": 3,\n" +
//                "\t\"an_int\": 0,\n" +
//                "\t\"a_boolean\": false,\n" +
//                "\t\"city_copies\": []\n" +
//                "}";
//        City city1 = gson.fromJson(json, City.class);
//        System.out.println(city1);

//        new BigDecimal("zhon").multiply(new BigDecimal("100"));
        while (true){
            LoadingCache<String,Long> localCache = CacheBuilder.newBuilder()
                    .expireAfterWrite(5, TimeUnit.SECONDS)
                    .build(new CacheLoader<String, Long>() {
                        @Override
                        public Long load(String key) {
                            System.out.println(key+":"+ (System.currentTimeMillis()/1000));
                            return 1L;
                        }
                    });
        }


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000; i++) {
//                    count++;
//                }
//            }
//        });
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000; i++) {
//                    count++;
//                }
//            }
//        });
//        thread.start();
//        thread1.start();
//        thread1.join();
//        System.out.println(count);
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
