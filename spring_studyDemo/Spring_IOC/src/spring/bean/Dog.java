package spring.bean;

import java.util.List;
import java.util.Map;

public class Dog {

	private Integer num;
	private String dname;
	private List<Person> person;
	private Map<Integer, Integer> birth;
	
	public Map<Integer, Integer> getBirth() {
		return birth;
	}

	public void setBirth(Map<Integer, Integer> birth) {
		this.birth = birth;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public List<Person> getPerson() {
		return person;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Dog [num=" + num + ", dname=" + dname + ", person=" + person + ", birth=" + birth + "]";
	}

}
