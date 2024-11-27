package com.garyrio;

import com.garyrio.statics.StaticProxyCalculator;

public class UseApp {
    public static void main(String[] args) {
        Calculator target = new CalculatorPureImpl();
        Calculator proxy = new StaticProxyCalculator(target);
        proxy.add(1, 2);

        //jdk代理
        ProxyFactory proxyFactory = new ProxyFactory(target);
        Calculator proxy1 = (Calculator) proxyFactory.getProxy();
        proxy1.add(1, 1);

    }
}
