package common;
import java.util.Collections;

public class Text {

	public Text() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Text t = new Text();
		System.out.println(t.match2("aabbccdd", "bcc"));
	}

	public String match(String s, String t) {
		int n = s.length();
		int m = t.length();

		for (int i = 0; i <= n - m; i++) {
			int j = 0;
			while (j < m && s.charAt(i + j) == t.charAt(j))
				j++;
			if (j == m)
				return s.substring(i, i+j);
		}

		return null;
	}

	public int match2(String s, String t) {
		int[] last = buildLast(t);

		// for (int i: last){
		// System.out.println(i);
		// }
		int n = s.length();
		int m = t.length();
		int i = m - 1;
		int j = m - 1;

		if (i > n - 1)
			return -1;
		do {
			if (s.charAt(i) == t.charAt(j)) {
				if (j == 0)
					return i;
				else {
					i--;
					j--;
				}
			} else {
				i = i + m - Math.min(j, 1 + last[s.charAt(i)]);
				j = m - 1;
				
			}
			System.out.println("i=" + i+" j=" +j);

		} while (i <= n - 1);
		return -1;
	}

	public int[] buildLast(String t) {
		int[] last = new int[128];
		int m = t.length();

		for (int i = 0; i < 128; i++) {
			last[i] = -1;
		}
		for (int j = 0; j < m; j++) {
			last[t.charAt(j)] = j;
		}
		return last;
	}

}
