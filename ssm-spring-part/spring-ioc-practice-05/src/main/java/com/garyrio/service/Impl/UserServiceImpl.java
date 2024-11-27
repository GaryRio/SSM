package com.garyrio.service.Impl;

import com.garyrio.dao.UserDao;
import com.garyrio.pojo.User;
import com.garyrio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
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
