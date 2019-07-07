package mvc.servlet.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UserListener implements ServletContextListener {

    // 监听 ServletContext 的启动初始化操作
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("自定义监听 ServletContext 的启动初始化操作");

        // 得到 ServletContext 对象，并进行编码注册组件的操作
        ServletContext servletContext = servletContextEvent.getServletContext();
    }

    // 监听 ServletContext 的销毁操作
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("自定义监听 ServletContext 的销毁操作");
    }
}
