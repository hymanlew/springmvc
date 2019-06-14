package mvc.spring.config;

import mvc.spring.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"classpath:user.properties"})
@Configuration
public class MyConfigOfPropertyValue {

    @Bean
    public User user(){
        return new User();
    }
}
