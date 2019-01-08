package com.test.current;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/12/12 14:42
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<RequestDemo> blockingQueue = new LinkedBlockingQueue();


    @Override
    public void run(){
        while (true) {
            try {
                RequestDemo requestDemo = blockingQueue.take();
                System.out.println(requestDemo.getName());
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
