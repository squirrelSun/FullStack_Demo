package Geneirc;

import java.util.List;

import org.junit.Test;

/*
 * 自定义泛型
 * 	泛型类（接口）
 * 		order.java、SubOrder.java、SubOrder1.java
 * 	方法
 * 		在方法中出现了泛型的结构，泛型参数与类的泛型没有任何关系（泛型方法可以不是泛型类）
 * 		可以声明为静态方法
 * 		order.copy()方法
 * */

public class Generic_Demo {

	@Test
	public void test1() {
		order o = new order();		//定义了泛型类，实例化时为声明泛型类型，默认为object类型
		o.setOrderE(123);
		o.setOrderE("asd");
		
		order<String> o1 = new order<>("asd",12,"abc");
		o1.setOrderE("def");
	}
	
	@Test
	public void test2() {
		SubOrder sub1 = new SubOrder();
		//子类继承泛型父类时指明了泛型类型，在实例化对象时，不需要指明泛型类型。
		sub1.setOrderE(1122);
		//子类继承泛型父类时未指明泛型类型，在实例化对象时，需要指明泛型类型。
		SubOrder1<String> sub2 = new SubOrder1<>();
		sub2.setOrderE("asd");
	}
	
	@Test
	public void test3() {
		order<String> o1 = null;
		order<Integer> o2 = null;
		
		//泛型不同的引用不能相互赋值
//		o1 = o2;
	}
	
	@Test
	public void test4() {
		order<String> o = new order<>();
		Integer[] arr = new Integer[] {1,2,3};
		//泛型方法在调用时指定泛型类型，该类型与类的泛型无关
		List<Integer> list = order.copy(arr);
		
		System.out.println(list);
	}
	
}
