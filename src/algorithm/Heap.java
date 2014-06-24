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

	public T findMin() {
		if (isEmpty()) {
			return null;
		}
		return array[1];
	}

	public void insert(T x) {
		if (size >= array.length - 1){
			resize();
		}
		size ++;
		int pos;
		for (pos = size; pos > 1; pos /= 2) {
			if ( x.compareTo(array[pos / 2]) < 0){
				array[pos] = array[pos / 2];
			} else {
				break;
			}
		}
		array[pos] = x;

	}

	private void resize() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	public T extractMin(){
		if (isEmpty()) {
			return null;
		}
		T min = array[1];
		array[1] = array[size];
		size--;
		percolateDown(1);
		return min;

	}

	public void percolateDown(int pos) {
		T t = array[pos];
		int child;
		for (; pos * 2 <= size; pos = child) {
			child = pos * 2; // pick left child
			if (child != size && array[child + 1].compareTo(array[child]) < 0){
				child++; // if there is right child and right child is smaller, pick right child
			}
			if (array[child].compareTo(t) < 0){ 
				array[pos] = array[child];
			} else {
				break;
			}
		}
		array[pos] = t;
	}

	public static void main(String[] args) throws Exception {
//		int[] a = {5, 4, 7, 2, 8, 9, 1, 3, 0, 6};
//		Heap h = new Heap(a);
//		h.print();
//		h.insert(5);
//		h.print();
//		int m1 = h.extractMin();
//		System.out.println(m1);
//		h.print();
	}

	public void print() {
		System.out.println("size: " + size + " , array length: " + array.length);
		for (int i = 1; i <= size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
