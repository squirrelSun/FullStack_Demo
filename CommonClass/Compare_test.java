package CommonClass.ComareTest;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/*
 * java�Ƚ���
 * 
 * Comparable����Ȼ���򣩣���װ���ʵ���˽ӿڣ���д��compareTo(  o)�����������Ƚ���������Ĺ���
 * 		��ǰ��������βζ���obj������������
 * 		��ǰ����С���βζ���obj�����ظ�����
 * 		��ǰ��������βζ���obj��������
 * 	�Զ����࣬ʵ��Comparable�ӿڣ���дcompareTo()�������ڷ�����ָ���������
 * 
 * Compartor���������򣩣���дcompare(Object o1, Object o2)�������Ƚ�o1��o2�Ĵ�С
 * 
 * 	�Աȣ�Comparableһ��ָ�����κ�ʵ����Ķ��󶼿��ԱȽϴ�С
 * 		Compartor��ʱ�Ե�ʹ�ã�һ���ԣ�
 * 
 * */
public class Compare_test {
	
	@Test
	public void test1() {
		//Comparable�ӿ�
		String[] str1 = new String[] {"aa" , "qq" , "bb"};
		Arrays.sort(str1);
		System.out.println(Arrays.toString(str1));
		
		
		//Compartor�ӿ�
		String[] str2 = new String[] {"aa" , "qq" , "bb"};
		Arrays.sort(str2 , new Comparator() {
			public int compare(Object o1, Object o2) {
				//�ж��߼�
				if (o1 instanceof String && o2 instanceof String) {
					String s1 = (String)o1;
					String s2 = (String)o2;
					return -s1.compareTo(s2);	//�Ӵ�С����
				}
				throw new RuntimeException("�������ݷǷ�");
			}
		});
		System.out.println(Arrays.toString(str2));
	}
	
}

//Comparable�ӿ�
class Test1 implements Comparable{

	public int compareTo(Object o) {
		//�ж��߼�
		return 0;
	}
	
}
