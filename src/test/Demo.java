package test;

import mvc.spring.aop.MathCalculator;
import mvc.spring.bean.User;
import mvc.spring.config.MyConfig;
import mvc.spring.config.MyConfigOfAop;
import mvc.spring.config.MyConfigOfPropertyValue;
import mvc.spring.config.MyConfigProfile;
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

    @Test
    public void t4(){
        context = new AnnotationConfigApplicationContext(MyConfigOfPropertyValue.class);
        User user = context.getBean(User.class);
        System.out.println(user);

        Environment environment = context.getEnvironment();
        String data = environment.getProperty("user.salary");
        System.out.println(data);
    }

    @Test
    public void t5(){
        // 创建一个无参的 context 构造器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 设置需要激活的环境
        context.getEnvironment().setActiveProfiles("default","dev");
        // 注册主配置类
        context.register(MyConfigProfile.class);
        // 启动并刷新容器
        context.refresh();

        Environment environment = context.getEnvironment();
        String data = environment.getProperty("user.salary");
        System.out.println(data);

        context.close();
    }

    @Test
    public void t6(){
        context = new AnnotationConfigApplicationContext(MyConfigOfAop.class);
        MathCalculator calculator = context.getBean(MathCalculator.class);
        calculator.div(6, 2);

        //calculator.div(6, 0);

    }
}
