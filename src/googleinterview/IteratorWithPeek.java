package googleinterview;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorWithPeek<T> implements Iterator<T> {
	Iterator<T> iter;
	boolean nextCalled;
	T obj;
	
	public IteratorWithPeek(Iterator<T> iter) {
		this.iter = iter;
		nextCalled = false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		IteratorWithPeek<Integer> iter = new IteratorWithPeek<Integer>(list.iterator());
		
	
		System.out.println(iter.peek());
		System.out.println(iter.next());
		System.out.println(iter.peek());
		System.out.println(iter.peek());
		System.out.println(iter.next());
		System.out.println(iter.next());
		//System.out.println(iter.peek());
		System.out.println(iter.hasNext());
	
		
	}

	@Override
	public boolean hasNext() {
		if(nextCalled){
			return true;
		}
		else{
			return iter.hasNext();
		}
		
	}

	@Override
	public T next() {
		if(nextCalled){
			nextCalled = false;
			return obj;
		}
		else{
			return iter.next();
		}
	}

	@Override
	public void remove() {
		iter.remove();
	}
	
	public T peek(){
		if(!nextCalled){
			obj = iter.next();
			nextCalled = true;
			return obj;
		}
		else{
			return obj;
		}
	}

	

}
