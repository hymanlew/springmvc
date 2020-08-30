package mvc.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义 condition
 *
 * @Conditional 注解作用：
 * 必须是 @Conditional 指定的条件成立，才给容器中添加组件，配置配里面的所有内容才生效；matches 方法指定了一个条件匹配规则，返回 true
 * 则注入所标注的 Bean 类到 IOC 容器，反之则不注入。即自动配置类必须在一定的条件下才能生效。
 *
 * 怎么知道哪些自动配置类生效；可以在主配置文件中启用 debug=true 属性；来让控制台打印自动配置报告进行查看。
 * Positive matches：代表自动配置成功，Negative matches：没有自动配置，在有需要时再导入包，再查看。
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
