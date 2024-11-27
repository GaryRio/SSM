package com.garyrio.service.Impl;

import com.garyrio.dao.UserDao;
import com.garyrio.pojo.User;
import com.garyrio.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDao.queryAll();
        System.out.println("UserService: " + users);
        return users;
    }
}
