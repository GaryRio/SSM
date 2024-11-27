package com.garyrio.controller;

import com.garyrio.pojo.User;
import com.garyrio.service.UserService;

import java.util.List;

public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void findAll() {
        List<User> users = userService.findAll();
        System.out.println("UserController: " + users);
    }

}
