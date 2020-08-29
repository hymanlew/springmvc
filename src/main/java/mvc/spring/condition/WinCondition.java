package mvc.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义 condition
 * matches 方法指定了一个条件匹配规则，返回 true 则注入所标注的 Bean 类到 IOC 容器，反之则不注入。
 */
public class WinCondition implements Condition {

    /**
     * @param conditionContext：     是判断条件能使用的上下文环境。
     * @param annotatedTypeMetadata：注释信息。
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        // 获取到 IOC 容器使用的 beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 获取到类加载器
        ClassLoader loader = conditionContext.getClassLoader();

        Environment environment = conditionContext.getEnvironment();
        if(environment.getProperty("os.name").contains("Windows")){
            return true;
        }
        return false;
    }
}
