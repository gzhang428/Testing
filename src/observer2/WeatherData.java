package observer2;

import java.util.Observable;

public class WeatherData extends Observable {
	private float temp;
	
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temp){
		this.temp = temp;
		measurementsChanged();
		
	}
	
	public float getTemp(){
		return temp;
	}

	
	
}
