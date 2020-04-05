package Factory.FactoryMethod.order;

import Factory.FactoryMethod.pizza.LDCheesePizza;
import Factory.FactoryMethod.pizza.LDPepperPizza;
import Factory.FactoryMethod.pizza.Pizza;

public class LDOrderPizza extends fastoryMethod {

	@Override
	Pizza createPizza(String orderType) {
		// TODO Auto-generated method stub

		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;
	}

}
