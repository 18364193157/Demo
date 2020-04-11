package com.test.lenho;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lenho on 2018/6/12.
 */
//@Slf4j
public class One {


//    public static   void  tes(Iterator iterator){
//        if(iterator.hasNext()){
//            Object next = iterator.next();
//            System.out.println(next);
//        }
//        if(iterator.hasNext()){
//            Object next = iterator.next();
//            tes(iterator);
//        }
//    }

    public static void main(String[] args) {
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(4);
//        list.add(3);
//        System.out.println(list);

//        String json = "{\"规1\":\"活动1\",\"规2\":\"10个库存\"}";
//        LinkedHashMap map = JSONObject.parseObject(json, LinkedHashMap.class);
//        if (null != map && !map.isEmpty()) {
//            Set keys = map.keySet();
//            Collection values = map.values();
//            String join = String.join("/", values);
//            System.out.println(join);
//        }
//        List<Student> list = new ArrayList<Student>();
//        list.add(new Student(1, "Mahesh", 12));
//        list.add(new Student(2, "Suresh", 15));
//        list.add(new Student(3, "Nilesh", 10));
//
//        Iterator<Student> iterator = list.iterator();
//        tes(iterator);
//        List<Student> slist = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
//        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));

//        String join = StringUtils.join(hashSet, ",");
//        System.out.println(join);
//        List<Integer> list2 = Arrays.asList(1,2,3,4);
//        HashSet h1 = new HashSet(list1);
//        HashSet h2 = new HashSet(list2);
//        h1.removeAll(h2);
//        list.addAll(h1);
//        System.out.println(list);



//        System.out.println(list2);

//        List<Long> a = Lists.newArrayList(1L,2L);
//        List<Long> b = Lists.newArrayList(2L);
//        a.removeAll(b);
//        System.out.println(a);


//
//        for (Integer i : list) {
//
//        }

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            if(list2.contains(iterator.next())){
//                iterator.remove();
//            }
//        }
//        System.out.println(list2);
//
////        String s = "中华  人民";
//        System.out.println(StringUtils.deleteWhitespace(s).contains("华人"));
//        System.out.println(s.contains("1231"));
//        BigDecimal b  = new BigDecimal(100.71+"");
//        BigDecimal multiply = b.subtract(new BigDecimal(0.0072+""));
//        System.out.println(multiply);
//        System.out.println(multiply.setScale(2,BigDecimal.ROUND_HALF_DOWN));
//        int i = b.compareTo(new BigDecimal(100.99));
//        System.out.println(i);
//        BigDecimal handFee = new BigDecimal(2).multiply(new BigDecimal(0.0025 + ""));
//        System.out.println(handFee.compareTo(new BigDecimal(0.005+"")));

//        List<Integer> list = Arrays.asList(1, 2, 3, 4);
//        System.out.println(JSON.toJSONString(list));
//        for (Integer integer: list) {
//            integer++;
//        ReqBargainGoods reqBargainGoods = new ReqBargainGoods();
//        reqBargainGoods.setBarCode("123");
//        List<BargainGoodsDTO> list = new ArrayList<>();
//        BargainGoodsDTO bargainGoodsDTO = new BargainGoodsDTO();
//        bargainGoodsDTO.setBargainStart("2019-06-05 02:56:55");
//        bargainGoodsDTO.setBargainEnd("2019-06-06 02:56:55");
//        bargainGoodsDTO.setBargainPrice(new BigDecimal(12));
//        bargainGoodsDTO.setMemberPrice(new BigDecimal(14));
//        bargainGoodsDTO.setRetailPrice(new BigDecimal(15));
//        bargainGoodsDTO.setBargainStock(2);
//        bargainGoodsDTO.setMaxNumber(2);
//        List<Long> mutex = new ArrayList<>();
//        mutex.add(3014796493212565528L);
//        mutex.add(3065304965016420562L);
//        bargainGoodsDTO.setMutexSpu(mutex);
//        bargainGoodsDTO.setSaleScene(1);
//        bargainGoodsDTO.setSpuId(3030222160313982988L);
//        bargainGoodsDTO.setSkuId(3030222160313982990L);
//        list.add(bargainGoodsDTO);
//
//
//        BargainGoodsDTO bargainGoodsDTO2 = new BargainGoodsDTO();
//        bargainGoodsDTO2.setBargainStart("2019-06-04 02:56:55");
//        bargainGoodsDTO2.setBargainEnd("2019-06-05 02:56:55");
//        bargainGoodsDTO2.setBargainPrice(new BigDecimal(10));
//        bargainGoodsDTO2.setMemberPrice(new BigDecimal(11));
//        bargainGoodsDTO2.setRetailPrice(new BigDecimal(13));
//        bargainGoodsDTO2.setBargainStock(2);
//        bargainGoodsDTO2.setMaxNumber(2);
//        bargainGoodsDTO2.setMutexSpu(mutex);
//        bargainGoodsDTO2.setSaleScene(1);
//        bargainGoodsDTO2.setSpuId(3030222160313982988L);
//        bargainGoodsDTO2.setSkuId(3030222160313982990L);
//        list.add(bargainGoodsDTO2);
//        reqBargainGoods.setList(list);
//        System.out.println(JSON.toJSONString(list));
//        reqBargainGoods.setList(list);

//        System.out.println(JSON.toJSONString(reqBargainGoods));
//            System.out.println(integer);
//        }
//        City city = new City();
//        List<CityCopy> cityCopies = new ArrayList<>();
//        CityCopy cityCopy = new CityCopy();
//        cityCopy.setName("杭州");
//        cityCopy.setSize(true);
//        cityCopies.add(cityCopy);
////
//        CityCopy cityCopy1 = new CityCopy();
//        cityCopy1.setName("绍兴");
//        cityCopy1.setSize(null);
//        cityCopies.add(cityCopy1);
//        Map<Boolean, List<CityCopy>> collect = cityCopies.stream().collect(Collectors.groupingBy(CityCopy::getSize));

        List<String> stringList = new ArrayList();
        stringList.add("http://img.mockuai.com/images/201601/06/10/20160106101708186.jpg");
        stringList.add("http://img.mockuai.com/images/201601/06/10/20160106101708869.jpg");
        stringList.add("http://img.mockuai.com/images/201603/17/19/20160317190713949.png@0e_200w_200h_90Q.png");
        System.out.println(JSON.toJSONString(stringList));

//        List<Cone> cones = new ArrayList<>();
//        Cone cone = new Cone("小明",10);
//        cones.add(cone);
//        cityCopy.setConeList(cones);
//        cityCopies.add(cityCopy1);
//        cityCopies.add(cityCopy);
//        System.out.println(JSON.toJSONString(cityCopies));
//        city.setCityCopies(cityCopies);

//        System.out.println(JSON.toJSONString(city));
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
