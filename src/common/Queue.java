package common;
import java.util.LinkedList;


public class Queue<T> {
	private LinkedList<T> q;
	
	public Queue(){
		q = new LinkedList<T>();
	}
	
	public boolean isEmpty(){
		return q.size() == 0;
	}
	
	public void enqueue(T t){
		q.add(t);
	}
	
	public T dequeue(){
		if(isEmpty()){
			System.out.println("empty");
		}
		return q.remove();
	}
}
