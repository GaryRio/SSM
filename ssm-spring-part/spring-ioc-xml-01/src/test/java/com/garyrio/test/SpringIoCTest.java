package com.garyrio.test;

import com.garyrio.ioc03.HappyComponent;
import com.garyrio.ioc03.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

    /**
     * 创建IoC容器，并读取配置文件
     */
    public void createIoC() {
        //创建容器 选择合适的容器
        /**
         * 接口
         *   BeanFactory
         *   ApplicationContext
         *
         * 实现类
         *   可以直接通过构造函数实例化
         *   ClassPathXmlApplicationContext     读取类路径下的xml配置方式 （读取编译后的class文件）
         *   FileSystemXmlApplicationContext    读取指定文件位置的xml配置方式
         *   AnnotationConfigApplicationContext 读取配置类方式
         *   WebApplicationContext              读取Web项目配置
         */
        // 1.直接创建容器，指定配置文件
        // 构造器(String... 配置文件) 参数可以一个或多个
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        // 2. 先创建ioc容器对象，再指定配置文件，再刷新
        // 源码的配置过程，创建容器[Spring]和指定配置文件分开[自己指定]
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring-03.xml");
        applicationContext1.refresh(); //调用ioc和di的流程

    }

    /**
     * 在IoC容器中获取Bean
     */
    @Test
    public void getBeanFromIoC() {
        //创建ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //读取ioc容器中的组件
        //1. 直接根据Bean id获取 需要强转，不推荐
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");
        //2. 根据Bean id同时指定Bean的类型 Class
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);
        //3. 直接根据类型获取
        //TODO: 同一个类型在ioc容器中只能有一个Bean
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);


        happyComponent2.doWork();

    }

    @Test
    public void testInitDestroy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //ioc容器调用destroy
        //正常结束ioc容器，才能调用
        applicationContext.close();

    }
}
