package googleinterview;

import java.util.ArrayList;
import java.util.Collections;

public class CompareString {

	public CompareString() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompareString cs = new CompareString();
		String s = "abc";
		String t = "ab";
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(s);
		list.add(t);
		
		ArrayList<String> res = cs.compareStr(list);
		System.out.println(res);
	}

	public ArrayList<String> compareStr(ArrayList<String> list) {
		Collections.sort(list, new StringComparator(new StringScoreClass()));
		return list;
	}

}
