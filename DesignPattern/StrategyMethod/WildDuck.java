package StrategyMethod;

//算法客户实现类
public class WildDuck extends Duck {

	public WildDuck() {
		// TODO Auto-generated constructor stub
		flyBehavior = new GoodFlyBehavior();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("野鸭 ");
	}

}