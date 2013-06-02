package common;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;



public class EliminateDup {

	public EliminateDup() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EliminateDup cr = new EliminateDup();
		System.out.println(cr.rank("aabacddcabe"));
	}

	public String rank(String s) {
		char[] ss = s.toCharArray();
		int tail = 1;
		for (int i = 1; i< ss.length; i++){
			int j;
			//System.out.println("i " +ss[i]);
			for( j = 0; j< tail; j++){
				//System.out.println("j " +ss[j]);
				if(ss[j] == ss[i]){
					break;
				}

				
			}
			if(j == tail){
				//System.out.println("==");
				ss[tail++] = ss[i];
			}
		
		}
	
		return new String(ss, 0, tail);
	}
	
}
