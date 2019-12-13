package com.test;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
       TestOne testOne = new TestOne();
    }
}
