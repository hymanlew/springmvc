package mvc.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.spring.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class RegisterController {

	@RequestMapping("/register.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("hello---------register------");
		
		// 准备返回值
		ModelAndView result = new ModelAndView();
		// 设置响应 view的名称
		result.setViewName("index");
		return result;
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}

	// 设置为不必须要找到（因为它默认为 true，找不到则会抛异常）
	@Qualifier("service")
	@Autowired(required = false)
	private DemoService service;
}
