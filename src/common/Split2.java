package common;
public class Split2 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Split2 s = new Split2();
		int[] a = { 1, 1,2,2,1,2 };
		System.out.print(s.decide(a));
	}

	public boolean decide(int[] a) {
		int[] b = new int[100];
		for (int i = 0; i < a.length; i++) {
			if (b[a[i]] == 0)
				b[a[i]]++;
			else if (b[a[i]] == 1)
				b[a[i]]--;
		}
		int sum = 0;
		for (int i : b) {
			sum += i;
		}
		return sum==0;
	}

}
