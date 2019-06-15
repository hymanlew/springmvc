package mvc.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringValueResolver;

/**
 * Profile：是 spring 提供的可以根据当前环境，动态的激活和切换一系列组件的功能。
 */
public class MyConfigProfile implements EmbeddedValueResolverAware{

    @Value("${db.user}")
    private String userName;

    private StringValueResolver valueResolver;
    private String driver;

    @Bean
    public DruidDataSource dataSourceTest(@Value("${db.pass}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc.mysql://localhost:3306/test");
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean
    public DruidDataSource dataSourceDev(@Value("${db.pass}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc.mysql://localhost:3306/dev");
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

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
}
