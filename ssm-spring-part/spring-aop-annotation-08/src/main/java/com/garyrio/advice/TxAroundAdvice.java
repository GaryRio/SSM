package com.garyrio.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class TxAroundAdvice {

    /**
     * 环绕通知，需要在通知中，定义目标方法的执行
     *
     * jointPoint: 可以获取目标信息，也可以执行
     * return: 目标方法的返回值
     */
    @Around("com.garyrio.pointcut.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint) {
        //保证目标方法的执行
        Object[] args = joinPoint.getArgs();
        Object res = null;
        try {
            System.out.println("开启事务");
            res = joinPoint.proceed(args);
            System.out.println("结束事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        }
        return res;
    }
}
