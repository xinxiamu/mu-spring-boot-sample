package com.example.mystarterdemo;

import com.example.demo.PersonProperties;
import com.example.demo.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    //如果这里定义，则不会自动定义
   /* @Bean
    public PersonService personService() {
        PersonProperties personProperties = new PersonProperties();
        personProperties.setName("zmttt");
        personProperties.setAge(18);
        personProperties.setSex("男");
        return new PersonService(personProperties);
    }*/
}
