package com.test.lenho;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/6/15 15:06
 */
@Data
public class CityCopy {

    private String name;

    private Boolean size;

    private List<Cone> coneList = new ArrayList<>();

    public static void main(String[] args) {
//        City city = new City();
//        city.setName("123");
//        city.setSize(true);
//        CityCopy cityCopy = new CityCopy();
//        BeanUtils.copyProperties(city,cityCopy);
//        System.out.println(cityCopy);
    }
}
@Data
@AllArgsConstructor
class Cone{
    private String name;
    private int age;
}