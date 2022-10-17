package com.example.demo.all;

import com.example.demo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/all")
public class AllController {

    @Autowired
    private AllService allService;

    /**
     * 保存
     * @return
     */
    @GetMapping("/save/{userId}/{userName}/{age}")
    public Integer save(@PathVariable Integer userId, @PathVariable String userName, @PathVariable Integer age) {
        return allService.save(userId, userName, age);
    }

    @GetMapping("/update/{userId}/{userName}")
    public Boolean update(@PathVariable Integer userId, @PathVariable String userName) {
        return allService.update(userId, userName);
    }

    @GetMapping("/get/{userId}")
    public String get(@PathVariable Integer userId) {
        return allService.get(userId);
    }
}
