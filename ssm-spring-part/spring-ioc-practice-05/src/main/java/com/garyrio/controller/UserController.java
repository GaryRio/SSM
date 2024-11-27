package com.garyrio.controller;

import com.garyrio.pojo.User;
import com.garyrio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void findAll() {
        List<User> users = userService.findAll();
        System.out.println("UserController: " + users);
    }

}
