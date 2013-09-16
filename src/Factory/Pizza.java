package Factory;

import java.util.ArrayList;

public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList<String> toppings = new ArrayList<String>();
	public void prepare() {

		System.out.println("Preparing " + name);
		System.out.println("Tossing dough " + dough);
		System.out.println("Adding sauce " + sauce);
		System.out.println("Adding toppings: ");
		for (String topping: toppings){
			System.out.println(" " + topping);
		}
	}

	public void bake() {

		System.out.println("Baking");
	}

	public void cut() {

		System.out.println("Cutting");
	}

	public void box() {

		System.out.println("Boxing");
	}

}
