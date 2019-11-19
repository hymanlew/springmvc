package mvc.spring.bean;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

// 当前类，只是起到测试作用，不做任何的业务
public class User implements Serializable {

	/**
	 * 使用 value 注解进行赋值：
	 * 1，基本数值。
	 * 2，SpEL 表达式 #{}。
	 * 3，${} 取出配置文件中的值（properties 文件中的值，即运行环境变量里面的值）
	 */

	@Value("张三")
	private String name;

	@Value("#{20-3}")
	private String password;

	@Value("${user.salary}")
	private int salary;
	
	public User() {
		System.out.println("i am user");
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", salary=" + salary + "]";
	}
	
	
}
