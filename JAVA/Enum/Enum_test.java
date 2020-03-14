package JAVA.Enum;


/*
 * 枚举类
 * 类的对象只有确定的有限个（常用来定义一组常量），如果枚举类中只有一个类，可视为单例模式的实现
 * 
 * 	方式一：自定义枚举类
 *  方式二：enum关键字（可实现接口）：父类为java.long.Enum
 *  
 * Enum：
 *  toString()：返回当前枚举类对象常量的名称
 *  values()：返回枚举类型的对象数组
 *  valueof()：根据提供的objName,返回枚举类中对象名为objName的对象
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
		season1 Summer = season1.SUMMER;
		System.out.println(Summer.toString());
		season1[] values = season1.values();
		for (int i = 0 ; i < values.length ; i++) {
			System.out.println(values[i]);
		}
		
		season1 winter = season1.valueOf("WINTER");	
		System.out.println(winter.toString());
		season1 asd = season1.valueOf("SUMMER");	//如果没找到objName的对象，会出现异常IllegalArgumentException
		System.out.println(asd.toString());
	}
	
	@Test
	public void test3() {
		char ch1=97;
        char ch2='a';
        System.out.println(" ch1="+ch1);
        System.out.println(" ch2="+ch2);
	}
	
}

//自定义枚举类
class Season{
	//声明Season对象的属性(private final)
	private final String seasonName;
	private final String seasonDesc;
	
	//私有化类的构造器
	private Season(String seasonName , String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	//提供当前枚举类的对象(public static final)
	public static final Season SPRING = new Season("春天" , "qwer");
	public static final Season SUMMER = new Season("夏天" , "asdf");
	public static final Season AUTUMN = new Season("秋天" , "zxcv");
	public static final Season WINTER = new Season("冬天" , "wasd");

	//获取枚举类对象的属性
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	
	//重写toString方法
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	
}

//使用enum关键字创建枚举类
enum season1{		
	//提供当前枚举类的对象
	SPRING("春天" , "qwer"),
	SUMMER("夏天" , "asdf"),
	AUTUMN("秋天" , "zxcv"),
	WINTER("冬天" , "wasd");
	
	//声明Season对象的属性(private final)
	private final String seasonName;
	private final String seasonDesc;
	
	//私有化类的构造器
	private season1(String seasonName , String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	//获取枚举类对象的属性
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
}




