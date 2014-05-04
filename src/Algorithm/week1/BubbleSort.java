package Algorithm.week1;
public class BubbleSort {

	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(a);

	}

	public void sort(int[] a) {
		int j=0;
		boolean swapped=true;
		while(swapped){
			j++;
			swapped=false;
			for(int i=0; i<a.length-j;i++){
				if(a[i]>a[i+1]){
					swap(i, i + 1, a);
					swapped=true;
				}
			}
			print(a);
		}
	}

	
	public void sort2(int[] a){
		
	}
	private void swap(int n, int m, int[] a) {
		int t = a[n];
		a[n] = a[m];
		a[m] = t;
	}

	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	
}
