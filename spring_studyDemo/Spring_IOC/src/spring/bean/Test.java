package spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		Person person = new Person();
//		person.setId(111);
//		person.setName("asd");
//		System.out.println(person);

		// 配置配置文件
		// 初始化容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		// getBean()获取对象
//		Person bean = (Person) ac.getBean("person5");
//		Person bean = ac.getBean(Person.class);//获取的Person类的bean对象需要唯一
		Person bean = ac.getBean("person1" , Person.class);
		System.out.println(bean);
		Person bean2 = ac.getBean("person2" , Person.class);
		System.out.println(bean2);
		Person bean3 = ac.getBean("person3" , Person.class);
		System.out.println(bean3);
		Person bean4 = ac.getBean("person4" , Person.class);
		System.out.println(bean4);
		Person bean5 = ac.getBean("person5" , Person.class);
		System.out.println(bean5);
		
		Dog d2 = ac.getBean("dog2" , Dog.class);
		System.out.println(d2);
		Dog d3 = ac.getBean("dog3" , Dog.class);
		System.out.println(d3);
		Dog d4 = ac.getBean("dog4" , Dog.class);
		System.out.println(d4);
	}

}
