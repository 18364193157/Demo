package com.test.lenho;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by lenho on 2018/6/12.
 */
@Slf4j
public class One {
    public static void main(String[] args) {
//        List<String> list1 =new ArrayList<String>();
//        list1.add("1C2");
//        list1.add("6A1");
//
//        List<String> list2 =new ArrayList<String>();
//        list2.add("1C2");
//        list2.add("6A1");
//        System.out.println(list2.contains(null));
//
//        List<String> list =new ArrayList<String>();
//        list.addAll(list1);
//        list.addAll(list2);
//        Double d = new Double(2.22);
//        System.out.println((UUID.randomUUID().toString().replaceAll("-","").length()));
//        List<City> list =new ArrayList<City>();
//        Long long1 = 5L;
//        Long long2 = 10L;
//        Map map = new HashMap();
//        map.put("123","456");
//        System.out.println(JSON.toJSONString(map));


//        byte a = (byte) strings.charAt(0);
//        byte z = (byte) strings.charAt(4);
//        System.out.println(z);
//        System.out.println(a);
//        String strings = "afbdz";
//        String[] split = strings.split("");
//        Arrays.sort(split);
//        int length = strings.length();
//        for (int i = length; i >= 0; i--){
//            byte value1 = (byte) strings.charAt(i);
//            byte value2 = (byte) strings.charAt(i - 1);
//            if(value1 < value2) {
//                char value22 = (char) value2;
//
//            }
//        }


//        System.out.println(long2.compareTo(long1));
//        City city1 = new City();
//        city1.setName("1");
//        city1.setAge(2L);
//        CityCopy cityCopy1 = new CityCopy();
//        cityCopy1.setName("312");
//        cityCopy1.setSize(true);
//        city1.setCityCopy(cityCopy1);
//        City city2 = new City();
//        city2.setName("1");
//        city2.setAge(2L);
//        CityCopy cityCopy2 = new CityCopy();
//        cityCopy2.setName("312");
//        cityCopy2.setSize(true);
//        city2.setCityCopy(cityCopy2);
//        list.add(city1);
//        list.add(city2);
//        list.forEach(e ->{
//            CityCopy cityCopy = e.getCityCopy();
//            cityCopy.setName(null);
//        });
//        System.out.println(list);
//        log.info("-req : {}",list);
//        System.out.println(list);
//        Set<City> set = new HashSet<>();
//        for(int i = 0; i < 2; i++) {
//            City city = new City();
//            city.setName("1");
//            city.setAge(2L);
//            set.add(city);
//        }
//        System.out.println(set);
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2018, 10, 15, 0, 0, 0);
//        System.out.println(calendar.getTimeInMillis());

//        list1.add("4B3");
//        list1.add("4B3");
//        System.out.println(list1);
//        SortedSet sortedSet = new TreeSet();
//        for (String e : list1) {
//            sortedSet.add(e);
//        }
//        System.out.println(sortedSet);
//        System.out.println(sortedSet.last());
//        System.out.println(sortedSet.headSet(sortedSet.last()));

//        long time = new Date().getTime();
//        System.out.println(time);

//        System.out.println(String.valueOf(new Date()));
//        List<City> list = new ArrayList<>();
//        String s = "中国";
//        System.out.println(s.length());
//        Long g = 1L;
//        Long gg = 2L;
//        System.out.println(g.equals(gg));
//        System.out.println(g == gg);
//        String st = "7,6,9,12,3,5";
//        String[] split = st.split(",");
//        List<String> list = Arrays.asList(split);
//        System.out.println(list.contains("7"));
//        System.out.println("xg_131".substring(3));
//        City.CityBuilder zhejiang = City.builder().name("zhejiang").age(23L);
//        System.out.println(zhejiang);

//        City city = new City();
//        city.setAge(1L);
//        list.add(city);
//        list.forEach(e ->{
//            e.setAge(e.getAge() + 1L);
//        });
//        System.out.println(list);
//        List<String> list2 =new ArrayList<String>();
//        list1.removeAll(list2);
//        System.out.println(list1);
//        list2.add("B");
//        list2.addAll(list1);
//        boolean b = list1.removeAll(list2);
//        System.out.println(b);
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(3/5 + 1);


//        System.out.println(Long.parseLong(null));

//        City city = new City();
//        System.out.println(city);

//        System.out.println(String.valueOf(null));
//        PageUtil pageUtil = new PageUtil();
//        List<String> content = new ArrayList<String>();
//        content.add("str1");
//        content.add("str2");
//        content.add("str3");
//        content.add("str4");
//        content.add("str5");
//        content.add("str6");
//        content.add("str7");
//        pageUtil.setCurrentPage(3);
//        pageUtil.setPageSize(5);
//        pageUtil.setAllContent(content);
//        System.out.println(pageUtil.getCurrentContent());
    }
}
