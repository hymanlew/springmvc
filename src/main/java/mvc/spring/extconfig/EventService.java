package mvc.spring.extconfig;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    // 指定事件监听的类型
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("监听到的事件 ===="+event);
    }
}
