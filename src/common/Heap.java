package common;
import java.util.Collection;

public class Heap {
	private int[] heap;
	private int size;
	private int capacity;

	public Heap(int capacity) {
		this.capacity = capacity;
		size = 0;
		heap = new int[capacity + 1];
	}

	public void buildHeap(Collection<Integer> c) {
		int i = 1;
		for (int x : c) {
			heap[i++] = x;

		}
		size = c.size();

		for (i = size / 2; i >= 1; i--) {
			percolateDown(i);
		}

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int findMin() throws Exception {
		if (isEmpty()) {
			throw new Exception();
		}
		return heap[1];
	}

	public void insert(int x) throws Exception {
		if (size > capacity - 1)
			throw new Exception();
		int hole;
		size ++;
		for (hole = size; hole >= 2 ; hole /= 2) {
			if ( x < heap[hole / 2])
				heap[hole] = heap[hole / 2];

		}
		heap[hole] = x;

	}

	public int deleteMin() throws Exception {
		if (isEmpty())
			throw new Exception();
		int min = heap[1];
		heap[1] = heap[size];
		size--;
		percolateDown(1);
		return min;

	}

	public void percolateDown(int hole) {

		int temp = heap[hole];
		int child = 0;
		for (; hole * 2 <= size; hole = child) {
			child = hole * 2;
			if (child != size && heap[child + 1] < heap[child])
				child++;
			if (heap[child] < temp)
				heap[hole] = heap[child];
			else
				break;
		}
		heap[hole] = temp;
	}

	public static void main(String[] args) {
		Heap h = new Heap(3);
		try {
			h.insert(5);
			h.insert(3);
			h.insert(4);
			// h.deleteMin();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.print();
	}

	public void print() {
		for (int i = 1; i <= size; i++) {
			System.out.println(heap[i]);
		}
	}
}
