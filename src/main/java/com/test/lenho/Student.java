package com.test.lenho;

import lombok.Data;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-06-25 10:11
 */
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    public Student(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public static final class Builder{
        private Integer id;

        private String name;

        private Integer age;



        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(Integer age){
            this.age = age;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
