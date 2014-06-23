package algorithm;
import java.util.LinkedList;
import java.util.List;


public class Queue<T> {
	private List<T> q;
	
	public Queue(){
		q = new LinkedList<T>();
	}
	
	public boolean empty(){
		return q.isEmpty();
	}
	
	public void enqueue(T t){
		q.add(t);
	}
	
	public T dequeue(){
		if(q.isEmpty()){
			return null;
		}
		return q.remove(0);
	}
	public T peek(){
		if(q.isEmpty()){
			return null;
		}
		return q.get(0);
	}
}
