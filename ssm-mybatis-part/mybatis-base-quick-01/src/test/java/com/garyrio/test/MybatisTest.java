package com.garyrio.test;

import com.garyrio.mapper.EmployeeMapper;
import com.garyrio.pojo.Employee;
import com.garyrio.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void test_01() throws IOException {
        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession sqlSession = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        // jdk动态代理技术生成的mapper代理对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        // 内部拼接接口的全限定符.方法名 去查找sql语句标签
        // 拼接，整合参数 -> 调用ibatis传入参数执行
        // mybatis底层依然调用ibatis，有固定的模式


        // 4. 调用代理类方法既可以触发对应的SQL语句
        Employee employee = employeeMapper.queryById(1);

        System.out.println("employee = " + employee);

        // 4.关闭SqlSession
        sqlSession.commit(); //提交事务 [DQL不需要,其他需要]
        sqlSession.close(); //关闭会话
    }

    /**
     * 使用ibatis的方式进行数据库调用
     */
    @Test
    public void test_02() throws IOException {
        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession sqlSession = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
//        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        // 4. 调用代理类方法既可以触发对应的SQL语句
//        Employee employee = employeeMapper.queryById(1);
//
//        System.out.println("employee = " + employee);
        //4.sqlSession提供的crud方法进行数据库
        //参数1：字符串 sql标签对应的id | namespace.id
        //参数2：Object 执行sql语句传入的参数
        User user = sqlSession.selectOne("ssss.kkk", 1);
        //缺点：1.sql语句的字符串标识id，容易写错
        //     2.参数需要进行整合，只能传递一个参数
        //     3.返回值Object
        System.out.println("user = " + user);
        // 4.关闭SqlSession
        sqlSession.commit(); //提交事务 [DQL不需要,其他需要]
        sqlSession.close(); //关闭会话
    }
}

