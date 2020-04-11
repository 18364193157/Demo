package com.test;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-01-23 17:58
 */
public abstract class KeyWordExecutor {

    public abstract void process(Object object);


    public static class ExecutorNum extends KeyWordExecutor {

        @Override
        public void process(Object object) {
            System.out.println(object);
            System.out.println(123);
        }
    }

    public static class ExecutorChinese extends KeyWordExecutor {
        @Override
        public void process(Object object) {
            System.out.println(object);
            System.out.println("中国");
        }
    }

    public static class ExecutorEnglish extends KeyWordExecutor {
        @Override
        public void process(Object object) {
            System.out.println(object);
            System.out.println("abc");
        }
    }
}

