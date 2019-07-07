package mvc.annotationMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

// 因为这个是 web 的父容器，只用于配置 filter，listener 等等的信息，所以不需要扫描 controller 等业务相关的配置
@ComponentScan(value = "mvc.annotationMVC", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class RootConfig {
}
