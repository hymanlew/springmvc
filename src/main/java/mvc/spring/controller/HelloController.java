package mvc.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("hello---------------");
		
		// 准备返回值
		ModelAndView result = new ModelAndView();
		// 设置响应 view的名称
		result.setViewName("index");
		return result;
	}

	
}
