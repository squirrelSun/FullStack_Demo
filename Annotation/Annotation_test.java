package Annotation;

import java.lang.annotation.Annotation;
import java.util.Date;
import org.junit.Test;

/*
 *  注解（代码中的特殊标记）
 *	①生成文档相关的注视
 *	②JDK的三个基本注解（编译时进行格式检查）
 *		@Override：限定重写父类方法，只能用于方法
 *		@Deprecated：表示所修饰的类已过时
 *		@SuppressWarnings：抑制编译器警告
 *	③跟踪代码依赖性，实现替代配置文件功能
 * 
 * 元注解（对现有的注解进行解释说明的注解）
 * 	@Retention	指定所修饰的Annotation的生命周期：SOURCE/CLASS(默认行为)/RUNTIME
 * 					只有声明为RUNTIME声明周期的注解，才能通过反射获取
 * 	@Target		指定所修饰的Annotation能够修饰哪些程序元素
 * 	@Documented	指定所修饰的Annotation在被javadoc解析时会保留下来
 * 	@Inherited	指定所修饰的Annotation将具有继承性
 * 
 * 通过反射获取注解信息
 * */
public class Annotation_test {

	@Test
	public void test1() {
		Person p = new Student();
		p.walk();
		
		Date date = new Date(2020, 12, 31);		//@Deprecated
		System.out.println(date);
		
		@SuppressWarnings("unused")
		int num = 0;
		
		//反射
		Class studentClass = Student.class;
		Annotation[] annotations = studentClass.getAnnotations();
		for (int i = 0 ; i < annotations.length ; i++) {
			System.out.println(annotations[i]);
		}
		
	}
	
}

@MyAnnotation
//@MyAnnotation(value = "hellow")
class Person{
	private String name;
	private int age;
	
	public Person() {
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void eat() {
		System.out.println("吃饭");
	}
	
	public void walk() {
		System.out.println("走路");
	}
	
}

interface Info{
	void show();
}

class Student extends Person implements Info{
	@Override
	public void walk() {
		System.out.println("学生走路");	
	}

	@Override
	public void show() {
		
	}
} 


