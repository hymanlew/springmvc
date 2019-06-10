package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Test implements InvocationHandler{

	public static void main(String[] args) {
		
		DispatcherServlet sd;
		
		Controller ct; // 是一个接口
		
		HandlerMapping hm; // 是一个接口
		SimpleUrlHandlerMapping a;
		
		ViewResolver vr;  // 是一个接口
		InternalResourceViewResolver sa;
		
		
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		return null;
	}

}
