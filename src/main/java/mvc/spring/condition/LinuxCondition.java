package mvc.spring.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        // 获取到 bean 定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        // 判断容器中是否包含某一个 bean
        if(registry.containsBeanDefinition("user")){
            System.out.println("======= 包含 user ======");
        }

        Environment environment = conditionContext.getEnvironment();
        if(environment.getProperty("os.name").contains("linux")){
            return true;
        }
        return false;
    }
}
