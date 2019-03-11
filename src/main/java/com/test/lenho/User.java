package com.test.lenho;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import springfox.documentation.spring.web.json.Json;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述:
 *      json
 * @author langyonghe
 * @create 2019-01-14 17:37
 */
@Data
@Builder
@AllArgsConstructor
public class User {
    private BigDecimal age;
//    private String email;
//    private String first_name;
//    private String last_name;
//    private Info info;
//    private String join_date;
//    private List<City> cityList;

//    @Data
//    static class Info{
//        private String bio;
//        private Integer age;
//        private List<String> interests;
//    }


    public static void main(String[] args) {
        User user1 = new User(new BigDecimal(1));
        User user2 = new User(new BigDecimal(2));
        User user3 = new User(new BigDecimal(3));
        List<User> users = new ArrayList<>();
        users.add(user3);
        users.add(user1);
        users.add(user2);
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().intValue() - o2.getAge().intValue();
            }
        });
        System.out.println(users);
//        BigDecimal age = user1.getAge();
//        System.out.println(age.equals(new BigDecimal(1)))
//        User user = users.stream().filter(o -> o.getAge().equals(new BigDecimal(1)) ).findFirst().get();
//        System.out.println(user);
////        System.out.println(users);
//        String s = JSON.toJSONString(Optional.ofNullable(users));
//        System.out.println(s);
//        List<User> bigDecimals = JSON.parseArray(s, User.class);
//        System.out.println(bigDecimals);
//        List<BigDecimal> collect = users.stream().map(User::getAge).sorted().collect(Collectors.toList());
//        System.out.println(collect);
//        List<BigDecimal> list = new ArrayList<>();
//        list.add(new BigDecimal(1));
//        list.add(new BigDecimal(2));
//        list.add(new BigDecimal(3));
//        String s = JSON.toJSONString(list);
//        System.out.println(s);
//        List<BigDecimal> list1 = JSON.parseArray(s, BigDecimal.class);
//        System.out.println(list1);

//        Info info = new Info();
//        info.setAge(25);
//        info.setBio("Eco-warrior and defender of the weak");
//        List<String> interests = new ArrayList<>();
//        interests.add("dolphins");
//        interests.add("whales");
//        info.setInterests(interests);
//
//        City city = new City();
//        city.setName("杭州");
//        List<City> cityList = new ArrayList();
//        cityList.add(city);
//        User user = User.builder().email("john@smith.com").first_name("Jhon")
//                .last_name("Smith").join_date("2014/05/01").info(info)
//                .cityList(cityList).build();
//        System.out.println(JSON.toJSONString(user));
    }
}
