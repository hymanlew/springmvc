package mvc.spring.config;

import mvc.spring.bean.User;
import mvc.spring.condition.LinuxCondition;
import mvc.spring.condition.WinCondition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// 该配置类就 == xml 配置文件
@Configuration

// 注解代替 xml 配置文件中的包扫描
@ComponentScan(value = "mvc.spring")

// 也可以有选择地进行包扫描，excludeFilters 指定要排除的 filter（可以自由地选择排除的规则及方式，此次使用 filter 注解进行排除）
@ComponentScan(value = "mvc.spring", excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
})

/**
 * FilterType.ANNOTATION，使用注解进行匹配，只要是加了这个注解就会匹配上。
 * FilterType.ASSIGNABLE_TYPE，按照指定的类型进行匹配，只要是该类型就会匹配上（包括子类，实现类等等）。
 * FilterType.CUSTOM，使用自定义规则进行匹配，必须实现 TypeFilter 接口，只要是该类型就会匹配上（包括子类，实现类等等）。
 * 并且要注意，以上配置如果是组合使用的话，对类的扫描是一次性，不会重复扫描。即第一个扫描过后第二个就不会扫描了。
 */

// 也可以指定只扫描的指定的包，及符合规则的组件。 includeFilters（可以自由地选择包含的规则及方式，此次使用 filter 注解进行指定）
// 并且必须要禁用 spring 默认的扫描规则（改为 false），否则此配置不会生效
//@ComponentScan(value = "mvc.spring", includeFilters = {
//        //@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
//}, useDefaultFilters = false)

// 如果是需要指定多个扫描的规则，可以重复使用 ComponentScan 注解（只适用于 JDK1.8 及以上版本）。也可以用以下这个注解来指定
//@ComponentScans(
//        value = {
//                @ComponentScan(),
//                @ComponentScan()
//        }
//)
public class MyConfig {

    /**
     * IOC 容器加载类实例时，默认都是单例的，可以添加 @scope 注解来指定是单例还是非单例。
     *
     * prototype：多实例的，并且 IOC 容器启动时不会调用此方法生成实例，而是在每次获取的时候才创建实例，并将对象放到 IOC 容器中。
     * singleton：单例的（默认），并且 IOC 容器启动时就会调用此方法，并将对象放到 IOC 容器中。可以使用 @lazy 注解声明为懒加载。
     * request：同一次请求创建一个实例。
     * session：同一个 session 创建一个实例。
     * @return
     */
    @Bean("user")
    public User user(){
        return new User("user");
    }

    @Conditional({WinCondition.class})
    @Bean("window")
    public User user1(){
        return new User();
    }

    @Conditional(LinuxCondition.class)
    @Bean("linux")
    public User user2(){
        return new User();
    }
}
