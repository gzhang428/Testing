package common;
public class BinarySearch {

	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int pos = binarySearch(1, A);
		System.out.print(pos);
	}

	public static int binarySearch(int x, int[] a) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low+high)/2;
			if(x == a[mid]){
				return mid;
			}
			if(x < a[mid]){
				high=mid-1;
			}
			else{
				low = mid+1;
			}
		}
		return -1;
	}
}
