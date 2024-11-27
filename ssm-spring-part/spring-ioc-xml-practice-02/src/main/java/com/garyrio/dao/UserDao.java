package com.garyrio.dao;

import com.garyrio.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> queryAll();
}
