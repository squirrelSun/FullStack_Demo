package StrategyMethod;

//实现策略接口
public class NoFlyBehavior implements FlyBehavior {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println(" 不会飞翔  ");
	}

}