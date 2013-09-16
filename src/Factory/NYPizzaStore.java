package Factory;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		return new NYStyleCheesePizza();
	}

	
}
