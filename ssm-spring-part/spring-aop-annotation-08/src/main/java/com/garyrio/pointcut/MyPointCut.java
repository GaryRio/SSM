package com.garyrio.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointCut {

    @Pointcut("execution(* com..impl.*.*(..))")
    public void pc() {}
}
