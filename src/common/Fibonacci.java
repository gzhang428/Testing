package common;
import java.util.ArrayList;


public class Fibonacci {
	int[] fib = new int[100];
	public static void main(String[] args){
		Fibonacci f = new Fibonacci();
		f.run(10);
	}

	public void run(int n) {
		fib[0] = 0;
		fib[1] = 1;
		int i = 2;
		while(i < n){
			fib[i] = fib[i - 1] + fib[i - 2];
			i++;
		}
		for(int j  = 0; j< n; j++){
			System.out.println(fib[j]);
		}
	}
}
