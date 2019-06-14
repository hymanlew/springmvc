package mvc.spring.config;

import mvc.spring.bean.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean 的生命周期：即 bean 创建，初始化，销毁的过程。
 *
 * 容器管理 bean 的生命周期，但我们可以自定义初始化和销毁方法：
 * 1，在 xml 中定义，init-method="xxx" destroy-method="xxx"。
 * 2，在 bean 注解中定义 init，destroy 方法。
 * 3，通过实现 InitializingBean 接口来定义初始化逻辑，实现 DisposableBean 接口来定义销毁逻辑。
 * 4，使用 JSR250 中的注解来定义，PostConstruct 初始化方法，PreDestroy 销毁方法。
 * 5，bean 的后置处理器，即在 bean 初始化前后进行一些处理工作。
 *
 * 在单例模式时，容器启动时就创建对象也就自动执行 init 方法，容器关闭时自动执行 destroy 方法。
 * 而多例模式时，容器启动时不自动创建对象不执行 init 方法，容器关闭时也不自动执行 destroy 方法，而是自定义调用销毁方法。
 */


@Configuration
public class MyconfigOfLifeCycle {

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Animal animal(){
        return new Animal();
    }
}
