package mvc.annotationMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

// 因为这个是 web 的子容器（springMVC），所以只需要扫描 controller 等业务相关的配置
@ComponentScan(value = "mvc.annotationMVC", includeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)

// 使用注解版定制 SpringMVC，不需要使用 spring*.xml 等等的配置文件。
// 配置组件（视图解析器、视图映射、静态资源映射、拦截器。。。）。
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    // 将 springMVC 处理不了的请求交给 tomcat 处理，主要是对于静态资源的访问。
    // 等同于 <mvc:default-servlet-handler />
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
        defaultServletHandlerConfigurer.enable();
    }

    // 自定义类型格式转换器
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    // 自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry
                .addInterceptor(new MyInterceptor())
                .addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

    }

    // 配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        // 默认所有的页面都从 /WEB-INF 下查找 *.jsp。也可以自定义路径。
        //viewResolverRegistry.jsp();
        viewResolverRegistry.jsp("/WEB-INF/jsp/",".jsp");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
