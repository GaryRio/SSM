package com.garyrio.test;

import com.garyrio.config.JavaConfig;
import com.garyrio.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Springtest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserController bean = applicationContext.getBean(UserController.class);
        bean.findAll();
    }
}
