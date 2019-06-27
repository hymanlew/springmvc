package mvc.spring.extconfig;

import mvc.spring.bean.Color;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    // 该方法是 bean 定义信息的存储中心，之后 beanfactory 就是按照 beanDefinitionRegistry 中存储的每一个 bean 定义信息创建 bean 实例。
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("被定义的 bean 的数量："+beanDefinitionRegistry.getBeanDefinitionCount());

        // 自定义一个 bean 的配置信息
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Color.class);
        beanDefinitionRegistry.registerBeanDefinition("Color3",beanDefinition);

        // 自定义一个 bean 的配置信息
        AbstractBeanDefinition abstractBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Color.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("Color4",abstractBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("被定义并加载后的 bean 的数量："+configurableListableBeanFactory.getBeanDefinitionCount());
    }
}
