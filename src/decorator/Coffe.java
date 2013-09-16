package decorator;

public class Coffe {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDesc());
		System.out.println(beverage.cost());
		
		Beverage b2 = new HouseBlend();
		b2 = new Mocha(b2);
		System.out.println(b2.getDesc());
		System.out.println(b2.cost());
	}

}
