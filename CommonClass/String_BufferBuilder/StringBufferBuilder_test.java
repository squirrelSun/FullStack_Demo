package CommonClass.String_BufferBuilder;

import org.junit.Test;

/*
 * StringBuffer��StringBuilder
 * 
 * 
 * String :���ɱ���ַ����У�
 * StringBuffer�����߳�ʹ�ã� :�ɱ���ַ����У��̰߳�ȫ��Ч�ʵ�
 * StringBuilder�����߳�ʹ�ã� :�ɱ���ַ����У��̲߳���ȫ��Ч�ʸ�
 * 
 * �ײ������char[]�洢
 * String str = new String();//char[] value = new char[0];
 * String str1 = new String("abc");//char[] value = new char[]{'a' , 'b' , 'c'};
 * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];
 * StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length + 16]{'a' , 'b' , 'c'};
 * 
 * �������⣺
 * ��ӵ����ݳ���Ԥ����16����λ��Ĭ������£�����Ϊԭ�����鳤��*2+2��ͬʱ��ԭ�������е�Ԫ�ط����µ�������
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
