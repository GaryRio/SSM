package com.garyrio.ioc01;

public class StaticFactory {
    private static StaticFactory staticFactory = new StaticFactory();
    private StaticFactory() {}
    public static StaticFactory createInstance() {
        return staticFactory;
    }
}
