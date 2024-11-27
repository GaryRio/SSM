package com.garyrio.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


//java配置类，替代xml配置文件
//1.包扫描注解配置
//2.引用外部配置文件
//3.声明第三方依赖的bean组件

//1.添加Configuration注解
//2.通过注解完成配置
@Configuration
@ComponentScan({"com.garyrio.ioc_01", "com.garyrio.ioc_02"})
@PropertySource("classpath:jdbc.properties")
public class JavaConfiguration {

//    @Value("${garyrio.url}")
//    private String url;
//    @Value("${garyrio.driver}")
//    private String driver;
//    @Value("${garyrio.username}")
//    private String username;
//    @Value("${garyrio.password}")
//    private String password;

    /**
     * <bean -> </bean> 一个方法
     * 返回值类型 == bean组件的类型或者他的接口或父类
     * 方法的名字 == bean的标识id
     *
     * 方法体中自定义实现过程即可
     * @Bean 让配置类的方法创建的对象存储到ioc容器
     *       value覆盖方法名
     *       init, destroy
     */
    @Bean(value = "dataSource", initMethod = "", destroyMethod = "")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DruidDataSource dataSource(@Value("${garyrio.url}") String url,
                                      @Value("${garyrio.driver}") String driver,
                                      @Value("${garyrio.username}")String username,
                                      @Value("${garyrio.password}")String password) {
        //这里实现具体的实例化过程
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //JdbcTemplate -> DataSource
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //需要DataSource（需要其他组件）
        //1.如果其他组件也是@Bean，可以直接调用
//        jdbcTemplate.setDataSource(dataSource());
        //2.形参列表声明需要的组件类型，ioc容器也会注入，要求要有对应类型的组件
        //  如果有多个，使用形参名称 == 对应的beanid标识就行
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

}
