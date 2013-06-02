package common;

public class MyHashMap<T, S> {

	private int size;
	private MyHashEntry<T, S>[] table;
	
	public MyHashMap(int size){
		this.size = size;
		table = new MyHashEntry[size];
	}
	
	public void put(T key, S value){
		int hash = key.hashCode() % size;
		
		if(table[hash] == null){
			table[hash] = new MyHashEntry<T, S>(key, value);
		}
		else {
			MyHashEntry<T, S> entry = table[hash];
			while(entry.next!=null && entry.key != key){
				entry = entry.next;
			}
			if(entry.key == key){
				entry.value = value;
			}
			else{
				entry.next = new MyHashEntry<T, S>(key, value);
			}
			
		}
	}
	
	public S get(T key){
		
		int hash = key.hashCode() % size;
		
		if(table[hash] == null){
			return null;
		}
		else{
			MyHashEntry<T, S> entry = table[hash];
			while(entry != null && entry.key != key){
				entry = entry.next;
			}
			if(entry.key == key){
				return entry.value;
			}
			else{
				return null;
			}
		}
		
		
	}
	
	public void remove(T key){
		int hash = key.hashCode() % size;
		
		if(table[hash] != null){
			
			if(table[hash].key == key){
				table[hash] = table[hash].next;
				return;
			}
			
			MyHashEntry<T, S> prev = table[hash];
			while(prev.next != null && prev.next.key != key){
				prev = prev.next;
			}
			
			if(prev.next != null){
				prev.next = prev.next.next;
			}
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
