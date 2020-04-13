package spring.life;

public class Person {

	private Integer id;
	private String sex;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("依赖注入");
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "使用	Person [id=" + id + ", sex=" + sex + ", name=" + name + "]";
	}

	public Person() {
		System.out.println("创建对象");
	}

	public void init() {
		System.out.println("初始化");
	}
	
	public void destroy() {
		System.out.println("销毁");
	}
	
}
