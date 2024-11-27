package com.garyrio.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {
    //@Value注解 直接赋值
    @Value("zhangsan")
    private String name;

    //读取外部配置信息
    //@Value("${key:value默认值}")
    @Value("${jdbc.username:admin}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
