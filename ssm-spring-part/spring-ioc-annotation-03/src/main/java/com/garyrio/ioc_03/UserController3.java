package com.garyrio.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController3 {
    // 自动装配注解（DI）：1.ioc容器中查找符合类型的组件对象 2.设置给当前属性
    //同一个类型有多个组件时，1.根据成员属性名来指定（多个组件时会默认根据成员属性名查找）
    //                      2.使用@Qualifier指定获取bean的id
    //@Resource = @Autowired(required = true) + @Qualifier("userServiceImpl")
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Resource(name = "userServiceImpl")
    private UserService userService2;

    public void show() {
        String show = userService.show();
        System.out.println(show);
    }
}
