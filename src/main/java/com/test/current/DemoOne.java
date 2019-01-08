package com.test.current;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/12/12 14:52
 */
public class DemoOne {

    PrintRequest printRequest;

    public DemoOne() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        PrintRequest printRequest = new PrintRequest(saveProcessor);
        printRequest.start();
    }

    public static void main(String[] args) {
        RequestDemo requestDemo = new RequestDemo();
        requestDemo.setName("lenho");
        DemoOne demoOne = new DemoOne();
        demoOne.test(requestDemo);
    }

    public void test(RequestDemo requestDemo){
        printRequest.processRequest(requestDemo);
    }
}
