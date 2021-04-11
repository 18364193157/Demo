package com.test.currentandsafe;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/12/12 14:52
 */
public class DemoOne {

    PrintRequest printRequest;
    private static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssS");

    public DemoOne() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        PrintRequest printRequest = new PrintRequest(saveProcessor);
        printRequest.start();
    }

    public static void main(String[] args) {
        Integer a = null;
        Integer integer = Optional.ofNullable(a).orElse(0);
        System.out.println(integer);
//        RequestDemo requestDemo = new RequestDemo();
//        requestDemo.setName("lenho");
//        DemoOne demoOne = new DemoOne();
//        demoOne.test(requestDemo);
//        long va = Long.valueOf("1111111111111111");
//        List<Long> longList = new ArrayList<>();
//        longList.add(1L);
//        System.out.println(JSON.toJSON(longList));

//        String s = "abc";
//        String s1 = StringUtils.leftPad(s, 6, "0");
//        String s2 = StringUtils.rightPad(s, 6, "1");
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println("=====================");
//        Date now = new Date();
//        String s3 = StringUtils.rightPad(DATE_FORMAT.format(now), 19, "0");
//        String s4 = StringUtils.leftPad("" + 1 % 10000, 4, "0");
//        System.out.println(DATE_FORMAT.format(now));
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println();
//        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
//        map.put("key",123);
//        map.put("key1",456);
//        Object key = map.putIfAbsent("key1", 123);
//        System.out.println(key);
//
//        System.out.println(map.get("key1"));


//
//        UUID uuid = UUID.randomUUID();
//        System.out.println(StringUtils.deleteWhitespace(uuid.toString()).substring(0,8));

//        ArrayList<String> objects = Lists.newArrayList();
//        objects.add(null);
//        System.out.println(objects.size());
//        String key = String.format("hist:%s:%s", 3051243, "page_view");
//        System.out.println(key);

//        JedisPool jedisPool = new JedisPool("localhost", 6379);
//        Jedis jedis = jedisPool.getResource();
//        for(int i=0;i<20;i++) {
//            System.out.println(isActionAllowed(jedis,"laoqian", "reply", 60, 5));
//        }
    }

    public static boolean isActionAllowed(Jedis jedis, String userId, String actionKey, int period, int maxCount) {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        System.out.println(nowTs);
        Pipeline pipe = jedis.pipelined();
        pipe.multi();
        pipe.zadd(key, nowTs, "" + nowTs);
        long l = nowTs - period * 1000;
        System.out.println(l);
        pipe.zremrangeByScore(key, 0, l);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        boolean b = count.get() <= maxCount;
        if(!b){
            Response<List<String>> lrange = pipe.lrange(key, 0, -1);
            System.out.println(lrange.get());
        }
        return b;
    }
}
