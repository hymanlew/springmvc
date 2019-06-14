package mvc.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Red implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化方法=====");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁方法=====");
    }
}
