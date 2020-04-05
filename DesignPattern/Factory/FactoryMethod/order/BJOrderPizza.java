package Factory.FactoryMethod.order;

import Factory.FactoryMethod.pizza.BJCheesePizza;
import Factory.FactoryMethod.pizza.BJPepperPizza;
import Factory.FactoryMethod.pizza.Pizza;

public class BJOrderPizza extends fastoryMethod {

	@Override
	Pizza createPizza(String orderType) {
		// TODO Auto-generated method stub

		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new BJPepperPizza();
		}
		return pizza;
	}

}