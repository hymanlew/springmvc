package mvc.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Color implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware{

    //@Autowired
    private ApplicationContext context;

    public Color(){

    }

    // 对象创建并赋值之后调用
    @PostConstruct
    public void init(){

    }

    // 在对象销毁之前调用
    @PreDestroy
    public void destroy(){

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("当前 bean 的名字："+s);
    }

    // 该接口中的方法是用来解析 string 中的占位符的（如 #{}, ${}）。
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
       String data = stringValueResolver.resolveStringValue("hello, ${os.name}, #{20+3}");
        System.out.println("字符串解析："+data);
    }
}
