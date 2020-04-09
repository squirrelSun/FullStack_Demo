package Factory.simpleFactory.order;

//相当于一个客户端，发出订购
public class PizzaStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 使用简单工厂模式
		new OrderPizza(new SimpleFactory());

		new OrderPizza2();
	}

}