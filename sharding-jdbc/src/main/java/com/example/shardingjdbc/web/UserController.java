package com.example.shardingjdbc.web;


import com.example.shardingjdbc.entity.User;
import com.example.shardingjdbc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Object list() {
        return userService.list();
    }

    @GetMapping("/add")
    public Object add() {

        for(int i=100;i<150;i++) {
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setUsername("forezp"+(i));
            user.setPassword("1233edwd");
           long resutl=   userService.addUser(user);
            logger.info("insert:"+user.toString()+" result:"+resutl);
        }
        return "ok";
    }
}
