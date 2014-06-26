package algorithm;
import java.util.Arrays;


@SuppressWarnings("unchecked")
public class Heap<T extends Comparable<T>> {
	private T[] array;
	private int size;

	public Heap(int capacity) {
		size = 0;
		array = (T[]) new Comparable[capacity + 1];
	}

	public Heap(T[] a) {
		size = a.length;
		array = (T[]) new Comparable[a.length + 1];
		for (int i = 0; i < a.length; i++){
			array[i + 1] = a[i];
		}
		
		for (int i = size / 2; i >= 1; i--) {
			percolateDown(i);
		}

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T findMin() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty heap");
		}
		return array[1];
	}

	public void insert(T x) {
		if (size >= array.length - 1){
			resize();
		}
		size ++;
		array[size] = x;
		percollateUp(size);
	}

	private void resize() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	public T extractMin() throws Exception{
		if (isEmpty()) {
			throw new Exception("Empty heap");
		}
		T min = array[1];
		array[1] = array[size];
		size--;
		percolateDown(1);
		return min;

	}

	public void delete(T t) throws Exception {
		if (isEmpty()){
			throw new Exception("Empty heap");
		}
		int pos = -1;
		for (int i = 1; i < array.length; i++){
			if (array[i].equals(t)){
				pos = i;
				break;
			}
		}
		if (pos == -1){
			throw new Exception("Item not in heap");
		}
		delete(pos);
	}

	public void delete(int pos) throws Exception {
		if (pos < 1 || pos > size){
			throw new Exception("Wrong position");
		}
		array[pos] = array[size];
		size --;
		percollateUp(pos);
		percolateDown(pos);
	}
	
	private void percollateUp(int pos) {
		T t = array[pos];
		for (; pos > 1; pos /= 2) {
			if ( t.compareTo(array[pos / 2]) < 0){
				array[pos] = array[pos / 2];
			} else {
				break;
			}
		}
		array[pos] = t;
	}
	
	private void percolateDown(int pos) {
		T t = array[pos];
		int child;
		for (; pos * 2 <= size; pos = child) {
			child = pos * 2; // pick left child
			if (child != size && array[child + 1].compareTo(array[child]) < 0){
				child++; // if there is right child and right child is smaller, pick right child
			}
			if (t.compareTo(array[child]) > 0){ 
				array[pos] = array[child];
			} else {
				break;
			}
		}
		array[pos] = t;
	}
	
	public static void main(String[] args) throws Exception {
		Integer[] a = {5, 4, 7, 2, 8, 9, 1, 3, 0, 6};
		Heap<Integer> h = new Heap<Integer>(a);
		h.print();
		h.insert(5);
		h.print();
		int m1 = h.extractMin();
		System.out.println(m1);
		h.print();
		h.delete(5);
		h.print();
		h.delete(2);
		h.print();
	}

	public void print() {
		System.out.println("size: " + size + " , array length: " + array.length);
		for (int i = 1; i <= size; i++) {
			System.out.print(i + ": " + array[i] + " ");
		}
		System.out.println();
	}
}
