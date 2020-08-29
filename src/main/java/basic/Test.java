package spring.bean.a;

import basic.dao.impl.UserDaoImp;
import basic.entity.SampleBean;
import basic.entity.SourceBean;
import basic.entity.TargetBean;
import basic.entity.User;
import basic.service.UserService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		// ============================================ 1
		String path ="ctxa.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		User user = new User();
		user.setUsername("alex");
		user.setPassword("123456");
		
		UserService service = ctx.getBean("service",UserService.class);
		service.reg(user);

		ctx.close();


		// ============================================ 2
		path="ctxc.xml";
		ctx = new ClassPathXmlApplicationContext(path);

		SourceBean sou = ctx.getBean("source",SourceBean.class);
		System.out.println(sou);

		TargetBean tar = ctx.getBean("target",TargetBean.class);
		System.out.println(tar);

		UserDaoImp dao = ctx.getBean("dao",UserDaoImp.class);
		service = ctx.getBean("service",UserService.class);
		dao.insert(user);

		System.out.println("---------");
		service.reg(user);
		ctx.close();


		// ============================================ 3
		String file ="ctxb2.xml";
		AbstractApplicationContext atx = new ClassPathXmlApplicationContext(file);

		Date date = atx.getBean("date",Date.class);
		System.out.println(date);

		SampleBean sam = atx.getBean("sample", SampleBean.class);
		System.out.println(sam.getName());
		System.out.println(sam);
		System.out.println(sam.getList());

		// class java.util.LinkedHashSet
		System.out.println(sam.getUnOrderData().getClass());

		System.out.println(sam.getMap());
		System.out.println(sam.getMap().getClass());

		System.out.println(sam.getProperties());

		System.out.println("----------------------");
		List<?> list =atx.getBean("listdata", List.class);
		Map<?,?> session = atx.getBean("session",Map.class);

		System.out.println(list);
		System.out.println(session);
	}
}
