package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public boolean add (@RequestBody User user) {
        this.userService.add(user);
        return true;
    }

    @GetMapping("/get/{name}")
    public User get (@PathVariable String name) {
        User user = this.userService.get(name);
        return user;
    }
}
