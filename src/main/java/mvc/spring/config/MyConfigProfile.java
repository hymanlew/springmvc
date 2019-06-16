package mvc.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import mvc.spring.bean.Color;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringValueResolver;

/**
 * Profile：是 spring 提供的可以根据当前环境，动态的激活和切换一系列组件的功能。
 *      它可以指定组件在哪个环境下才能被注入到容器中。
 *      如果添加了 profile 环境标识后，只有该环境被激活的时候，才会有 bean 对象被注册到容器中。
 *      默认是加载 default 环境配置。
 *
 * profile 注解可以标注的位置有：方法上，配置类上。
 *
 * 当组件不指定任何环境标识时，则任何环境下都能注册这个组件。
 *
 * 激活环境的方式有两种：
 * 1，使用命令行动态参数，即在虚拟机参数位置加载 -Dspring.profiles.active=dev。
 * 2，使用代码方式：参照 test.demo.t5 方法中的操作。
 */
public class MyConfigProfile implements EmbeddedValueResolverAware{

    @Value("${db.user}")
    private String userName;

    private StringValueResolver valueResolver;
    private String driver;

    @Profile("test")
    @Bean
    public DruidDataSource dataSourceTest(@Value("${db.pass}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc.mysql://localhost:3306/test");
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Profile("dev")
    @Bean
    public DruidDataSource dataSourceDev(@Value("${db.pass}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc.mysql://localhost:3306/dev");
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Profile("prod")
    @Bean
    public DruidDataSource dataSourcePro(@Value("${db.pass}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc.mysql://localhost:3306/pro");
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
         this.valueResolver = stringValueResolver;
         this.driver = valueResolver.resolveStringValue("${db.driverClass}");
    }

    @Profile("default")
    @Bean
    public Color color(){
        return new Color();
    }
}
