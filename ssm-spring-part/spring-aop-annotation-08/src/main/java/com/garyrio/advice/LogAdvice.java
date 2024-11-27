package com.garyrio.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * 1.增强类内要存储增强方法
 * 2.使用注解配置增强代码插入的位置
 *   前置  @Before
 *   后置  @AfterReturning
 *   异常  @AfterThrowing
 *   最后  @After
 *   环绕  @Around
 *
 *   try {
 *      前置
 *      目标代码执行
 *      后置
 *   } catch() {
 *      异常
 *   } finally {
 *      最后
 *   }
 * 3.配置切点表达式
 * 4.补全注解
 *   加入ioc容器：@Component
 *   配置切面：@Aspect = 切点 + 增强
 * 5.开启Aspect注解的支持
 *
 * TODO: 增强方法中获取目标方法信息
 *      1. 方法名，参数，访问修饰符，所属类的信息...
 *          (JoinPoint joinPoint) 包含目标方法的信息
 *      2. 返回的结果 - @AfterReturning
 *          (Object result) 接受返回结果
 *          @AfterReturning中指定 returning = 形参名
 *      3. 异常的信息 - @AfterThrowing
 *          (Throwable throwable) 接收异常信息
 *          @AfterThrowing中指定 throwing = 形参名
 */

@Component
@Aspect
public class LogAdvice {
    /**
     * TODO: 切点表达式
     *  固定语法 execution(1 2 3.4.5(6))
     *  1.访问修饰符
     *      public/private
     *  2.返回值类型
     *      String int void
     *      如果不考虑访问修饰符和返回值，1和2整合成一个*即可（必须同时不考虑）
     *  3.包的位置
     *      具体包：com.garyrio.service.impl
     *      单层模糊：com.garyrio.service.*
     *      多层模糊：com..impl  ..是任意层模糊（不能开头 *..impl可以）
     *  4.类名 具体/*
     *  5.方法名 具体/*
     *  6.参数列表
     *      无参：()
     *      有参：(String, int)
     *      模糊：(..) 有无参数都可以
     *      部分模糊
     */
    @Before("execution(* com..impl.*.*(..))")
    public void start(JoinPoint joinPoint) {
        //1. 获取方法所属类的信息
        String className = joinPoint.getTarget().getClass().getSimpleName();
        //2. 获取方法名
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        String methodName = joinPoint.getSignature().getName();
        //3. 获取参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("start");
    }

    @AfterReturning(value = "execution(* com.garyrio.service.impl.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("afterReturning");
    }
    @After("execution(* com.garyrio.service.impl.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("after");
    }

    @AfterThrowing(value = "execution(* com.garyrio.service.impl.*.*(..))", throwing = "throwable")
    public void error(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("error");
    }
}
