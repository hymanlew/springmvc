package basic.service;

import basic.dao.IUserDao;
import basic.entity.User;

public class UserService {

	private IUserDao dao;
	private int num;
	private String s;
	private double d;

	public UserService(){

	}

	public UserService(IUserDao dao){
		this.dao = dao;
	}
	
	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public void reg() {
		
		System.out.println("service---reg---");
		dao.insert(new User());
	}

	@Override
	public String toString() {
		return "UserService [num=" + num + ", s=" + s + ", d=" + d + "]";
	}

	public void reg(User user) {
		System.out.println("reg() -> \n\t"+user);
		dao.insert(user);
	}
	
}
