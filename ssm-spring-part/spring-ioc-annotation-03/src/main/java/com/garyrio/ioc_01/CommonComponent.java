package com.garyrio.ioc_01;

import org.springframework.stereotype.Component;

//1.标记注解
//2.配置文件指定需要扫描的包
@Component //相当于<bean id="commonComponent" class="当前类"/>
public class CommonComponent {
}
