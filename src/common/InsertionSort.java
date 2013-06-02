package common;

public class InsertionSort {
	private static int[] n = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertionSort m = new InsertionSort();
		m.insertionSort();
		m.print();

	}


	public void insertionSort() {
		for (int j=1; j < n.length; j++){
			int t=n[j];
			int i;
			for ( i=j; i >= 1 && n[i-1]>t; i--){
				n[i]=n[i-1];
			}
			n[i]=t;
		}
	}


	public void print() {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}
	}
}
