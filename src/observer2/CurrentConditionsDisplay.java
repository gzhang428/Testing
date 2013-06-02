package observer2;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer {
	private Observable weatherData;
	private float temp;
	
	
	public CurrentConditionsDisplay(Observable observable){
		this.weatherData = observable;
		observable.addObserver(this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof WeatherData){
			WeatherData weatherData = (WeatherData)arg0;
			temp = weatherData.getTemp();
			
		}
		display();
	}
	private void display() {
		System.out.println(temp);
	}

}
