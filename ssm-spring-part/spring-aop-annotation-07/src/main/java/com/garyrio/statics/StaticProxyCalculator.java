package com.garyrio.statics;

import com.garyrio.Calculator;

//代理类
public class StaticProxyCalculator implements Calculator {
    private Calculator calculator;

    //使用构造方法传入目标
    public StaticProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        //非核心业务
        System.out.println("i = " + i + ", j = " + j);
        //核心业务，调用目标
        int res = calculator.add(i, j);
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
