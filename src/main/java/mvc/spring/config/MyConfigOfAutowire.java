package mvc.spring.config;

import mvc.spring.bean.Animal;
import mvc.spring.bean.Color;
import mvc.spring.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：spring 利用依赖注入 DI，完成对 IOC 容器中各个组件的依赖关系的赋值。
 *
 * 1，@Autowired：自动注入（默认按照类型匹配），如果找到多个相同类型的组件，再按属性的名称去匹配组件的 id。
 *    也可以配合使用 @Qualifier("xxx") 直接指定组件的 id 去匹配 bean 对象，而不使用属性的名称。
 *    @primary 让 spring 进行自动装配的时候，默认使用首选的 bean（即在自动装配时设定为优先级，前提是没有使用 qualifier 明确指定）。
 *    并且它是 spring 自己定义的装配注解。
 *
 * 2，spring 还支持 @Resource（JSR250），@Inject（JSR330）的注解，它们是 java 定义的装配注解。
 *    @Resource 默认是按照属性名称进行注入的（即它不支持 spring 的 @primary 注解不生效），并且可以指定 bean 的 id 名称。
 *    @Inject 该注解需要另外导入依赖，功能与 Autowired 注解一样。
 *
 * 3，@Autowired 可以标注的位置包括：构造器，参数，方法，属性（参照 animal 类的例子）。它们都是自动从 IOC 容器中获取到对象值。
 *    并且如果是使用 @Bean 注解的方式创建的对象，则方法参数的值也是自动从 IOC 容器中获得。
 *
 * 4，当自定义组件想要使用 spring 容器底层的组件时（如 applicationcontext，beanfactory 等等），只需要实现 xxxAware 即可。在
 *    创建对象时会调用接口规定的方法来注入相关组件。（参照 Color 类的例子）。
 */

@Configuration
@ComponentScan({"mvc.spring"})
public class MyConfigOfAutowire {

    @Primary
    @Bean
    public DemoService demoService(){
        return new DemoService();
    }

    @Bean
    public Animal animal(Color color){
        return new Animal(color);
    }
}
