package bean.entity;

public class User_Singleton {

//	饿汉式加载：Eager Singleton：
//						lazy-init="default" / "false"
	
//	private static User_Singleton user = new User_Singleton();
//	
//	private User_Singleton() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public static User_Singleton getInstance() {
//		return user;
//	}
	
	
	
//	懒汉式加载：Lazy Singleton
//						lazy-init="true"
	
	private static User_Singleton user = null;
	private static Object lock = new Object();
	
	private User_Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static User_Singleton getInstance() {
		if(user==null) {
			synchronized (lock) {
				if(user==null) {
					user = new User_Singleton();
				}
			}
		}
		return user;
	}
	
	
}
