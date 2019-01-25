package com.test.controller;

import com.test.lenho.City;
import lombok.Data;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/12/26 16:39
 */
@Data
public class DE {
    private Long id;


    public static void main(String[] args) {
        City city = new City();
        city.setName("杭州");
        boolean exist = "杭州".equals(city.getName());
//        exist = false;
        if (exist){
            int a = 0;
            String name = city.getName();
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
