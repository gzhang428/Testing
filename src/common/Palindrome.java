package common;
import java.util.ArrayList;

public class Palindrome {

	public Palindrome() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		ArrayList<String> res;
		// res = p.getPalindrome("leel");
		res = p.getPalindrome2("aabaa");
		System.out.println(res);
	}

	public ArrayList<String> getPalindrome2(String s) {

		ArrayList<String> res = new ArrayList<String>();
		for (int i = 1; i < s.length() - 1; i++) {
			System.out.println(s.charAt(i));
			int j = 1;
			while (i - j >= 0 && i + j < s.length()) {
				System.out.println(s.charAt(i - j) + " " + s.charAt(i + j));

				if (s.charAt(i - j) != s.charAt(i + j))
					break;
				else {
					res.add(s.substring(i - j, i + j + 1));
				}
				j++;
			}
		}
		
		for ( int i = 0; i < s.length() - 1; i++){
			int j = 0;
			while(i - j >= 0 && i + j  + 1< s.length() ){
				if(s.charAt(i-j) != s.charAt(i + j + 1))
						break;
				else 
					res.add(s.substring(i-j, i + j));
			}
				
		}
		return res;
	}

	public ArrayList<String> getPalindrome(String s) {
		ArrayList<String> res = new ArrayList<String>();

		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 2; j <= s.length(); j++) {
				String t = s.substring(i, j);
				System.out.println(t);
				if (isPalindrome(t)) {
					System.out.println("true;");
					res.add(t);
				}
			}
		}
		return res;
	}

	public boolean isPalindrome(String t) {
		int start = 0;
		int end = t.length() - 1;

		while (start < end) {
			if (t.charAt(start) != t.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
