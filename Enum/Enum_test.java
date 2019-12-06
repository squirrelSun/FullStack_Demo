package Enum;
/*
 * ö����
 * ��Ķ���ֻ��ȷ�������޸�������������һ�鳣���������ö������ֻ��һ���࣬����Ϊ����ģʽ��ʵ��
 * 
 * 	��ʽһ���Զ���ö����
 *  ��ʽ����enum�ؼ��֣���ʵ�ֽӿڣ�������Ϊjava.long.Enum
 *  
 * Enum��
 *  toString()�����ص�ǰö���������������
 *  values()������ö�����͵Ķ�������
 *  valueof()�������ṩ��objName,����ö�����ж�����ΪobjName�Ķ���
 * */

import org.junit.Test;

public class Enum_test {
	
	@Test
	public void test1() {
		Season Spring = Season.SPRING;
		System.out.println(Spring);
	}
	
	@Test
	public void test2() {
		season Summer = season.SUMMER;
		System.out.println(Summer.toString());
		season[] values = season.values();
		for (int i = 0 ; i < values.length ; i++) {
			System.out.println(values[i]);
		}
		
		season winter = season.valueOf("WINTER");	
		System.out.println(winter.toString());
		season asd = season.valueOf("asdasd");	//���û�ҵ�objName�Ķ��󣬻�����쳣IllegalArgumentException
		System.out.println(winter.toString());
	}
	
}

//�Զ���ö����
class Season{
	//����Season���������(private final)
	private final String seasonName;
	private final String seasonDesc;
	
	//˽�л���Ĺ�����
	private Season(String seasonName , String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	//�ṩ��ǰö����Ķ���(public static final)
	public static final Season SPRING = new Season("����" , "qwer");
	public static final Season SUMMER = new Season("����" , "asdf");
	public static final Season AUTUMN = new Season("����" , "zxcv");
	public static final Season WINTER = new Season("����" , "wasd");

	//��ȡö������������
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	
	//��дtoString����
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	
}

//ʹ��enum�ؼ��ִ���ö����
enum season{		
	//�ṩ��ǰö����Ķ���
	SPRING("����" , "qwer"),
	SUMMER("����" , "asdf"),
	AUTUMN("����" , "zxcv"),
	WINTER("����" , "wasd");
	
	//����Season���������(private final)
	private final String seasonName;
	private final String seasonDesc;
	
	//˽�л���Ĺ�����
	private season(String seasonName , String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	//��ȡö������������
		public String getSeasonName() {
			return seasonName;
		}
		public String getSeasonDesc() {
			return seasonDesc;
		}
}




