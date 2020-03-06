package JAVA.Collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Test;

/*
 * 集合框架
 *
 * Java容器：数组、集合等对多个数据进行存储（内存层面）操作的结构
 * 
 * Map接口：双列数据，保存具有映射关系“key-value对”的集合
 *		HashMap：主要实现类，线程不安全，效率高，可以存储null的key或value，底层为数组+链表+红黑树
			LinkedHashMap：可以按照添加顺序遍历
		默认扩容为原来的二倍
		当数组中的某一个索引位置上的元素以链表形式存在的个数>8且当前数组长度>64时，此时此索引位置上的所有数据改为红黑树存储
		TreeMap：按照添加的key-value进行排序（key的自然或定制排序）并遍历，底层使用红黑树
		Hashtable：古老实现类，线程安全，效率低
			Properties：处理配置文件（key-value均为String类型）
 *
 *
 * */
public class Map_test {

	@Test
	public void test1() {
		Map map = new HashMap();
		//put(Object o1 , Object o2)添加元素
		map.put("aa", 123);//自动装箱
		map.put("bb", 456);
		map.put("cc", 789);
		map.put("dd", 0);
		map.put("aa", 999);
		map.put("ee", 0);
		//putAll(Map m)将p中的所有映射添加到当前Map
		Map map1 = new HashMap();
		map1.put("BB", 456);
		map1.put("AA", 789);
		map.putAll(map1);
		//remove(Object key)按照key移除映射,返回value
		Object m = map.remove("cc");
		System.out.println(m);
		Object m1 = map.remove("CC");
		System.out.println(m1);
		//clear()清空数据,Map依然存在
//		map.clear();
		
		//get(Object key)获取指定的key对应的value
		System.out.println(map.get(456));
		//containsKey(Object key)是否包含指定额key
		System.out.println(map.containsKey("cc"));
		//containsValue(Object Value)是否包含指定的value
		System.out.println(map.containsValue(789));
		//size()获取map中的映射对个数
		System.out.println(map.size());
		//equals(Object obj)判断当前map和参数对象obj是否相等
		
		System.out.println(map);
	}
	
	//元视图的操作（遍历）
	@Test
	public void test2() {
		Map map = new HashMap();
		map.put("aa", 123);//自动装箱
		map.put("bb", 456);
		map.put("cc", 789);
		map.put("dd", 0);
		
		//遍历所有的key集
		Set set = map.keySet();	//keySet()返回所有key构成的Set集合
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		//遍历所有的values集
		Collection collection = map.values();//values()返回所有value构成的Collection集合
		for(Object obj : collection) {
			System.out.println(obj);
		}
		System.out.println();
		//遍历所有的key-value对
		Set entrySet = map.entrySet();//entrySet()返回所有key-value对构成的Set集合
		Iterator iterator1 = entrySet.iterator();
		while(iterator1.hasNext()) {
			Object obj = iterator1.next();
			Entry entry = (Entry) obj;
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
	
}
