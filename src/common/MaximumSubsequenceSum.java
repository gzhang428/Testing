package common;

public class MaximumSubsequenceSum {

	public MaximumSubsequenceSum() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumSubsequenceSum m = new MaximumSubsequenceSum();
		int[] a = {1, -2, -3, 4, 5, 7, -6,9};
		int sum  = m.find2(a);
		System.out.println(sum);
	}
	
	public int find(int[] a) {
		int max = 0;
		for(int i = 0; i < a.length; i++){
			int sum = 0;
			for(int j = i ; j< a.length; j++){
				sum += a[j];
				if( sum > max){
					max = sum;
				}
			}
		}
			
		return max;
	}
	
	public int find2(int[] a){
		int maxSoFar = 0;
		int maxEndingHere = 0;
		for(int i = 0; i< a.length; i++){
			maxEndingHere = Math.max(0, maxEndingHere+a[i]);
			
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

}
