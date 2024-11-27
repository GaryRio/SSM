package com.garyrio.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10) //设置指定优先级，值越小，优先级越高
public class TxAdvice {

    @Before("com.garyrio.pointcut.MyPointCut.pc()")
    public void begin() {
        System.out.println("开启事务");
    }

    @AfterReturning("com.garyrio.pointcut.MyPointCut.pc()")
    public void commit() {
        System.out.println("事务提交");
    }

    @AfterThrowing("com.garyrio.pointcut.MyPointCut.pc()")
    public void rollBack() {
        System.out.println("事务回滚");
    }
}
