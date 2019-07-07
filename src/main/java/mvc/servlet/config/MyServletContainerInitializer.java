package mvc.servlet.config;

import mvc.servlet.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

// 容器启动时，会将此注解指定的（value）类型下面的子类（包括子类，子接口等），全部传递过来，
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 在应用启动的时候，会运行此方法：
     * @param set 保存 @HandlesTypes 注解指定的所有类型的子类型。
     * @param servletContext 代表当前 web 应用的 ServletContext，一个应用一个上下文。
     * @throws ServletException
     *
     * 使用编码的方式让 servletContext 注册 web 组件（servlet（包括 DispatcherServlet），filter，listener）：
     * 1，第一种方式就是在 ServletContainerInitializer 的实现类中使用 ServletContext 进行注册。
     * 2，第二种方式是在 ServletContextListener 的实现类中使用 servletContextEvent.getServletContext() 得到 ServletContext
     *    对象，并进行编码注册组件的操作。
     *
     * 并且也只有这两种方式可以安全地进行组件注册，而在运行时给 servletContext 注册组件会出现安全问题。
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("容器启动时注解指定的（value）类型");
        for (Class c : set){
            System.out.println(c.getName());
        }
        System.out.println("其他的反射操作。");

        // 注册 servlet 组件
        ServletRegistration.Dynamic uservlet = servletContext.addServlet("userServlet", new UserServlet());
        // 配置 servlet 的映射信息
        uservlet.addMapping("/user");

        // 注册 Listener 组件
        servletContext.addListener(UserListener.class);

        // 注册 Filter 组件
        FilterRegistration.Dynamic ufilter = servletContext.addFilter("userFilter", UserFilter.class);
        // 配置 Filter 的映射信息，作用于所有的 request 请求
        ufilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
