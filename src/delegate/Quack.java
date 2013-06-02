package delegate;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack");
	}

}
