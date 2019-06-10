package mvc.spring.bean;

// 当前类，只是起到测试作用，不做任何的业务
public class User {

	private String name;
	private String password;
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
