package mvc.spring.extconfig;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {

    // 当容器中发布相关事件后（ApplicationEvent 类型的事件），则会触发该方法
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("收到事件 ====="+applicationEvent);
    }
}
