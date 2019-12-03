package CommonClass.String_BufferBuilder;

import org.junit.Test;

/*
 * StringBuffer与StringBuilder
 * 
 * 
 * String :不可变的字符序列，
 * StringBuffer（多线程使用） :可变的字符序列，线程安全，效率低
 * StringBuilder（单线程使用） :可变的字符序列，线程不安全，效率高
 * 
 * 底层均是用char[]存储
 * String str = new String();//char[] value = new char[0];
 * String str1 = new String("abc");//char[] value = new char[]{'a' , 'b' , 'c'};
 * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];
 * StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length + 16]{'a' , 'b' , 'c'};
 * 
 * 扩容问题：
 * 添加的数据超过预留的16个空位，默认情况下，扩容为原来数组长度*2+2，同时将原有数组中的元素放入新的数组中
 * 
 * 
 * */

public class StringBufferBuilder_test {

	@Test
	public void test() {
		StringBuffer sb1 = new StringBuffer("abc");
		sb1.setCharAt(0, 'm');
		System.out.println(sb1);
		System.out.println(sb1.length());//3
	}
	
	
}
