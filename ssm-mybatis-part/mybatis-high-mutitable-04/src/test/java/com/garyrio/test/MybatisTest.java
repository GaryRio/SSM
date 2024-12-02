package com.garyrio.test;

import com.garyrio.mapper.CustomerMapper;
import com.garyrio.mapper.OrderMapper;
import com.garyrio.pojo.Customer;
import com.garyrio.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSession sqlSession;

    @BeforeEach
    public void init() throws IOException {
        String mybatisConfigFilePath = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sessionFactory.openSession(true);
    }

    @Test
    public void testToOne() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderById(1);
        System.out.println("order = " + order);
        System.out.println(order.getCustomer());

        sqlSession.close();
    }

    @Test
    public void testToMany() {
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = customerMapper.queryList();
        System.out.println("customers = " + customers);
        for(Customer customer : customers) {
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList = " + orderList);
        }

        sqlSession.close();
    }
}
