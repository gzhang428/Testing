package common;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Anagram {
	public static void main(String[] args){
		String t="abcd";
		String s="cdab";
		boolean b = anagram(s, t);
		System.out.print(b);
		
		
	}

	public static boolean anagram(String s, String t) {
		if(s.length()!= t.length())
			return false;
		
		return sort(s).equals(sort(t));
		
	}

	public static String sort(String s) {
		char[] sc = s.toCharArray();
		Arrays.sort(sc);
		return new String(sc);
	}

}
