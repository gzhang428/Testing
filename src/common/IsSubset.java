package common;
import java.util.HashSet;
import java.util.Set;

public class IsSubset {

	public IsSubset() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsSubset i = new IsSubset();
		int a[] = { 1, 3,5 };
		int b[] = { 1, 2, 3, 4 };
		boolean c = i.isSubset3(a, b);
		System.out.println(c);
	}

	public boolean isSubset(int[] s, int[] l) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : l) {
			set.add(i);
		}
		for (int j : s) {
			if (!set.contains(j))
				return false;
		}

		return true;
	}

	public boolean isSubset2(int[] s, int[] l) {
		int i = 0;
		int j = 0;

		for (i = 0; i < s.length; i++) {
			for (j = 0; j < l.length; j++) {
				if (s[i] == l[j])
					break;

			}
			if ( j == l.length)
				return false;

		}
		return true;
	}

	public boolean isSubset3(int[] s, int[] l) {
		int i = 0;
		int j = 0;

		while (i < s.length && j < l.length) {
			if (s[i] == l[j]) {
				i++;
				j++;
			} else if (l[j] < s[i])
				j++;
			else
				return false;

		}
		if (i < s.length)
			return false;
		else
			return true;
	}
}
