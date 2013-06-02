package observer2;


public class WeatherStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay ccd1 = new CurrentConditionsDisplay(weatherData);
		
		weatherData.setMeasurements(25);
	
		CurrentConditionsDisplay ccd2 = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(26);
	}

}
