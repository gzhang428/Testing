package common;
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.compute2(4));

	}

	public int compute(int x) {
		int f = 1;
		for (int i = x; i >= 1; i--) {
			f *= i;
		}
		return f;
	}

	public int compute2(int x) {
		if (x == 0)
			return 1;
		return x * compute2(x - 1);

	}
}
