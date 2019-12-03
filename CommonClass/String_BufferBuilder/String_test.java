package CommonClass.String_BufferBuilder;

import org.junit.Test;
/*
 * String : �ַ���������Ϊfinal�����ɱ��̳У����ɱ��ԣ�
 * 
 * ���ַ������¸�ֵʱ����Ҫ������ָ���ڴ�����ֵ������ʹ��ԭ�е�value��ֵ
 * �����е��ַ����������Ӳ���ʱ��ҲҪ����ָ���ڴ�����ֵ������ʹ��ԭ�е�value��ֵ
 * ����replay()���������޸��ַ����ַ���ʱ��ҲҪ����ָ�ڴ�����ֵ������ʹ��ԭ�е�value��ֵ
 * 
 * �����볣����ƴ�ӽ���ڳ������С�
 * ֻҪ���ַ�����ƴ�ӹ�������һ��Ϊ������������ڶ��У����ƴ�ӵĽ������intern()����������ֵ���ڳ�����
 * 
 * */
public class String_test {

	//�������е��ַ���������
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
	
	//����String�ķ�ʽ
	@Test
	public void test2() {
		//�������д���
		String s1 = "a";
		//�ѿռ��д���
		String s2 = new String();//this.value = new char[0];
//		String s3 = new String(String original);//this.value = original.value;
//		String s4 = new String(char[] a);//this.value = Arrays.copyOf(value , value.length)
//		String s5 = new String(char[] a , int startIndex , int count);
	}
	
	//Stringʵ������ʽ
	@Test
	public void test3() {
		//�������д���������������
		String s1 = "a";
		String s2 = "a";
		//�ѿռ��д�����һ���������������󣩣��������ķ�ʽ
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
	
	@Test
	public void test4() {
		
	}
	
	
	
	
	
	
	
	
}
