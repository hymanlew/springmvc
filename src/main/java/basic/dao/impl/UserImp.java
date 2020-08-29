package basic.dao.impl;

import basic.dao.IUserDao;
import basic.entity.User;

/**
 * 封装不仅仅是一个类对其属性和方法的封装，也可以是对多个类进行封装工厂模式 就是对类的封装。
 *
 * 工厂模式的封装：使具体的实现类不能被随意调用和创建。即设置访问权限为默认，只限于当前类，同包类调用，子孙类或其他包则不可以。
 */
public class UserImp implements IUserDao {

	@Override
	public void insert(User user) {
		System.out.println("User--1.insert() -> "+user);
	}
}
