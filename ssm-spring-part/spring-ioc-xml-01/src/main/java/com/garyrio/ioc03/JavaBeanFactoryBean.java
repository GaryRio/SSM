package com.garyrio.ioc03;

import org.springframework.beans.factory.FactoryBean;


/**
 * 通过该对象制造JavaBean
 *
 *
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {
    @Override
    public JavaBean getObject() throws Exception {
        //使用自己的方式实例化对象
        JavaBean javaBean = new JavaBean();
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
