package com.test.queue;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.lenho.City;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * @author langyonghe
 * @date 2020-03-26 15:17
 */
public class MyStack {

    private Queue<Integer> dataQueue;
    private Queue<Integer> tempQueue;

    public MyStack() {
        dataQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }


    public void push(int x){
        tempQueue = dataQueue;
        dataQueue = new LinkedList<>();
        dataQueue.offer(x);
        if(!tempQueue.isEmpty()){
            dataQueue.offer(tempQueue.poll());
        }

    }


    public int pop() {
        return dataQueue.poll();
    }


    public int top() {
        return dataQueue.peek();
    }


    public Boolean empty() {
        return dataQueue.isEmpty();
    }

    public static Gson gson = new Gson();
    public static <T> T parseJson(String jsonStr, Class<T> tClass) {
        return gson.fromJson(jsonStr, tClass);
    }

    public static <T> T parseJson(String jsonStr, Type typeOfT) {
        return gson.fromJson(jsonStr, typeOfT);
    }

    public static <T> T str2OrderItem(String orderItemListStr,T t){
        if(isNullorEmpty(t)){
            System.out.println("空的集合");
        }
        t = parseJson(orderItemListStr,new TypeToken<T>() {
        }.getType());
        return t;
    }
    public static boolean isNullorEmpty(Object obj) {
        if (null == obj) {
            return true;
        } else if (obj instanceof String && "".equals(((String) obj).trim())) {
            return true;
        } else if (obj instanceof Number && ((Number) obj).doubleValue() == 0) {
            return true;
        } else if (obj instanceof Boolean && !((Boolean) obj)) {
            return true;
        } else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setId(23L);
        city.setAge(23L);
        city.setJson("sdfa");
//        cityList.add(city);
        String s = gson.toJson(cityList);
        List<City> cities = str2OrderItem(s, cityList);
        System.out.println(cities);

//        List list = parseJson(s, cityList.getClass());
//        System.out.println(list);


//        MyStack myStack = new MyStack();
//        myStack.push(4);
//        myStack.push(5);
//        System.out.println(myStack.top());

    }
}
