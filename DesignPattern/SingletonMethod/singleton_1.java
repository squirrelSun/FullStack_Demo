package SingletonMethod;

/*
 * 单例设计模式
 * 饿汉式实现（2种）
 * 
 * 保证在整个软件系统中，对某个类只能存在一个对象
 * 
 * 好处：类装载时完成实例化，线程是安全的
 * 坏处：对象加载时间过长，占用系统内存
 * 
 * */
public class singleton_1 {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
		System.out.println("s1 = " + s1.hashCode());
		System.out.println("s2 = " + s2.hashCode());
	}

}

//静态常量创建
class Singleton {

//	1.私有化类的构造器，使得外部无法创建对象
	private Singleton() {

	}

//	2.内部创建静态对象
	private final static Singleton instance = new Singleton();

//	3.提供公共静态方法，返回类的对象
	public static Singleton getInstance() {
		return instance;
	}

}

//静态代码块创建
class Singleton2 {

//	1.私有化类的构造器，使得外部无法创建对象
	private Singleton2() {

	}

//	2.内部声明静态对象
	private static Singleton2 instance;

//	3.静态代码块创建对象
	static {
		instance = new Singleton2();
	}

//	4.提供公共静态方法，返回类的对象
	public static Singleton2 getInstance() {
		return instance;
	}

}
