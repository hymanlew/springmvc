package mvc.spring.extconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    // 该方法的运行时机是，所有的 bean 已经定义好并加载到 bean工厂，但是 bean 对象并未实例化时。
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor --- 初始化 bean 但未实例化 ---");

        // IOC 容器中定义了 bean 的数量
        int count = configurableListableBeanFactory.getBeanDefinitionCount();
        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();

        System.out.println("定义了多少个 bean："+ count);
        System.out.println(Arrays.asList(names));
    }
}
