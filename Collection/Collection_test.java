package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
 *集合框架
 *
 *Java容器：数组、集合等对多个数据进行存储（内存层面）操作的结构
 *	
 *Collection接口：单列数据，定义了存取一组对象的方法的集合
 *	List接口（动态数组）：元素有序、可重复的数据集合
 *		ArrayList：主要实现类，线程不安全，效率高，底层使用Object[]（顺序）存储
 *			7.0：初始化直接创建长度为10或指定长度的数组。
 *			8.0：初始化创建为{}（并没有创建长度为10的数组），当第一次调用添加操作，才创建了长度为10的数组，并添加数据
 *			默认扩容为1.5倍，new = old+(old>>1)，同时将原有数组中的元素放入新的数组中
 *		LinkedList：底层使用双向链表（链式）存储
 *		Vector：古老实现类，线程安全，效率低，底层使用Object[]存储
 *	Set接口（集合）：元素无序（非随机性），不可重复的数据集合
 *		HashSet：主要实现类，线程不安全，可以存储null
 *			LinkedHashSet：可以按照添加的顺序遍历（在添加数据同时，还维护了两个引用，记录前后数据）
 *			7.0：初始化直接创建长度为16或指定长度的数组。
 *			8.0：初始化创建为{}（并没有创建长度为10的数组），当第一次调用添加操作，才创建了长度为16的数组，并添加数据
 *			添加元素时，调用该元素所在类的hashCode()方法，计算哈希值，通过散列函数计算出在底层存放的位置，判断此位置是否有元素（或以链表形式存在的多个元素）
 *					（没有：添加成功	有：比较两元素的哈希值，相同哈希值调用equals方法判断元素是否相同添加与否）
 *			当使用率超过0.75，扩容为原来的2倍
 *		TreeSet：可以按照添加对象的指定属性进行排序（自然排序、定制排序），底层使用红黑树（平衡二叉树）存储
 *
 **/
public class Collection_test{
	
//Collection
	@Test
	public void test1() {
		Collection col = new ArrayList();
		//add(Object e)添加元素
		col.add("aa");
		col.add(123);//自动装箱
		//size()获取添加的元素的个数
		System.out.println(col.size());
		//addAll(Collection col1)将col1中的所有元素添加到当前集合
		Collection col1 = new ArrayList();
		col1.add("bb");
		col1.add(456);
		col.addAll(col1);
		System.out.println(col.size());
		//clear()清空集合元素
//		col.clear();
		//isEmpty()判断当前集合是否为空（有元素）
		System.out.println(col.isEmpty());
		//contains(Object e)判断当前集合中是否包含e，判断时会调用对象所在类的equals()方法
		System.out.println(col.contains("bb"));
		//containsAll(Collection co2)判断col2中的所有元素是否都存在于当前集合
		Collection col2 = Arrays.asList(123 , 456);
		System.out.println(col.containsAll(col2));
		//remove(Object e)从当前集合中删除e元素
//		col.remove(456);
//		System.out.println(col2);
		//removeAll(Collection col3)从当前集合中删除col3中的所有元素
//		Collection col3 = Arrays.asList("aa" , "bb");
//		col.removeAll(col3);
//		System.out.println(col);
		//retainAll(Collection col4)获取当前集合和col4的交集，并返回给当前集合
		Collection col4 = Arrays.asList(123 , "aa");
		col.retainAll(col4);
		System.out.println(col);
		//equals(Object e)比较当前对象与形参对象的元素是否相等
		Collection col5 = new ArrayList();
		col5.add("aa");
		col5.add(123);
		System.out.println(col.equals(col5));
		//hashCode()返回当前对象的哈希值
		System.out.println(col.hashCode());
		//toArray()集合-->数组
		Object[] obj = col.toArray();
		for (int i = 0 ; i < obj.length ; i++) {
			System.out.println(obj[i]);
		}
		System.out.println("***************");
		
		
		//iterator()返回Iterator（迭代器）接口的实例，用于遍历集合元素
		Iterator iterator = col.iterator();
		System.out.println(iterator.next());//获取一个元素
		while(iterator.hasNext()) {//遍历元素
			System.out.println(iterator.next());
		}
	}
	@Test	//迭代器练习
	public void test2() {
		String[] str = new String[] {"MM" , "MM" , "MM"};
		//方式一
		for (int i = 0 ; i < str.length ; i++) {
			str[i] = "GG";
		}
		//方式二
		for (String s : str) {
			s = "GG";
		}
		for (int i = 0 ; i < str.length ; i++) {
			System.out.println(str[i]);
		}
	}
		
//List
	@Test
	public void test3() {
		ArrayList list = new ArrayList();
		//add(Object e)增加数据
		list.add(123);
		list.add(456);
		list.add("abc");
		//add(int index, Object e)在指定位置插入数据
		list.add(1 , "def");
		//addAll(int index, Object e)从指定位置开始将list1的所有元素添加到当前集合
		List<Integer> list1 =Arrays.asList(1,2,3);
		list.addAll(2, list1);
		//indexOf(Object e)返回当前集合中首次出现该元素的索引
		System.out.println(list.indexOf(456));
		//lastIndexOf(Object e)返回当前集合中最后一次出现该元素的索引
		System.out.println(list.lastIndexOf(456));
		//remove(int index)移除指定位置的元素，并返回该元素
		Object obj = list.remove(2);
		System.out.println(obj);
		//set(int index, Object e)设置指定位置的元素为e
		list.set(0, "GG");
		//subList(int fromIndex , int toIndex)返回指定位置之间的元素子集合
		List list2 = list.subList(2, 4);
		System.out.println(list2);
		System.out.println(list);
	}
	
//Set
	@Test
	public void test4() {
		//HashSet
		Set set = new HashSet();
		set.add(456);
		set.add(132);
		set.add(798);
		set.add("aa");
		set.add("aa");
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("*******************");
		
		//LinkedHashSet
		Set set1 = new LinkedHashSet();
		set1.add(456);
		set1.add(132);
		set1.add(798);
		set1.add("aa");
		set1.add("aa");
		
		Iterator iterator1 = set1.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		
		System.out.println("*******************");
		
		//LinkedHashSet（添加的数据由相同类的实例化的）
		Set set2 = new TreeSet();
		set2.add(456);
		set2.add(132);
		set2.add(798);
		set2.add(2);
		set2.add(8);
		set2.add(5);
		
		Iterator iterator2 = set2.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
	}
	
}
