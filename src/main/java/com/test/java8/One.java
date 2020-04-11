package com.test.java8;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class One {
    public static void main(String[] args) throws Exception {
//        List<Integer> integers = Lists.newArrayList(1, 2, 3);
//        List<Integer> integers1 = Lists.newArrayList(3, 4, 5);
//        integers1.removeIf(integers::contains);
//        System.out.println(integers1);

//    StringBuilder stringBuilder = new StringBuilder();
//    if(StringUtils.isBlank(stringBuilder.toString())){
//        System.out.println("123123");
//    }

//        String s = "[{\"item_id\":255391,\"item_sku_id\":178429,\"number\":1,\"item_type\":1,\"seller_id\":3051957}]";
//        System.out.println(s);
//        String sad = "{\n" +
//                "    \"consignee_uid \":\"3051967 _264069\",\n" +
//                "    \"user_id\":\"3051957\",\n" +
//                "    \"country_code \":\"CN\",\n" +
//                "    \"province_code \":\"23\",\n" +
//                "    \"city_code \":\"230100000000 \",\n" +
//                "    \"area_code \":\"230109000000\",\n" +
//                "    \"address\":\"浦源路2468号 黑龙江科技大学\",\n" +
//                "    \"mobile \":\"17375555999 \",\n" +
//                "    \"zip \":\"150028 \",\n" +
//                "    \"consignee \":\"lenho\",\n" +
//                "    \"is_default \":1,\n" +
//                "    \"city \":\"哈尔滨市 \",\n" +
//                "    \"area \":\"松北区 \",\n" +
//                "    \"province \":\"黑龙江省 \",\n" +
//                "    \"type\":0,\n" +
//                "    \"consignee_type \":1,\n" +
//                "    \"id \":264069,\n" +
//                "    \"biz_code \":\"mokuaitv\",\n" +
//                "    \"delete_mark \":0,\n" +
//                "    \"delete_timestamp \":0,\n" +
//                "    \"gmt_created\":\"2020 - 03 - 31 11: 12: 20 \",\n" +
//                "    \"gmt_modified \":\"2020 - 03 - 31 11: 12: 20 \",\n" +
//                "    \"consignee_id \":264069\n" +
//                "}";
//        System.out.println(StringUtils.deleteWhitespace(sad));

//        String s = "586587657587657870878978978";
//        Long.parseLong(s);
//        String s = "23223";
//        String s1 = Optional.ofNullable(s).orElse("");
//        System.out.println(s1);
//        System.out.println(stringBuilder.toString());toString
//        int i = Integer.parseInt("23");
//        System.out.println(i);

//        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
//        System.out.println(Arrays.toString(strings.toArray()).replace("[","").replace("]",""));
//        BigDecimal price = new BigDecimal("s胜多负少");
//        price = price.multiply(new BigDecimal("100"));
//        System.out.println(price);
        // 1、创建调度器Scheduler
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = schedulerFactory.getScheduler();
//        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
//        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
//                .withIdentity("job1", "group1").build();
//        // 3、构建Trigger实例,每隔1s执行一次
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
//                .startNow()//立即生效
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                        .withIntervalInSeconds(1)//每隔1s执行一次
//                        .repeatForever()).build();//一直执行
//
//        //4、执行
//        scheduler.scheduleJob(jobDetail, trigger);
//        System.out.println("--------scheduler start ! ------------");
//        scheduler.start();
//
//        //睡眠
//        TimeUnit.MINUTES.sleep(1);
//        scheduler.shutdown();
//        System.out.println("--------scheduler shutdown ! ------------");


        // 获得本机的所有网络接口
//        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
//
//        while (nifs.hasMoreElements()) {
//            NetworkInterface nif = nifs.nextElement();
//
//            // 获得与该网络接口绑定的 IP 地址，一般只有一个
//            Enumeration<InetAddress> addresses = nif.getInetAddresses();
//            while (addresses.hasMoreElements()) {
//                InetAddress addr = addresses.nextElement();
//
//                if (addr instanceof Inet4Address) { // 只关心 IPv4 地址
//                    System.out.println("网卡接口名称：" + nif.getName());
//                    System.out.println("网卡接口地址：" + addr.getHostAddress());
//                    System.out.println();
//                }
//            }
//        }

        List<String> list = Lists.newArrayList("！23","2323","546");
        System.out.println(list.toString().replace("[","".replace("]","")));
    }
}
