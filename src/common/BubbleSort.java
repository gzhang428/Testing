package common;
public class BubbleSort {
	private static int[] n = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BubbleSort m = new BubbleSort();
		m.bubbleSort();
		m.print();

	}

	public void bubbleSort() {
		boolean swap=true;
		int t;
		int j=0;
		while(swap){
			swap=false;
			j++;
			for(int i=0; i<n.length-j;i++){
				if(n[i]>n[i+1]){
					t=n[i];
					n[i]=n[i+1];
					n[i+1]=t;
					swap=true;
				}
				
			}
		}
	}

	public void print() {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}
	}
	
	
}
