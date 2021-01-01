package com.test;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

import java.io.File;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setOut;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-01-23 18:10
 */
public class TestOne {

    private KeyWordExecutor  keyWordExecutor;
    public TestOne(KeyWordExecutor keyWordExecutor) {
        this.keyWordExecutor = keyWordExecutor;
    }

    public TestOne() {



//        String num = "asdf.ASD";
//        String s = "asfas.ASD";
//        String s1 = "safd.SDD";
//        List<String> list = Arrays.asList("asdf.asd", "asfas.asd", "safd.sdd");
//        List<String> asd = list.stream().filter(o -> o.endsWith(".asd".toLowerCase())).collect(Collectors.toList());
//        System.out.println(asd);
//        String result = "===";
//
//        String s = Optional.ofNullable(num).orElse("");
//        System.out.println("s: " + s);
//        if(Integer.valueOf(num).equals(123)){
//            keyWordExecutor = new KeyWordExecutor.ExecutorNum();
//        }else if(num.equals("456")){
//            keyWordExecutor = new KeyWordExecutor.ExecutorEnglish();
//        }else if(num.equals("789")){
//            keyWordExecutor = new KeyWordExecutor.ExecutorChinese();
//        }
//        KeyWordExecutor executor = ExecutorFactory.getExecutor(num);
//        executor.process(result);

//        BigDecimal bigDecimal = new BigDecimal("165.505").multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP);
//        System.out.println(bigDecimal.longValue());
        Long aLong = Long.valueOf("012312");
        System.out.println(aLong);
    }

    public static void main(String[] args) {
//       TestOne testOne = new TestOne();
//        String s = "123";
//        try{
//            JSONObject jsonObject = JSONObject.parseObject("1231");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Map<String,Object> mn = new HashMap<>();
//        String[] split = ((String) mn.get("123")).split(".");
//        System.out.println(split);
        System.out.println("Integer: " + ObjectSizeCalculator.getObjectSize(Integer.valueOf(122)));
        System.out.println("Long: " + ObjectSizeCalculator.getObjectSize(Long.valueOf(122L)));
        System.out.println("Double: " + ObjectSizeCalculator.getObjectSize(Double.valueOf(122.22)));
        System.out.println("Float: " + ObjectSizeCalculator.getObjectSize(Float.valueOf(122.22f)));
        System.out.println("Boolean: " + ObjectSizeCalculator.getObjectSize(Boolean.valueOf(false)));
        System.out.println("Character: " + ObjectSizeCalculator.getObjectSize(Character.valueOf('a')));
        System.out.println("Short: " + ObjectSizeCalculator.getObjectSize(Short.valueOf("1")));
        System.out.println("Byte: " + ObjectSizeCalculator.getObjectSize(Byte.valueOf("1")));
        System.out.println("Date: " + ObjectSizeCalculator.getObjectSize(new Date()));

        Map<String, Object> map = new HashMap<>();
        map.put("11", 11);
        map.put("22", "22");
        map.put("33", 33L);
        map.put("44", 44.44);
        System.out.println("Map: " + ObjectSizeCalculator.getObjectSize(map));
        System.out.println("=============================================");
        System.out.println(ClassLayout.parseInstance(Integer.valueOf(122)).toPrintable());
        System.out.println("=============================================");
        System.out.println(ClassLayout.parseInstance(new Integer(1)).toPrintable());

    }
}
