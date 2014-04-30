package Algorithm;

public class KaratsubaMultiplication {

	public static void main(String[] args) {
		KaratsubaMultiplication test = new KaratsubaMultiplication();
		int product = test.multiply(1234, 5678);
		System.out.println(product);
	}

	private int multiply(int i, int j) {
		System.out.println(i + "*" + j );
		if (digit(i) == 1 || digit(j) == 1){
			return i * j;
		}
		int n = digit (i);
		System.out.println(n);
		int b = i % (int)Math.pow(10, n/2);
		int a = (i - b) / (int)Math.pow(10,  n/2);
		int d = j % (int) Math.pow(10, n/2);
		int c = (j - d) / (int) Math.pow(10, n/2);
		System.out.println(a + " " + b + " " + c + " " + d);
		int r1 = multiply(a, c);
		int r2 = multiply(b, d);
		int r3 = multiply(a + b,  c + d);
		int r = r1 * (int) Math.pow(10, n) + r2 + (r3 - r2 - r1) * (int)Math.pow(10, n/2);	
		System.out.println(r1 + " " + r2 + " " + r3);
		return r;
	}
	
	private int digit(int n){
		if (n == 0){
			return 1;
		}
		return (int)Math.log10(n) + 1;
	}

}
