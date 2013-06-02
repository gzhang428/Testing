package common;

public class QuickSort {
	private static int[] n = {2,1,5,7,3,8,9,0,4,6};
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		QuickSort m=new QuickSort();
		m.quickSort(0, n.length-1);
		m.print();
		
	}
	
	public void print() {
		for(int i=0 ; i < n.length; i++){
		System.out.print(n[i]);
		}
	}
	
	public void quickSort(int low, int high){
		if(low < high){
			int i=partition(low, high);
			quickSort(low, i-1);
			quickSort(i+1,high);
		}
		
	}

	public int partition(int low, int high) {
		int p=n[low];
		int i=low;
		for(int j=low+1; j<=high; j++){
			if(n[j]<p){
				i++;
				swap(i,j);
				
			}
		}
		swap(i,low);
		return i;

	}

	public void swap(int i, int j) {
		int t=n[i];
		n[i]=n[j];
		n[j]=t;
		
	}
}
