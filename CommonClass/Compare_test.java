package CommonClass.ComareTest;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/*
 * java比较器
 * 
 * Comparable（自然排序）：包装类等实现了接口，重写了compareTo(  o)方法，给出比较两个对象的规则：
 * 		当前对象大于形参对象obj，返回正整数
 * 		当前对象小于形参对象obj，返回负整数
 * 		当前对象等于形参对象obj，返回零
 * 	自定义类，实现Comparable接口，重写compareTo()方法，在方法中指明如何排序
 * 
 * Compartor（定制排序）：重写compare(Object o1, Object o2)方法，比较o1、o2的大小
 * 
 * 	对比：Comparable一旦指定，任何实现类的对象都可以比较大小
 * 		Compartor临时性的使用（一次性）
 * 
 * */
public class Compare_test {
	
	@Test
	public void test1() {
		//Comparable接口
		String[] str1 = new String[] {"aa" , "qq" , "bb"};
		Arrays.sort(str1);
		System.out.println(Arrays.toString(str1));
		
		
		//Compartor接口
		String[] str2 = new String[] {"aa" , "qq" , "bb"};
		Arrays.sort(str2 , new Comparator() {
			public int compare(Object o1, Object o2) {
				//判断逻辑
				if (o1 instanceof String && o2 instanceof String) {
					String s1 = (String)o1;
					String s2 = (String)o2;
					return -s1.compareTo(s2);	//从大到小排序
				}
				throw new RuntimeException("输入数据非法");
			}
		});
		System.out.println(Arrays.toString(str2));
	}
	
}

//Comparable接口
class Test1 implements Comparable{

	public int compareTo(Object o) {
		//判断逻辑
		return 0;
	}
	
}
