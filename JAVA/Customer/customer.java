package JAVA.Customer;

public class customer {
	String name;
	String sex;
	int age;
	long telephone;
	String email;
	
	public customer(String name, String sex, int age, long telephone, String email) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName() {
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex() {
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge() {
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone() {
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail() {
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
