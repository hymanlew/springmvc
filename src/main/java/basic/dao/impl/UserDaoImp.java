package basic.dao.impl;

import basic.dao.IUserDao;
import basic.entity.User;

public class UserDaoImp implements IUserDao {

	private int num;
	private String s;
	private double d;
	
	
	
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


	@Override
	public void insert(User user) {
		System.out.println("User--2.insert() -> "+user);
	}

}
