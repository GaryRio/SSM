package com.garyrio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateNameById(String name, Integer id) {
        String sql = "update user set username = ? where userid = ?";
        int rows = jdbcTemplate.update(sql, name, id);

    }

    public void updatePasswordById(String password, Integer id) {
        String sql = "update user set password = ? where userid = ?";
        int rows = jdbcTemplate.update(sql, password, id);

    }

}
