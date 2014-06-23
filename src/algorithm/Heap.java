package algorithm;
import java.util.Arrays;

public class Heap {
	private int[] array;
	private int size;

	public Heap(int capacity) {
		size = 0;
		array = new int[capacity + 1];
	}

	public Heap(int[] a) {
		size = a.length;
		array = new int[a.length + 1];
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

	public int findMin() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Heap");
		}
		return array[1];
	}

	public void insert(int x) {
		if (size >= array.length - 1){
			resize();
		}
		size ++;
		int pos;
		for (pos = size; pos > 1; pos /= 2) {
			if ( x < array[pos / 2]){
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

	public int extractMin() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Heap");
		}
		int min = array[1];
		array[1] = array[size];
		size--;
		percolateDown(1);
		return min;

	}

	public void percolateDown(int pos) {
		int t = array[pos];
		int child;
		for (; pos * 2 <= size; pos = child) {
			child = pos * 2; // pick left child
			if (child != size && array[child + 1] < array[child]){
				child++; // if there is right child and right child is smaller, pick right child
			}
			if (array[child] < t){ 
				array[pos] = array[child];
			} else {
				break;
			}
		}
		array[pos] = t;
	}

	public static void main(String[] args) throws Exception {
		int[] a = {5, 4, 7, 2, 8, 9, 1, 3, 0, 6};
		Heap h = new Heap(a);
		h.print();
		h.insert(5);
		h.print();
		int m1 = h.extractMin();
		System.out.println(m1);
		h.print();
	}

	public void print() {
		System.out.println("size: " + size + " , array length: " + array.length);
		for (int i = 1; i <= size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
