package Annotation;

import java.lang.annotation.Annotation;
import java.util.Date;
import org.junit.Test;

/*
 *  ע�⣨�����е������ǣ�
 *	�������ĵ���ص�ע��
 *	��JDK����������ע�⣨����ʱ���и�ʽ��飩
 *		@Override���޶���д���෽����ֻ�����ڷ���
 *		@Deprecated����ʾ�����ε����ѹ�ʱ
 *		@SuppressWarnings�����Ʊ���������
 *	�۸��ٴ��������ԣ�ʵ����������ļ�����
 * 
 * Ԫע�⣨�����е�ע����н���˵����ע�⣩
 * 	@Retention	ָ�������ε�Annotation���������ڣ�SOURCE/CLASS(Ĭ����Ϊ)/RUNTIME
 * 					ֻ������ΪRUNTIME�������ڵ�ע�⣬����ͨ�������ȡ
 * 	@Target		ָ�������ε�Annotation�ܹ�������Щ����Ԫ��
 * 	@Documented	ָ�������ε�Annotation�ڱ�javadoc����ʱ�ᱣ������
 * 	@Inherited	ָ�������ε�Annotation�����м̳���
 * 
 * ͨ�������ȡע����Ϣ
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
		
		//����
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
		System.out.println("�Է�");
	}
	
	public void walk() {
		System.out.println("��·");
	}
	
}

interface Info{
	void show();
}

class Student extends Person implements Info{
	@Override
	public void walk() {
		System.out.println("ѧ����·");	
	}

	@Override
	public void show() {
		
	}
} 


