package common;
public class TextCompression {

	public TextCompression() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextCompression t = new TextCompression();
		String res = t.compress("AAAABBBCXYZEEEEPPPPPKKABC");
		System.out.println(res);
	}

	public String compress(String a) {
		if (a.length() < 2) {
			return a;
		}
		// if(a.length()==2){if(a.charAt(0)==a.charAt(1)){return
		// a.charAt(0)+"2";}else{return a;}}
		for (int i = 0; i < a.length(); i++) {
			int c = i + 1;
			while (c < a.length() && a.charAt(c) == a.charAt(i)) {
				c++;
			}
			if (c - 1 != i) {
				a = a.substring(0, i + 1) + (c - i) + a.substring(c);
				i++;
			}

		}
		return a;
	}

}
