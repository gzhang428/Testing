package common;
import java.util.Random;


public class Shuffle {

	/**
	 * @param args
	 */
	public void shuffle(int[] a){
		int t, p;
		Random r = new Random();
		for(int i = 0; i < a.length; i++){
			p = r.nextInt(a.length);
			t = a[p];
			a[p] = a[i];
			a[i] = t;
		}
	}
	
	public static void main(String[] args) {
		Shuffle s = new Shuffle();
		
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		s.shuffle(a);
	
		
		for(int i = 0; i< a.length; i++){
			System.out.println(a[i]);
		}
	}

}
