package mvc.spring.config;

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
 */

@Configuration
@ComponentScan({"mvc.spring"})
public class MyConfigOfAutowire {

    @Primary
    @Bean
    public DemoService demoService(){
        return new DemoService();
    }
}
