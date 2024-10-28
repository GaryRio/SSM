package com.garyrio.ioc03;

public class JavaBean {
    //周期方法：必须是public void 无参
    public void init() {
        System.out.println("JavaBean.init");

    }
    public void destroy() {
        System.out.println("JavaBean.destroy");
    }
}
