package mvc.annotationMVC.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// 在 web 容器启动时创建对象，调用方法来初始化容器及前端控制器
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 获取根容器的配置类，即原先 spring 的 web.xml 配置文件中的父容器（定义 ContextLoaderListener，contextConfigLocation）
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // 获取 web 容器的配置类，即原先 spring 的 web.xml 配置文件中的 springMVC 配置项，称为子容器（定义前端控制器 DispatcherServlet）
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // 获取 DispatcherServlet 的映射信息
    @Override
    protected String[] getServletMappings() {
        // 定义拦截所有的请求，包括静态资源（js，png，css），但是不包括 jsp 文件。
        // 如果定义为 /* 的话，则是包括 jsp 在内，都会拦截。
        // 所以不能设置为 /* ，因为 jsp 页面是 tomcat 的 jsp 引擎解析的，如果拦截的话就无法显示页面。
        return new String[]{"/"};
    }
}
