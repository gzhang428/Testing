package common;
public class ShellSort {
	private static int[] n = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShellSort m = new ShellSort();
		m.shellSort();
		m.print();

	}

	public void shellSort() {
		int j, i, inc;
		int t;
		for (inc = n.length / 2; inc > 0; inc /= 2) {
			for (j = inc; j < n.length; j++) {
				t = n[j];
				for (i = j; i >= inc && t < n[i - inc]; i -= inc) {
					n[i] = n[i - inc];
				}
				n[i] = t;
			}
		}
	}

	public void print() {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}
	}
}
