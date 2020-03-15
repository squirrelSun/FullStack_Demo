package JAVA.javas;

//抽象类
//子类与对象的匿名创建情况

public class PersonTest {

	public static void main(String[] args) {	
		Worker worker=new Worker();
		
		
		method1(worker);	//创建非匿名子类的非匿名对象
		
		method1(new Worker());		//创建非匿名子类的匿名对象
		
		//匿名子类	
		Person p=new Person() {	
			public void eat() {
			}
			public void breath() {
			}
		};
		method1(p);		//创建匿名子类的非匿名对象
		
		method1(new Person() {		//创建匿名子类的匿名对象
			public void eat() {
			}
			public void breath() {
			}
		});
		
	}
	
	public static void method(Student s) {
		
	}
	
	public static void method1(Person p) {
		
	}
	
}

abstract class Creature{
	public abstract void breath();
}

abstract class Person extends Creature{
	public String name;
	public int age;
	
	public Person() {
		
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public abstract void eat();
	
	public void walk() {
		System.out.println("走路");
	}
}

class Student extends Person{
	
	public Student() {
	}
	
	public Student(String name,int age) {
		super(name,age);
	}

	public void eat() {
		System.out.println("学生吃饭");
	}

	public void breath() {
		System.out.println("学生呼吸");
	} 
}

class Worker extends Person{

	public void eat() {
	}

	public void breath() {
	}
	
}
