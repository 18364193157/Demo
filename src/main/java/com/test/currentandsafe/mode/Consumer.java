//package com.test.current.mode;
//
//import java.text.MessageFormat;
//import java.util.Random;
//import java.util.concurrent.BlockingDeque;
//
///**
// * 描述:
// *
// * @author langyonghe
// * @create 2019-03-12 11:32
// */
//public class Consumer implements Runnable{
//
//    private BlockingDeque<PCData> queue;
//    private static final int SLEEPTIME = 1000;
//
//    public Consumer(BlockingDeque<PCData> queue) {
//        this.queue = queue;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("start consumer id=" + Thread.currentThread().getId());
//        Random r = new Random();
//        try{
//            while (true){
//                PCData data = queue.take();
//                if(null != data){
//                    int re = data.getIntData() * data.getIntData();
//                    System.out.println(MessageFormat.format("{0}*{1}={2}"),data.getIntData(),data.getIntData(),re);
//                    Thread.sleep(r.nextInt(SLEEPTIME));
//                }
//            }
//        }catch (Exception e){
//
//        }
//    }
//}
