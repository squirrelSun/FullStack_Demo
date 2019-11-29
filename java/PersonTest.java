package java;

//������
//���������������������

public class PersonTest {

	public static void main(String[] args) {	
		Worker worker=new Worker();
		
		
		method1(worker);	//��������������ķ���������
		
		method1(new Worker());		//�����������������������
		
		//��������	
		Person p=new Person() {	
			public void eat() {
			}
			public void breath() {
			}
		};
		method1(p);		//������������ķ���������
		
		method1(new Person() {		//���������������������
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
	String name;
	int age;
	
	public Person() {
		
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public abstract void eat();
	
	public void walk() {
		System.out.println("��·");
	}
}

class Student extends Person{
	
	public Student() {
	}
	
	public Student(String name,int age) {
		super(name,age);
	}

	public void eat() {
		System.out.println("ѧ���Է�");
	}

	public void breath() {
		System.out.println("ѧ������");
	} 
}

class Worker extends Person{

	public void eat() {
	}

	public void breath() {
	}
	
}
