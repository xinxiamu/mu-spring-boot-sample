package com.example.mystarterdemo;

import com.example.demo.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StarterTestController {

    @Resource
    private PersonService personService;

    @GetMapping("/sayHello")
    public String sayHello() {
        personService.sayHello();
        return "sayHello";
    }
}
