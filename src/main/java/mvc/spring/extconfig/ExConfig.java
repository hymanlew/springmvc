package mvc.spring.extconfig;

import mvc.spring.bean.Animal;
import mvc.spring.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListenerMethodProcessor;

import javax.servlet.http.HttpServlet;

/**
 * 扩展配置：
 * BeanPostProcessor：是 bean对象的后置处理器，是bean对象创建并初始化后进行的拦截工作的类。
 * BeanFactoryPostProcessor：是 bean 工厂的后置处理器，是在 bean工厂标准初始化之后调用，是所有的 bean 已经定义好并加载到 bean
 *      工厂，但是 bean 对象并未实例化时。
 *
 * 原理：
 * 1，IOC 容器创建对象 --> refresh 方法。
 * 2，invokeBeanFactoryPostProcessors(beanFactory)，执行所有的 BeanFactoryPostProcessor。包含配置优先级的，排序的，没排序的。
 *      然后执行所有的 bean 工厂后置处理器（invokeBeanFactoryPostProcessors 方法）。并且是在初始化创建其他组件之前执行。
 *
 *
 * BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor：
 *      postProcessBeanDefinitionRegistry()
 *      是在所有 bean 定义信息将要被加载，且 bean 实例也未创建的时机执行。即是在 BeanFactoryPostProcessor 之前执行的（是优先的）。
 *      因此可以利用 BeanDefinitionRegistryPostProcessor 给容器中再额外添加一些组件。
 *
 * 原理：
 * 1，IOC 容器创建对象。
 * 2，refresh() --> invokeBeanFactoryPostProcessors(beanFactory)
 * 3，先从容器中获取到所有的 BeanDefinitionRegistryPostProcessor 组件 --> invokeBeanDefinitionRegitryPostProcessors，然后
 *      依次触发每个组件的 postProcessBeanDefinitionRegistry。
 * 4，最后再触发 BeanFactoryPostProcessor --> invokeBeanFactoryPostProcessors(beanFactory) --> postProcessBeanFactory。
 *
 *
 * ApplicationListener：用于监听容器中发布的事件（ApplicationEvent 及其子类型的事件），即事件驱动模型的开发。
 * 1，声明一个监听器来监听某个事件（ApplicationEvent 类型的事件）（MyApplicationListener 类或使用 @EventListener 注解）。
 * 2，将监听器加入到容器中。
 * 3，只要容器中有相关事件的发布，我们就能监听到事件。例如：
 *      ContextRefreshedEvent，容器刷新完成（即所有 bean 都完全创建），则会发布这个事件。
 *      ContextClosedEvent，容器关闭时会发布此事件。
 * 4，手动发布一个事件，AnnotationConfigApplicationContext.publishEvent(new ApplicationEvent（）)。
 *
 * 原理：
 * ContextRefreshedEvent：
 *      1，容器创建对象，refresh() 刷新容器并执行后置处理器。
 *      2，finishRefresh()，容器刷新完成。
 *      3，并 publishEvent 发布此事件，执行发布流程。
 *
 * 自定义发布的事件：在 ContextRefreshedEvent 事件之后再执行事件发布流程。
 * ContextClosedEvent：容器关闭时会发布此事件。
 *
 * 事件发布流程：
 *      1，获取事件的多播器（派发器），getApplicationEventMulticaster()。
 *      2，multicastEvent 派发事件，获取到所有的 ApplicationListener，并遍历执行监听操作（有多线程异步和单线程同步两种方式）。
 *      3，拿到 listener 回调 ApplicationListener 的 onApplicationEvent 事件监听方法。
 *
 * 事件的多播器（派发器）的原理：
 *      1，容器创建对象，调用 refresh() 方法。
 *      2，initApplicationEventMulticaster() 初始化派发器（有则从容器中获取，没有则手动创建一个并加入到容器中）。
 *
 * @EventListener 注解原理：
 *      1，是使用 EventListenerMethodProcessor 处理器类，它实现了 SmartInitializingSingleton 接口。
 *      2，IOC 容器创建对象 --> refresh() 方法 --> 初始化所有剩下的单实例 bean 对象。
 *      3，之后先创建所有的单实例 bean，然后循环它们判断是否是 SmartInitializingSingleton 接口类型。
 *      3，如果是该类型，则调用该接口中的 afterSingletonsInstantiated 方法类似于容器中的 refresh() 方法的作用。
 *      4，finishRefresh --> publishEvent（发布）ContextRefreshedEvent 事件。
 *
 * 容器中有哪些监听器：
 *      1，容器创建对象，调用 refresh() 方法。
 *      2，registerListeners()，从容器中拿到所有的监听器（get..），并注册到 ApplicationEventMulticaster 派发器中。
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
