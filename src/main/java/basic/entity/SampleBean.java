package basic.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SampleBean {

	private String name;
	private String tag;

	// 建议使用包装类型
	private Integer id;
	private Date date;
	private List<String> list;
	private Set<String> unOrderData;
	private Map<String,Object> map;
	private Properties properties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	//如果构造器里面的是全部的参数，则 xml 文件中配置了两次值（构造与set方法）
	//则 set 的值会替换掉 构造器里的值
	public SampleBean(String tag,Integer id) {
		super();
		this.tag = tag;
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SampleBean [name=" + name + ", tag=" + tag + ", id=" + id + ", date=" + date + "]";
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getUnOrderData() {
		return unOrderData;
	}

	public void setUnOrderData(Set<String> unOrderData) {
		this.unOrderData = unOrderData;
	}

	public Map<String,Object> getMap() {
		return map;
	}

	public void setMap(Map<String,Object> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
