package com.geryrio.test;

import com.garyrio.config.JavaConfig;
import com.garyrio.service.TopService;
import com.garyrio.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(JavaConfig.class)
public class SpringTxTest {
    @Autowired
    private UserService userService;
    @Autowired
    private TopService topService;

    @Test
    public void test_01() throws FileNotFoundException {
        userService.changeInfo();
    }

    @Test
    public void test_02() throws FileNotFoundException {
        topService.topService();
    }
}
