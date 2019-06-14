package mvc.spring.bean;

import org.springframework.beans.factory.FactoryBean;

// 创建一个 spring 定义的工厂 bean
public class ColorFactoryBean implements FactoryBean {

    // 返回一个实例对象，这个对象会被添加到容器中
    @Override
    public Object getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // 设置为单例模式
    @Override
    public boolean isSingleton() {
        return true;
    }
}
