package com.test.java8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/12/28 14:37
 */
public class A {
    public static void main(String[] args) {
//        Apple apple = new Apple(1);
//        Apple apple1 = new Apple(2);
//        List<Apple> list = new ArrayList();
//        list.add(apple1);
//        list.add(apple);
//        String s = JSON.toJSONString(list, true);
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        System.out.println(s);
//        System.out.println("==========");
//        System.out.println(jsonObject);
        System.out.println(String.valueOf(Long.MAX_VALUE).length());
//
//        System.out.println(list);
//        //排序
//        list.sort(Comparator.comparing(Apple::getA));
//        System.out.println(list);
////        Collections.sort(list, new Comparator<Apple>() {
////            @Override
////            public int compare(Apple o1, Apple o2) {
////                return o1.getA().compareTo( o2.getA()) ;
////            }
////        });
//        //过滤
//        List<Apple> collect = list.stream().filter(apple2 -> apple2.getA() == 1).collect(Collectors.toList());
//        System.out.println(collect);
    }
}
@Data
@AllArgsConstructor
class Apple{
    private Integer a;
}
