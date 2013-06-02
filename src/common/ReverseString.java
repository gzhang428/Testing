package common;


public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverse("ab"));
	}

	public String reverse(String s) {
		if(s == null)
			return null;
		if(s.length()< 2)
			return s;
		char[] chars = s.toCharArray();
		
		int last = s.length() - 1;
		int first = 0;
		while(last > first){
			char t = chars[first];
			chars[first] = chars[last];
			chars[last] = t;
			last--;
			first++;
		}
		return new String(chars);
		
	}

}
