package decorator;

public abstract class Beverage {
	String desc;
	public String getDesc(){
		return desc;
	}
	public abstract double cost();
}
