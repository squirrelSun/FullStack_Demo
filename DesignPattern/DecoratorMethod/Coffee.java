package DecoratorMethod;

//主体缓冲实现类
public class Coffee extends Drink {

	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return super.getPrice();
	}

}