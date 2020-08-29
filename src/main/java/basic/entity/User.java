package basic.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 	JAVA BEAN
	 * 	1，实现 Serializable 接口并生成 UID
	 * 	2，所有属性都是私有的
	 * 	3，为所有属性（除了 static,final 修饰的属性）提供 set/get方法
	 * 	4，保证存在公有的，无参数的构造方法（可以不写出来，会自动生成）
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}
