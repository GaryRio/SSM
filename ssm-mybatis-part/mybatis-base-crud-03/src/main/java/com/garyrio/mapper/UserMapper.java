package com.garyrio.mapper;

import com.garyrio.pojo.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);

    int update(User user);

    int delete(User user);

    User selectById(Integer id);

    List<User> selectAll();
}
