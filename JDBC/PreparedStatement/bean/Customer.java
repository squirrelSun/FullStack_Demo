package JDBC.PreparedStatement.bean;

import java.sql.Date;

/*
 * ORM的编程思想
 * 
 * 每一个数据表对应一个Java类
 * 每一条记录对应一个Java类的对象
 * 每一个字段对应一个Java类对象的属性
 * */

public class Customer {

	private int id;
	private String name;
	private String email;
	private Date birth;

	public Customer(int id, String name, String eamil, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.email = eamil;
		this.birth = birth;
	}

	public Customer() {
		super();
	}

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

	public String getEamil() {
		return email;
	}

	public void setEamil(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", eamil=" + email + ", birth=" + birth + "]";
	}

}
