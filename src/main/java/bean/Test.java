package bean;

import bean.entity.ProUser;
import bean.entity.SinUser;
import bean.entity.User;
import bean.service.IUserService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        String path ="ctxd.xml";
        AbstractApplicationContext act = new ClassPathXmlApplicationContext(path);

		User user = act.getBean("u",User.class);
		System.out.println(user);

        IUserService service = act.getBean("service", IUserService.class);
        service.reg();

        act.close();
    }

    public static void t1(){

        // 加载配置文件
        String file ="applicationContext.xml";
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(file);

        //日志
        System.out.println("加载完成！\n");

        // 获取 date 对象
        Date date = context.getBean("date",Date.class);
        System.out.println(date);

        // 获取 Calendar 对象
        Calendar cal = context.getBean("calendar",Calendar.class);
        System.out.println("id=date:\n"+cal+"\n");

        // 获取 user 对象
        User user = context.getBean("u", User.class);
        UserFactory f = context.getBean("userFactory",UserFactory.class);
        User u = f.getUser();

        System.out.println(user);
        System.out.println(u);

        // 释放
        context.close();
    }

    public static void t2(){

        String file = "applicationContext.xml";
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(file);

        System.out.println("加载完成！\n");

        System.out.println("获取 sin 对象！\n");
        SinUser sin = ctx.getBean("sin",SinUser.class);
        SinUser sin1 = ctx.getBean("sin",SinUser.class);

        System.out.println("获取 pro 对象！\n");
        ProUser pro = ctx.getBean("pro",ProUser.class);
        ProUser pro1 = ctx.getBean("pro",ProUser.class);


        System.out.println(sin);
        System.out.println(sin1);


        System.out.println(pro);
        System.out.println(pro1);

        ctx.close();
        System.out.println("finish！\n");
    }

    public static void t3(){

        String file = "applicationContext.xml";
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(file);

        System.out.println("加载完成！\n");

        System.out.println("获取 sin 对象！\n");
        SinUser sin = ctx.getBean("sin",SinUser.class);

        System.out.println("获取 pro 对象！\n");
        ProUser pro = ctx.getBean("pro",ProUser.class);

        System.out.println(sin);
        System.out.println(pro);

        ctx.close();

        // 日志
        System.out.println("finish！\n");

//		sinuser
//		sinuser.init()
//			加载完成！
//
//			获取 sin 对象！
//			获取 pro 对象！
//
//		prouser
//		prouser.init()
//		spring.bean.SinUser@50c87b21
//		spring.bean.ProUser@5f375618
//
//		sinuser.destroy()
//		finish！
    }
}
