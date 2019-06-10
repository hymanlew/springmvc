package mvc.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.spring.bean.User;

@Controller
@RequestMapping("/user")
public class HelloController2 {

	@RequestMapping("/hello.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("hello---------------");
		
		// 准备返回值
		ModelAndView result = new ModelAndView();
		// 设置响应 view的名称
		result.setViewName("index");
		return result;
	}
	
	@RequestMapping("/reg.do")
	public String register() {

		return "register";
	}

	@RequestMapping("/handlerReg.do")
	public ModelAndView handlerRegister(HttpServletRequest request,User user,
			ModelMap map) {
			
//		 1，向 view 组件转发数据，通过 request 封装数据，转发到JSP，返回值为
//			  为String 类型。
//		request.setAttribute("name", user.getName());
//		return "reg_info";
		
//		2，使用 ModelAndView
//		ModelAndView result = new ModelAndView();
//		result.setViewName("reg_info");
//		result.getModel().put("password", user.getPassword());
//		return result;
		
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("password", "123456");
//		ModelAndView mav = new ModelAndView("reg_info", data);
//		return mav;
		
//		3，使用 ModelMap，推荐使用这种
		ModelAndView result = new ModelAndView();
		result.setViewName("reg_info");
		map.addAttribute("salary",user.getSalary());
//	return “reg_info”;
		return result;
	}
	

//		放入参数时，参数名必须与 jsp页面的名称一致，但顺序不限定，只适用于少量的参数传递
//	public String handlerRegister(String password,
//			String name,int salary) {
//		
//		System.out.println(name);
//		System.out.println(password);
//		System.out.println(salary);
//		return null;
//	}
	
	
//		通过 HttpServletRequest 获取请求参数的值
//	public String handlerRegister(HttpServletRequest request) {
//		
//		String name = request.getParameter("name");
//		System.out.println(name);
//		return null;
//	}
	
	
	
}
