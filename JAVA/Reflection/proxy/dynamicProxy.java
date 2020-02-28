package JAVA.Reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 动态代理举例
 * */

interface Human{
	
	String getBelief();
	
	void eat(String food);
	
}

//被代理类
class Superman implements Human{

	@Override
	public String getBelief() {
		// TODO Auto-generated method stub
		return "I believe I can fly!";
	}

	@Override
	public void eat(String food) {
		// TODO Auto-generated method stub
		System.out.println("我吃" + food);
	}
	
}

//代理工厂
class ProxyFactory{
	
	//调用此方法，返回一个代理类的对象
	public static Object getProxyInstance(Object obj) {		//obj:被代理类的对象
		MyInvocationHandler handler = new MyInvocationHandler();
		
		handler.bind(obj);
		
		//								被代理类的构造器						被代理类实现的接口					代理方法对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader() , obj.getClass().getInterfaces(), handler);
	}
	
}

class MyInvocationHandler implements InvocationHandler{

	private Object obj;//要被代理类的对象进行赋值
	
	public void bind(Object obj) {
		this.obj = obj;
	}
	
	//当通过代理类对象调用方法时，就会自动的调用invoke()方法
	//将被代理类要执行的方法的功能，声明在invoke()中
	@Override
	//					代理类的对象		代理类对象调用的方法		
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//代理类对象调用的方法，此方法也作为被代理类对象调用的方法
		Object returnval = method.invoke(obj, args);	//obj:被代理类的对象	args:被代理类对象同名方法的参数
		
		//被代理类对象的返回值作为当前类中invoke()的返回值
		return returnval;
	}
	
}


public class dynamicProxy {
	public static void main(String[] args) {
		//创建被代理类对象
		Superman man = new Superman();
		
		//创建代理类对象
		Human proxyInstance1 = (Human) ProxyFactory.getProxyInstance(man);
		
		//通过代理类对象动态调用方法时自动调用被代理类中同名的方法
		String belief = proxyInstance1.getBelief();
		System.out.println(belief);
		proxyInstance1.eat("noodle");
		
		System.out.println("----------------");
		
		ClothFactory cloth = new ClothFactory();
		Factory proxyInstance2 = (Factory) ProxyFactory.getProxyInstance(cloth);
		proxyInstance2.produce();
		
	}
}
