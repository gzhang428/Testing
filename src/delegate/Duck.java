package delegate;

public abstract class Duck {
	FlyBehavior flyBahevior;
	QuackBehavior quackBehavior;
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void performFly(){
		flyBahevior.fly();
	}
	
	public abstract void display();
	
	public void swim(){
		System.out.println("swim");
	}
	
	public void setFlyBehavior(FlyBehavior fb){
		flyBahevior = fb;
	}
	public void setQuackBehavior(QuackBehavior qb){
		quackBehavior = qb;
	}
}
