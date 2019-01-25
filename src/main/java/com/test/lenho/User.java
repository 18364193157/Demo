package com.test.lenho;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *      json
 * @author langyonghe
 * @create 2019-01-14 17:37
 */
@Data
@Builder
public class User {
    private String email;
    private String first_name;
    private String last_name;
    private Info info;
    private String join_date;
    private List<City> cityList;

    @Data
    static class Info{
        private String bio;
        private Integer age;
        private List<String> interests;
    }


    public static void main(String[] args) {
        Info info = new Info();
        info.setAge(25);
        info.setBio("Eco-warrior and defender of the weak");
        List<String> interests = new ArrayList<>();
        interests.add("dolphins");
        interests.add("whales");
        info.setInterests(interests);

        City city = new City();
        city.setName("杭州");
        List<City> cityList = new ArrayList();
        cityList.add(city);
        User user = User.builder().email("john@smith.com").first_name("Jhon")
                .last_name("Smith").join_date("2014/05/01").info(info)
                .cityList(cityList).build();
        System.out.println(JSON.toJSONString(user));
    }
}
