package test;

import mvc.spring.bean.User;
import mvc.spring.config.MyConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Arrays;


public class Demo {

    private ApplicationContext context = null;

    @Test
    public void t1(){
        // 使用配置文件的方式声明 bean 对象
        context = new ClassPathXmlApplicationContext("ctxe.xml");
        context.getBean("user");

        // 声明 bean 对象也可以使用 @Configuration + @Bean 的方式进行配置。
        context = new AnnotationConfigApplicationContext(MyConfig.class);
        context.getBean(User.class);

        // 获取 bean 对象在 IOC 容器中的名字（即 bean 对象的 ID），也就是 @Bean 注解上的方法名，默认是输出为类名。当然也可以
        // 在 @Bean 注解上直接命名，即 @Bean("user")
        String[] names = context.getBeanNamesForType(User.class);

    }

    @Test
    public void t2(){
        context = new AnnotationConfigApplicationContext(MyConfig.class);
        // 获取 IOC 容器中所有 bean 对象的名字
        String[] names = context.getBeanDefinitionNames();

        for (String name : names){
            System.out.println(name);
        }
    }

    @Test
    public void t3(){
        context = new AnnotationConfigApplicationContext(MyConfig.class);
        // 获取当前项目的系统环境（即操作系统）
        Environment environment = context.getEnvironment();
        String osname = environment.getProperty("os.name");
        System.out.println(osname);

        // 获取 bean 对象在 IOC 容器中的名字（即 bean 对象的 ID），也就是 @Bean 注解上的方法名，默认是输出为类名。当然也可以
        // 在 @Bean 注解上直接命名，即 @Bean("user")
        String[] names = context.getBeanNamesForType(User.class);
        System.out.println(Arrays.asList(names));
    }
}
