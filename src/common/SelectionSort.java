package common;

public class SelectionSort {
	private static int[] n = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SelectionSort m = new SelectionSort();
		m.selectionSort();
		m.print();

	}


	public void print() {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}
	}
	
	public void selectionSort() {
		for(int j=0; j<n.length-1;j++){
			int min=j;
			for(int i=j+1;i<n.length;i++){
				if(n[i]<n[min]){
					min=i;
				}
			}
			swap(j, min);
		}
	}
	public void swap(int i, int j) {
		int t=n[i];
		n[i]=n[j];
		n[j]=t;
		
	}
}
