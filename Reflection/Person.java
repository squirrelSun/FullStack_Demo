package Reflection;

public class Person extends Coeater<String> implements Comparable<String>, MyInterface {

	private String name;
	int age;
	public int id;

	public Person() {
		super();
	}

	private Person(String name) {
		super();
		this.name = name;
	}

	Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}

	public void show() {
		System.out.println("Person.show()");
	}

	private String show(String nation) {
		System.out.println("国籍为：" + nation);
		return nation;
	}

	public String display(String interests) throws NullPointerException, ClassCastException {
		return interests;
	}

	@Override
	public void info() {
		System.out.println("我是人");
	}

	@Override
	public int compareTo(String o) {
		return 0;
	}

	private static void showDESC() {
		System.out.println("我是一个人");
	}
}
