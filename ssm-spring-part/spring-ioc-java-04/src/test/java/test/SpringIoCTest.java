package test;

import com.garyrio.config.JavaConfiguration;
import com.garyrio.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {
    @Test
    public void test() {
        //1.创建ioc容器
        //AnnotationConfigApplicationContext
        ApplicationContext app = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        //2.获取组件
        StudentController bean = app.getBean(StudentController.class);
        System.out.println("bean = " + bean);
    }
}
