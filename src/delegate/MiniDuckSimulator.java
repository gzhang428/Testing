package delegate;

public class MiniDuckSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.performFly();
		mallard.performQuack();
		
		mallard.setQuackBehavior(new Squeak());
		mallard.performQuack();
	}

}
