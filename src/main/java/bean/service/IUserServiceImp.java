package bean.service;

import basic.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("service")
public class IUserServiceImp implements IUserService{

	/**
	 *  使用 @Autowired，@Qualifier的组合可以注解方法，也可以注解属性，这两种方法任选其一即可。
	 *  推荐第一种，采用的是先 Bytype，再 Byname 策略匹配。
	 */

	// 第 1 种
	//private IUserDao dao;
	//
	//@Autowired
	//public void setDao(@Qualifier("user") IUserDao dao) {
	//	this.dao = dao;
	//}

	// 第 2 种
	//@Autowired
	//@Qualifier("user")
	//private IUserDao dao;

	// 第 3 种
	@Resource(name="user")
	private IUserDao dao;

	@Override
	public void reg() {
		dao.insert(null);
		System.out.println("service");
	}

}
