package com.garyrio.test;

import com.garyrio.config.JavaConfig;
import com.garyrio.service.Calculator;
import com.garyrio.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {

    // aop - 代理 - jdk代理 - 根据接口创建代理类对象 - 使用接口接收
    @Autowired
    private Calculator calculator;

    @Test
    public void test_01() {
        int res = calculator.add(1, 2);
        System.out.println("res = " + res);
    }
}
