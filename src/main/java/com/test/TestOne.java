package com.test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.koloboke.collect.map.hash.HashIntIntMap;
import com.koloboke.collect.map.hash.HashIntIntMaps;
import com.koloboke.collect.map.hash.HashLongLongMaps;
import com.test.lenho.Student;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.apache.commons.codec.binary.Base64;
import org.openjdk.jol.info.ClassLayout;

import java.io.File;
import java.io.FilenameFilter;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Supplier;
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
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
//        System.out.println("Integer: " + ObjectSizeCalculator.getObjectSize(Integer.valueOf(122)));
//        System.out.println("Long: " + ObjectSizeCalculator.getObjectSize(Long.valueOf(122L)));
//        System.out.println("Double: " + ObjectSizeCalculator.getObjectSize(Double.valueOf(122.22)));
//        System.out.println("Float: " + ObjectSizeCalculator.getObjectSize(Float.valueOf(122.22f)));
//        System.out.println("Boolean: " + ObjectSizeCalculator.getObjectSize(Boolean.valueOf(false)));
//        System.out.println("Character: " + ObjectSizeCalculator.getObjectSize(Character.valueOf('a')));
//        System.out.println("Short: " + ObjectSizeCalculator.getObjectSize(Short.valueOf("1")));
//        System.out.println("Byte: " + ObjectSizeCalculator.getObjectSize(Byte.valueOf("1")));
//        System.out.println("Date: " + ObjectSizeCalculator.getObjectSize(new Date()));
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("11", 11);
//        map.put("22", "22");
//        map.put("33", 33L);
//        map.put("44", 44.44);
//        System.out.println("Map: " + ObjectSizeCalculator.getObjectSize(map));
//        System.out.println("=============================================");
//        System.out.println(ClassLayout.parseInstance(Integer.valueOf(122)).toPrintable());
//        System.out.println("=============================================");
//        System.out.println(ClassLayout.parseInstance(new Integer(1)).toPrintable());

//        Map<Integer,Integer> mn = new HashMap<>();
//        mn.put(123, 456);
//        mn.put(1231, 456);
//        mn.put(1232, 456);
//        mn.put(1233, 456);
//        mn.put(1234, 456);
//        System.out.println(ObjectSizeCalculator.getObjectSize(mn));
//        System.out.println("=============================================");
//        System.out.println(ClassLayout.parseInstance(mn).toPrintable());
//        String a = "1123";
//        String b ="12312";
//        try{
//            Integer ad = null;
//            ad = ad + 1;
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            System.out.println(Arrays.toString(e.getStackTrace()));
//
        String string = "jdbc:mysql://127.0.0.1:3306/learn?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        ArrayList<String> List = Lists.newArrayList(string.split("/"));
        System.out.println(string.split("/")[2]);
//        }
//        int c =  1;
//        int d = 2;
//        System.out.println(c + d);

//        String substring = "/manage-dataflow/service/idi/job/toDiTreeIndex".substring(0, "/manage-dataflow/service/idi/job/toDiTreeIndex".indexOf("/", 2));
//        System.out.println(substring);
//        String np = "nifiadmin-realm:175d6b94-8dd9-40e9-ac7b-5df7dd55e8d9";
//        String s = Base64.encodeBase64String(np.getBytes());
//        System.out.println(s);

//        Student student = new Student(1,"lenho",2);
//        Map<String, String> map = new HashMap<>();
//        map.put("a","aa");
//        Supplier<Student> supplier = new Supplier<Student>() {
//            @Override
//            public Student get() {
//                return student;
//            }
//        };

//        ArrayList arrayList = new ArrayList<String>();
//        arrayList.add("name");
//        arrayList.add("id");
//        System.out.println(arrayList.toString());
//        String string = "123";
//        String s = string.replaceAll("\\\"", "");
//        System.out.println(s);
//        System.out.println(getFileNameByStart("D:\\BI\\TEST\\3",""));
//        Properties info = new Properties();
//        info.setProperty("user","root");
//        info.setProperty("password","123456");
////        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", info);
//        System.out.println(234);



    }


    static String getFileNameByStart(String path, String fileNameStart) {
        File f = new File(path);
//        FilenameFilter filenameFilter = new FilenameFilterImpl(fileNameStart);
        String[] files = f.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(fileNameStart);
            }
        });
        if (files != null && files.length > 0) {
            return files[0];
        }
        return "";
    }
}

class FilenameFilterImpl implements FilenameFilter{

    private String fileNameStart;

    public FilenameFilterImpl(String fileNameStart) {
        this.fileNameStart = fileNameStart;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.startsWith(fileNameStart);
    }
}
