package com.test.lenho;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: lenho
 * @Description：
 * @Date：2018/6/13 16:17
 */
@Data
public class City implements Serializable{

//    private CityCopy cityCopy;
//
    private List<Integer> numList;
//
    private Long age;

    private Date time;

    private Double aDouble;

    private double aDoubleDouble;

    private long aLong;

    private Integer history;

    private int anInt;

    private Boolean size;

    private boolean aBoolean;

    private List<CityCopy> cityCopies = new ArrayList<>();

    private String json;

    public static void main(String[] args) {
//        City city = new City();
//        city.setName("aasjdfkaj");
//        System.out.println(JSON.toJSONString(city));
//        City city = new City();
//        List<Integer> list = Arrays.asList(1, 2);
//        city.setNumList(list);
//        System.out.println(JSON.toJSONString(city));
//        List<Integer> numList = city.getNumList();
//        city.setNumList(numList);
//        System.out.println(JSON.toJSONString(city));
        BigDecimal bigDecimal = new BigDecimal(2);
        System.out.println(bigDecimal);

    }
}
