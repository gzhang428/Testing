package common;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class Intersection {

	public Intersection() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Intersection i = new Intersection();

		int[] a = { 1, 2, 3, 4, 5, 6,8 };
		int[] b = { 2, 3, 5,9,10,11,20,33 };
		ArrayList<Integer> res = i.findIntersection2(a, b);
		System.out.println(res);
	}

	private ArrayList<Integer> findIntersection(int[] a, int[] b) {
		
		Set<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int c: a){
			set.add(c);
		}
		for(int c: b){
			if(set.contains(c))
				res.add(c);
		}
		return res;
	}
	
	public ArrayList<Integer> findIntersection2(int[] a, int[] b){
		int i = 0;
		int j = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		while(i< a.length && j < b.length){
			if(a[i] == b[j]){
				res.add(a[i]);
				i++;
				j++;
			}
			else if(a[i] < b[j]){
				i++;
			}
			else{
				j++;
			}
		}
		
		return res;
		
	}
}
