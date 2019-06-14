package mvc.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// bean 的后置处理器，即在 bean 初始化前后进行一些处理工作
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 在初始化之前工作
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    // 在初始化之后工作
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
