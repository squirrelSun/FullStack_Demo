package spring.bean;

import java.util.List;

public class Person {

	private Integer id;
	private String name;
	private Dog dog;
	private List<String> cls;
	
	

	public Dog getDog() {
		return dog;
	}

	public Person(Integer id, String name, Dog dog, List<String> cls) {
		super();
		this.id = id;
		this.name = name;
		this.dog = dog;
		this.cls = cls;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public List<String> getCls() {
		return cls;
	}

	public void setCls(List<String> cls) {
		this.cls = cls;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dog=" + dog + ", cls=" + cls + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() {
		super();
	}
	
	
	
}
