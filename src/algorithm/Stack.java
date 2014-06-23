package algorithm;
import java.util.ArrayList;
import java.util.List;


public class Stack<T> {
	private List<T> s;
	
	public Stack(){
		s = new ArrayList<T>();
	}
	public boolean empty(){
		return s.isEmpty();
	}
	public void push(T x){
		s.add(x);
	}
	public T pop(){
		if(s.isEmpty()){
			return null;
		}
		return s.remove(s.size() - 1);
	}
	public T peek(){
		if(s.isEmpty()){
			return null;
		}
		return s.get(s.size() - 1);
	}
	
}
