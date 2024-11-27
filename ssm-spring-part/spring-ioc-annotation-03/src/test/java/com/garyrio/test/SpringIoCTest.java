package com.garyrio.test;

import com.garyrio.ioc_01.UserController;
import com.garyrio.ioc_01.UserDao;
import com.garyrio.ioc_02.JavaBean;
import com.garyrio.ioc_03.UserController3;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    @Test
    public void testIoC_01() {
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        //2.获取组件
//        UserDao bean = applicationContext.getBean(UserDao.class);
        //默认组件命名是 类的名称首字母小写
        UserDao bean = (UserDao) applicationContext.getBean("userDao");
        System.out.println(bean);
        //3.close容器
    }

    @Test
    public void testioc_02() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        applicationContext.close();

    }

    @Test
    public void testioc_03() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController3 userController = applicationContext.getBean(UserController3.class);
        userController.show();
    }

    @Test
    public void testioc_04() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        com.garyrio.ioc_04.JavaBean bean = applicationContext.getBean(com.garyrio.ioc_04.JavaBean.class);
        System.out.println(bean);
    }
}
