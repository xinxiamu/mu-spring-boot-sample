package com.example.demo;

public class PersonService {

    private PersonProperties properties;

    public PersonService() {
    }

    public PersonService(PersonProperties properties) {
        this.properties = properties;
    }

    public void sayHello() {
        String message = String.format("大家好，我叫: %s, 今年 %s岁, 性别: %s",
                properties.getName(), properties.getAge(), properties.getSex());
        System.out.println(message);
    }
}
