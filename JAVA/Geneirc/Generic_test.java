package JAVA.Geneirc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * 泛型
 * 
 * 在集合中使用泛型：
 * 		集合接口及集合类都带泛型结构
 * 		实例化集合类时，需要指明集体的泛型的类型
 * 		在已经定义的集合类或接口时，内部结构使用到的类的泛型的位置，均指定为实例化时泛型的类型
 * 注意
 * 	泛型的类型必须为一个类，基本数据类型用包装类替换。
 * 	如果实例化时未使用泛型，默认类型为object类型。
 * 	泛型不同的引用不能相互赋值
 * 	静态方法中不能用类的泛型
 * 	异常类不能声明为泛型
 * 
 * 自定义泛型
 * 	泛型类（接口）、方法		Generic_Demo.java
 * 
 * A是B的父类(通配符?)
		G(A)不是G(B)的父类，但是G(?)是G(A)和G(B)的父类
		A(G)是B(G)的父类
		使用通配符时，无法向里面添加数据
 * 
 * 有限制条件的通配符的使用
 * 		? extends A; 	?代表A及A的子类
 * 		? super A;		?代表A及A的父类
 * 
 * */

public class Generic_test {

	//ArrayList不使用泛型
	@Test
	public void test() {
		ArrayList arr = new ArrayList();
		//正常数据
		arr.add(78);
		arr.add(89);
		
		//问题
		arr.add("asd");		//可以错误类型数据，类型不安全
		for (Object a : arr) {
			int num = (Integer) a;		//强转时，出现类型转换异常
			System.out.println(num);
		}
	}
	
	//ArrayList使用泛型
	@Test
	public void test1() {
//		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr = new ArrayList<>();		//类型推断
		//加入数据
		arr.add(78);
		arr.add(89);
		
//		arr.add("asd");		//编译时进行数据检查，保证类型安全
		for (Integer a : arr) {
			int num  = a;		//避免了强转操作
			System.out.println(num);
		}
		Iterator<Integer> iter = arr.iterator();
		while(iter.hasNext()) {
			int num = iter.next();
			System.out.println(num);
		}
	}
	
	//HashMap使用泛型
	@Test
	public void test2() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("asd", 78);
		map.put("zxc", 89);
		
//		map.put(123, "qwe");	//无法添加错误类型数据
		Set<Map.Entry<String, Integer>> entry = map.entrySet();		//泛型嵌套
		Iterator<Map.Entry<String, Integer>> iter = entry.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Integer> e = iter.next();
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key + "     " + value);
		}
		
	}
	
	//通配符问题
	@Test
	public void test3() {
		List<? extends order> list1 = null;		//?代表A及A的子类
		List<? super order> list2 = null;		//?代表A及A的父类
		
		List<SubOrder> list3 = null;
		List<SubOrder1> list4 = null;
		List<Object> list5 = null;
		
		
		list1 = list3;
		list1 = list4;
//		list1 = list5;
		
//		list2 = list3;
//		list2 = list4;
		list2 = list5;
	}
	
}




