package DecoratorMethod;

//具体的装饰实现类
public class Soy extends Decorator {

	public Soy(Drink obj) {
		super(obj);
		// TODO Auto-generated constructor stub
		setDes(" 豆浆  ");
		setPrice(1.5f);
	}

}