package JAVA.CommonClass.String_BufferBuilder;

import org.junit.Test;
/*
 * String : 字符串，声明为final，不可被继承（不可变性）
 * 
 * 对字符串重新赋值时，需要在重新指定内存区域赋值，不能使用原有的value赋值
 * 对现有的字符串进行连接操作时，也要重新指定内存区域赋值，不能使用原有的value赋值
 * 调用replay()方法进行修改字符或字符串时，也要重新指内存区域赋值，不能使用原有的value赋值
 * 
 * 常量与常量的拼接结果在常量池中。
 * 只要在字符串的拼接过程中有一个为变量，结果就在堆中，如果拼接的结果调用intern()方法，返回值就在常量池
 * 
 * */
public class String_test {

	//方法区中的字符串常量池
	@Test
	public void test1() {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);
		s1 = "def";
		System.out.println(s1 = s2);
		String s3 = s2 + "h";
		System.out.println(s3 == s2);
		String s4 = s2.replace("c", "q");
		System.out.println(s4 == s2);
	}
	
	//创建String的方式
	@Test
	public void test2() {
		//常量池中创建
		String s1 = "a";
		//堆空间中创建
		String s2 = new String();//this.value = new char[0];
//		String s3 = new String(String original);//this.value = original.value;
//		String s4 = new String(char[] a);//this.value = Arrays.copyOf(value , value.length)
//		String s5 = new String(char[] a , int startIndex , int count);
	}
	
	//String实例化方式
	@Test
	public void test3() {
		//常量池中创建，字面量定义
		String s1 = "a";
		String s2 = "a";
		//堆空间中创建（一共创建了两个对象），构造器的方式
		String s3 = new String("a");
		String s4 = new String("a");
		
		System.out.println(s1 == s2);//true
		System.out.println(s3 == s4);//false
		System.out.println(s1 == s3);//false
		System.out.println(s1.equals(s2));//true
		System.out.println(s3.equals(s4));//true
		System.out.println(s1.equals(s3));//true
		
		System.out.println("****************************");
		
		String s21 = "a";
		String s22 = "b";
		String s23 = "ab";
		String s24 = "a" + "b";
		String s25 = s21 + "b";
		String s26 = "a" + s22;
		String s27 = s21 + s22;
		String s28 = s27.intern();
		System.out.println(s23 == s24);//true
		System.out.println(s23 == s25);//false
		System.out.println(s23 == s26);//false
		System.out.println(s24 == s25);//false
		System.out.println(s24 == s26);//false
		System.out.println(s25 == s26);//false
		System.out.println(s25 == s27);//false
		System.out.println(s26 == s27);//false
		System.out.println(s23 == s28);//true
	}
	
}
