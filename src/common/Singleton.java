package common;
import java.util.HashMap;
import java.util.Map;


public class Singleton {
	private Singleton instance;
	private Singleton(){
		
	}
	public Singleton getInstance(){
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
		
		
	}
}
