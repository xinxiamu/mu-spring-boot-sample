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

    @GetMapping("/get/{id}")
    public User get (@PathVariable Long id) {
        User user = this.userService.get(id);
        return user;
    }

    @PutMapping("/update")
    public Boolean update(@RequestBody User user) {
        this.userService.update(user);
        return true;
    }

    @DeleteMapping("/del/{id}")
    public Boolean del(@PathVariable Long id) {
        this.userService.del(id);
        return true;
    }

    @DeleteMapping("/del")
    public Boolean delAll() {
        this.userService.deleteAll();
        return true;
    }
}
