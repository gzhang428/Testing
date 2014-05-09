package algorithm.week1.sort;

public abstract class Sort {
	public abstract void sort(int[] a);
	protected void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	protected void swap(int[] a, int n, int m ) {
		int t = a[n];
		a[n] = a[m];
		a[m] = t;
	}
}
