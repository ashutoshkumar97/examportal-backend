package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //creating user
    @PostMapping("/add")
    public User createUser(@RequestBody User user){
        //defined a fixed role "NORMAL" for any user that registers
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");
        return user;
    }
}
