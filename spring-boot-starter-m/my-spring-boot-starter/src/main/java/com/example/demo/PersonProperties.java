package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = PersonProperties.PREFIX)
public class PersonProperties {

    public static final String PREFIX = "ljin-person";

    public PersonProperties(){}

    // 姓名
    private String name;
    // 年龄
    private int age;
    // 性别
    private String sex = "M";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
