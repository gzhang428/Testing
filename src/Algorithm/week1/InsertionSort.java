package Algorithm.week1;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(a);

	}


	public void sort(int[] a) {
		for (int j=1; j < a.length; j++){
			int t=a[j];
			int i;
			for ( i=j; i >= 1 && a[i-1]>t; i--){
				a[i]=a[i-1];
			}
			a[i]=t;
		}
	}


	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
}
