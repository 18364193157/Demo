package com.test.lenho;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/6/15 15:06
 */
@Data
public class CityCopy {

    private String name;

    private Boolean size;

    public static void main(String[] args) {
        City city = new City();
        city.setName("123");
        city.setSize(true);
        CityCopy cityCopy = new CityCopy();
        BeanUtils.copyProperties(city,cityCopy);
        System.out.println(cityCopy);
    }
}
