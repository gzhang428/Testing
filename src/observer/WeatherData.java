package observer;

import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temp;
	
	public WeatherData(){
		observers = new ArrayList<Observer>();
	}
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0){
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer o: observers){
			o.update(temp);
		}
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}
	public void setMeasurements(float temp){
		this.temp = temp;
		measurementsChanged();
	}
}
