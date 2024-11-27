package com.garyrio.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.garyrio.controller.UserController;
import com.garyrio.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class jdbcTemplateTest {
    public void testForJava() {
        /**
         * JdbcTemplate 简化数据库的crud 不提供连接池
         * DruidDataSource 负责连接的创建和数据库驱动的注册
         */
        //0.创建一个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/user"); //url地址
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //jdbc驱动
        dataSource.setUsername("root");
        dataSource.setPassword("gaorui030213");


        //1.创建对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //2.调用方法
//        jdbcTemplate.update() //DDL, DML, DCL, ...非查询语句
//        jdbcTemplate.queryForObject() //DQL查询单个对象
//        jdbcTemplate.query() //DQL 查询集合


    }

    /**
     * 通过ioc容器读取配置的jdbcTemplate组件
     */
    @Test
    public void testForIoC() {
        //1.创建ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        //2.获取jdbcTemplate组件
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        //3.数据库crud
        String sql = "insert into user (username, password) values (?, ?)";
        /**
         * 参数：
         * String sql 可以带有占位符 ?  只能替代值
         * Object...param 传入占位符的可变参数
         */
        int res = jdbcTemplate.update(sql, "xiaoli", "123123");
        System.out.println(res);

        //查询
        sql = "select * from user where username = ?";
        /**
         * 参数：
         * String sql;
         * RowMapper 列名和属性名的映射器接口
         * Object...param 占位符值
         */
        User user1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            //rs：结果集
            //rs中获取列的值，赋值给实体类的对象即可
            User user = new User();
            user.setUserid(rs.getInt("userid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }, "xiaoming");
        System.out.println(user1);

        //查询所有
        sql = "select * from user";
        //BeanPropertyRowMapper: 自动映射列和属性名-要求列和属性名一致，不一致就起别名
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));


    }

    /**
     * 从ioc容器中获取controller并且调用业务，内部都是ioc容器进行组装
     */
    @Test
    public void testQueryAll() {
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        //2.获取组件对象
        UserController controller = applicationContext.getBean(UserController.class);
        //3.使用组件对象
        controller.findAll();
        //4.关闭容器
        applicationContext.close();
    }
}
