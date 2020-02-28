package JAVA.Reflection.proxy;

/*
 * 静态代理举例
 * 
 * 代理类与被代理类在编译期间明确指定
 * */

interface Factory{
	
	void produce();
	
}

//代理类
class ProxyFactory1 implements Factory{

	private Factory factory;//用被代理类对象进行实例化
	
	public ProxyFactory1(Factory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void produce() {
		// TODO Auto-generated method stub
		System.out.println("代理工厂准备工作 ");
		
		factory.produce();
		
		System.out.println("代理工厂收尾工作");
	}
	
}

//被代理类
class ClothFactory implements Factory{

	@Override
	public void produce() {
		// TODO Auto-generated method stub
		System.out.println("服装厂工作");
	}
	
}


public class staticProxy {

	public static void main(String[] args) {
		//创建被代理类对象
		ClothFactory cloth = new ClothFactory();
		//创建代理类对象
		ProxyFactory1 proxy = new ProxyFactory1(cloth);
		
		proxy.produce();
	}
	
}
