package mvc.annotationMVC.controller;

import mvc.annotationMVC.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return helloService.sayhello("hyman");
    }

    @RequestMapping("/page")
    public String page(){
        return "index";
    }
}
