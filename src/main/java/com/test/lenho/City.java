package com.test.lenho;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lenho
 * @Description：
 * @Date：2018/6/13 16:17
 */
@Data
public class City implements Serializable{

    private CityCopy cityCopy;

    private String name;

    private Long age;

    private Double aDouble;

    private double aDoubleDouble;

    private long aLong;

    private Integer history;

    private int anInt;

    private Boolean size;

    private boolean aBoolean;

    private List<CityCopy> cityCopies = new ArrayList<>();


}
