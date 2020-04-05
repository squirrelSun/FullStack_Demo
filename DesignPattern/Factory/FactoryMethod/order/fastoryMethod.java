package Factory.FactoryMethod.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Factory.FactoryMethod.pizza.Pizza;

public class fastoryMethod {

	// 定义一个抽象方法，createPizza , 让各个工厂子类自己实现
	Pizza createPizza(String orderType) {
		return null;
	}

	// 构造器
	public fastoryMethod() {
		Pizza pizza = null;
		String orderType; // 订购披萨的类型
		do {
			orderType = getType();
			pizza = createPizza(orderType); //抽象方法，由工厂子类完成
			//输出pizza 制作过程
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
			
		} while (true);
	}

	// 获取客户希望订购的披萨种类
	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza 种类:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
