package basic.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TargetBean {

	// 值来自于 SourceBean 中的id
	private int id;
	// 值来自于 SourceBean 中的name
	private String name;
	// 值来自于 SourceBean 中的cities的 index=2 的元素
	private String city;
	// 值来自于 SourceBean 中的role
	private String role;
	// 值来自于 SourceBean 中的driverole
	private String drive;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}
	@Override
	public String toString() {
		return "TargetBean [id=" + id + ",\n name=" + name + ",\n city=" + city + ",\n role=" + role + ",\n drive=" + drive
				+ "]";
	}

}
