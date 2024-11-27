package com.garyrio.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = "com.garyrio")
@EnableAspectJAutoProxy  //开启Aspectj的注解  == <aop:aspectj-autoproxy />
public class JavaConfig {
}
