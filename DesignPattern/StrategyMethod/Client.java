package StrategyMethod;

public class Client {

	public static void main(String[] args) {
		WildDuck wildDuck = new WildDuck();
		wildDuck.fly();

		ToyDuck toyDuck = new ToyDuck();
		toyDuck.fly();

		PekingDuck pekingDuck = new PekingDuck();
		pekingDuck.fly();

		// 动态改变某个对象的行为
		pekingDuck.setFlyBehavior(new NoFlyBehavior());
		System.out.println("北京鸭的实际飞翔能力");
		pekingDuck.fly();
	}

}
