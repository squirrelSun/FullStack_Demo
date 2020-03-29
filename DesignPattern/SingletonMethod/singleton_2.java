package SingletonMethod;

/*
 * 单例设计模式
 * 懒汉式实现（3种）
 * 
 * 保证在整个软件系统中，对某个类只能存在一个对象
 * 
 * 好处：延时对象的创建 
 * 
 * */

public class singleton_2 {

	public static void main(String[] args) {
		Order r1 = Order.getInstance();
		Order r2 = Order.getInstance();
		System.out.println(r1 == r2);
		System.out.println("r1 = " + r1.hashCode());
		System.out.println("r2 = " + r2.hashCode());
	}

}

class Order {

//	1.私有化类的构造器
	private Order() {

	}

//	2.声明当前类的静态对象，没有初始化
	private static volatile Order instance;

//	3.提供公共静态方法，返回类的对象（创建对象）
//	①同步方法（同步效率低）
//	public static synchronized Order getInstance() {
//		if (instance == null) {
//			instance = new Order();
//		}
//		return instance;
//	}
//	②同步代码块（双重检查）
	public static Order getInstance() {
		if (instance == null) {
			synchronized (Order.class) {
				if (instance == null) {
					instance = new Order();
				}
			}
		}
		return instance;
	}

}

//静态内部类创建
class Singleton3 {
//	1.私有化类的构造器，使得外部无法创建对象
	private Singleton3() {

	}

//	2.内部类创建静态对象
	// 外部类的加载不会导致内部类的加载，类加载时是线程安全，延迟加载，效率高
	private static class SingletonInstance {
		private final static Singleton3 INSTANCE = new Singleton3();
	}

//	3.提供公共静态方法，返回类的对象
	public static Singleton3 getInstance() {
		return SingletonInstance.INSTANCE;
	}
}

//枚举创建内部类
enum Singleton4 {
	INSTANCE;

	public void say() {
		System.out.println("--------");
	}
}