package JAVA.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
 * collections:操作Collection、Map的工具类
 * */
public class Collections_test {

	@Test
	public void test1() {
		List list = new ArrayList();
		list.add(123);
		list.add(465);
		list.add(789);
		list.add(999);
		list.add(0);
		list.add(55);
		System.out.println(list);
		
		//reverse(List);反转List中元素的顺序
//		Collections.reverse(list); 
		//shuffle(List)对List集合元素进行随机排序
//		Collections.shuffle(list);
		//sort(List)根据元素的自然顺序对指定的List集合进行随机排序
//		Collections.sort(list);
		//swap(List , i , j)将指定LIst集合中的元素i处元素与j处元素进行交换
//		Collections.swap(list , 1 , 2);
		
		System.out.println(list);
		
		//frequency(list , Object)返回在指定的List中该元素出现的次数
		int frequency = Collections.frequency(list , 456);
		System.out.println(frequency);
		//copy(List dest , List src)将src中的内容复制到dest中
		List dest = Arrays.asList(new Object[list.size()]);
		Collections.copy(dest , list);
		System.out.println(dest);
	}

//synchronizedXxx(),将指定集合包装成线程同步二点集合并返回，线程安全
	@Test
	public void test2() {
		List list = new ArrayList();//线程不安全
		List list1 = Collections.synchronizedList(list);//线程安全
		Map map = new HashMap();//线程不安全
		Map map1 = Collections.synchronizedMap(map);//线程安全
		
	}
}
