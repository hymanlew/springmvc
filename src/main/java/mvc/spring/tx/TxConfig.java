package mvc.spring.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 声明式事务：
 * 开启事务：
 * 1，在 xml 配置文件中添加 <tx:annotation-driven />，或者使用注解 @EnableTransactionManagement。
 * 2，配置事务管理器，PlatformTransactionManager。
 * 3、给方法上标注 @Transactional 表示当前方法是一个事务方法；
 *
 * 原理：
 * 1）、@EnableTransactionManagement
 * 			利用TransactionManagementConfigurationSelector给容器中会导入组件
 * 			导入两个组件
 * 			AutoProxyRegistrar
 * 			ProxyTransactionManagementConfiguration
 * 2）、AutoProxyRegistrar：
 * 			给容器中注册一个 InfrastructureAdvisorAutoProxyCreator 组件；
 * 			InfrastructureAdvisorAutoProxyCreator：？
 * 			利用后置处理器机制在对象创建以后，包装对象，返回一个代理对象（增强器），代理对象执行方法利用拦截器链进行调用；
 *
 * 3）、ProxyTransactionManagementConfiguration 做了什么？
 * 			1、给容器中注册事务增强器；
 * 				1）、事务增强器要用事务注解的信息，AnnotationTransactionAttributeSource解析事务注解
 * 				2）、事务拦截器：
 * 					TransactionInterceptor；保存了事务属性信息，事务管理器；
 * 					他是一个 MethodInterceptor；
 * 					在目标方法执行的时候；
 * 						执行拦截器链；
 * 						事务拦截器：
 * 							1）、先获取事务相关的属性
 * 							2）、再获取PlatformTransactionManager，如果事先没有添加指定任何 transactionmanger 最终会从容器
 * 						    	中按照类型获取一个PlatformTransactionManager；是在 @Transactional(transactionManager = "")
 * 						    	中指定，但一般是不指定的。
 * 							3）、执行目标方法
 * 								如果异常，获取到事务管理器，利用事务管理回滚操作；
 * 								如果正常，利用事务管理器，提交事务
 *
 */
@EnableTransactionManagement
@ComponentScan({"mvc.spring.tx", "mvc.spring.service", "mvc.spring.dao"})
@Configuration
public class TxConfig {

    @Bean
    public DruidDataSource dataSourceTest(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("hyman");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc.mysql://localhost:3306/test");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        // spring 对 @Configuration 配置类是特殊处理的，在该类中多次调用添加组件到容器中的方法（例如 dataSourceTest()），并
        // 不会多次生成 bean 对象，而只是多次从容器中获取该组件。
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceTest());
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSourceTest());
    }
}
