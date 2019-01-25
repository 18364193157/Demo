package com.test;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-01-24 14:46
 */
public class ExecutorFactory {
    public static KeyWordExecutor getExecutor(String num){
        if(Integer.valueOf(num).equals(123)){
            return new KeyWordExecutor.ExecutorNum();
        }else if(num.equals("456")){
            return new KeyWordExecutor.ExecutorEnglish();
        }else if(num.equals("789")){
            return new KeyWordExecutor.ExecutorChinese();
        }else {
            return null;
        }

    }
}
