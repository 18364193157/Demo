package com.test.atomic;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author langyonghe
 * @date 2020/11/17 11:13
 */
public class AtomicReferenceTest {
    public static void main(String[] args) {

        // 创建两个Person对象，它们的id分别是101和102。
        Person p1 = new Person(333);
        Person p2 = new Person(444);
        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference<Person> ar = new AtomicReference(p1);

        for (int i = 0; i < 10; i++){
            new Thread(() -> {
                try{
                    Thread.sleep(Math.abs((int)Math.random()*100));
                }catch (Exception e){
                    e.printStackTrace();
                }
                if(ar.compareAndSet(p1,p2)){
                    System.out.println(Thread.currentThread().getId() + "Change value");
                    System.out.println(ar.get().getId());
                }else {
                    System.out.println(Thread.currentThread().getId() + "Failed");
                }

            }).start();
        }





    }
}

class Person {
    volatile long id;
    public Person(long id) {
        this.id = id;
    }

    public void setId(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }
}