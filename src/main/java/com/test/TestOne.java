package com.test;

import java.util.Optional;

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
        String num = "456";
        String result = "===";

        String s = Optional.ofNullable(num).orElse("");
        System.out.println("s: " + s);
//        if(Integer.valueOf(num).equals(123)){
//            keyWordExecutor = new KeyWordExecutor.ExecutorNum();
//        }else if(num.equals("456")){
//            keyWordExecutor = new KeyWordExecutor.ExecutorEnglish();
//        }else if(num.equals("789")){
//            keyWordExecutor = new KeyWordExecutor.ExecutorChinese();
//        }
//        KeyWordExecutor executor = ExecutorFactory.getExecutor(num);
//        executor.process(result);
    }

    public static void main(String[] args) {
       TestOne testOne = new TestOne();
    }
}
