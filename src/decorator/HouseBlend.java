package decorator;

public class HouseBlend extends Beverage {

	public HouseBlend(){
		desc = "House Blend";
	}
	@Override
	public double cost() {
		return 0.89;
	}

}
