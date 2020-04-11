package com.test;

/**
 * @author langyonghe
 * @date 2020-03-24 10:55
 */
public class SysDemoWrapper implements SysDemo {

    private SysDemo sysDemo;

    public SysDemoWrapper(SysDemo sysDemo) {
        this.sysDemo = sysDemo;
    }

    @Override
    public String out(String content) {
        System.out.println("start");
        String out = sysDemo.out(content);
        System.out.println("end");
        return out;
    }

    public static void main(String[] args) {

    }


}
