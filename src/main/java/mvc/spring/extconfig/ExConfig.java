package mvc.spring.extconfig;

import mvc.spring.bean.Animal;
import mvc.spring.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展配置：
 * BeanPostProcessor：是 bean对象的后置处理器，是bean对象创建并初始化后进行的拦截工作的类。
 * BeanFactoryPostProcessor：是 bean 工厂的后置处理器，是在 bean工厂标准初始化之后调用，是所有的 bean 已经定义好并加载到 bean
 *      工厂，但是 bean 对象并未实例化时。
 *
 * 1，IOC 容器创建对象。
 * 2，invokeBeanFactoryPostProcessors(beanFactory)，执行所有的 BeanFactoryPostProcessor。包含配置优先级的，排序的，没排序的。
 *      然后执行所有的 bean 工厂后置处理器（invokeBeanFactoryPostProcessors 方法）。并且是在初始化创建其他组件之前执行。
 */
@ComponentScan("mvc.spring.extconfig")
@Configuration
public class ExConfig {

    @Bean("user")
    public User user(){
        return new User();
    }

    @Bean
    public Animal animal(){
        return new Animal();
    }
}
