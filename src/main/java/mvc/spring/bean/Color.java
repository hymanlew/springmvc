package mvc.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Color {

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
}
