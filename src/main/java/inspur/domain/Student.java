package inspur.domain;

import java.util.ArrayList;
import java.util.*;

/**
 * @author langyonghe
 * @date 2021/3/2 14:05
 */
public class Student {


    private String name;

    public Student(String name) {
        System.out.println("构造~~");
        this.name = name;
    }

    public static void getTest(){
        List<String> list = new ArrayList<>();
    }
}
