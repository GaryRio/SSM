package com.garyrio.test;

import com.garyrio.components.A;
import com.garyrio.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@SpringJUnitConfig(locations = "配置文件")
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIocTest {

    @Autowired
    private A a;
    @Test
    public void test() {
        System.out.println(a);
    }
}
