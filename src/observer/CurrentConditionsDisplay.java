package observer;



public class CurrentConditionsDisplay implements Observer {
	private float temp;
	private Subject weatherData;
	public CurrentConditionsDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	@Override
	public void update(float temp) {
		this.temp = temp;
		display();
	}
	private void display() {
		System.out.println(temp);
	}
	

}
