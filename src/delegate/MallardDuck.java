package delegate;

public class MallardDuck extends Duck {

	public MallardDuck(){
		quackBehavior = new Quack();
		flyBahevior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("Mallard duck");
	}
	
	

}
