package common;
import java.util.ArrayList;


public class Stack<T> {
	private ArrayList<T> s;
	
	public Stack(){
		s=new ArrayList<T>();
	}
	public boolean empty(){
		return s.size()==0;
	}
	public void push(T x){
		s.add(x);
	}
	public T pop(){
		if(empty()){
			System.out.println("Empty Stack");
			
		}
		
		return s.remove(s.size()-1);
	}
	
}
