package common;
public class Bracket {

	public Bracket() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bracket b = new Bracket();
		b.print(4);
	}

	public void print(int n) {
		if (n > 0) {
			printBracket(n, 0, 0,"");
		}
	}

	public void printBracket(int n, int open, int close, String s) {
		if (open == n && close == n) {
			System.out.println(s);
		} else {
			if (open < n) {
				printBracket(n, open + 1, close, s+"(");
			}
			if (open > close) {
				printBracket(n, open, close + 1, s+")");
			}
			

		}
	}

}
