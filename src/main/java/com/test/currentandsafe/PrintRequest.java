package com.test.currentandsafe;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/12/12 14:34
 */
public class PrintRequest extends Thread implements RequestProcessor {

    LinkedBlockingQueue<RequestDemo> blockingQueue = new LinkedBlockingQueue();

    private RequestProcessor requestProcessor;

    public PrintRequest(RequestProcessor requestProcessor){
        this.requestProcessor = requestProcessor;
    }
    @Override
    public void run(){
        while (true) {
            try {
                RequestDemo requestDemo = blockingQueue.take();
                System.out.println(requestDemo.getName());
                requestProcessor.processRequest(requestDemo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processRequest(RequestDemo requestDemo) {
        blockingQueue.add(requestDemo);
    }
}
