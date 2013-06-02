package common;
import java.util.ArrayList;


public class MyHashEntry<T, S> {
	public T key;
	public S value;
	
	public MyHashEntry<T, S> next;
	
	public MyHashEntry(T key, S value){
		this.key = key;
		this.value = value;
	}
	
	
}
