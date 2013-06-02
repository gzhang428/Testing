package common;
import java.util.ArrayList;
import java.util.List;


public class MergeSort {
	private static int[] n = {2,1,5,7,3,8,9,0,4,6};
	private int[] t = new int[10];
	

	public static void main(String[] args){
		MergeSort m=new MergeSort();
		m.mergeSort(0, n.length-1);
		m.print();
		
	}
	
	public void print() {
		for(int i=0 ; i < n.length; i++){
		System.out.print(n[i]);
		}
	}

	public void mergeSort(int low, int high){
		if(low < high){
			int mid = (low+high)/2;
			mergeSort(low, mid);
			mergeSort(mid+1, high);
			merge(low, mid, high);
		}
		
	}

	public void merge(int low, int mid, int high) {
		for(int i = low; i<=high; i++){
			t[i]=n[i];
		}
		
		int i=low;
		int j=mid+1;
		int k=low;
		
		
		while(i <= mid && j <=high){
			if(t[i] <= t[j]){
				n[k]=t[i];
				k++;
				i++;
			}
			else{
				n[k]=t[j];
				k++;
				j++;
			}
		}
		while(i <= mid){
			n[k]=t[i];
			k++;
			i++;
			
		}
		while(j<=high){
			n[k]=t[j];
			k++;
			j++;
		}
	}
}
