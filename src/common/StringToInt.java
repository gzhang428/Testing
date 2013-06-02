package common;

public class StringToInt {

	/**
	 * @param args
	 */
	
	public int convert(String s){
		char[] cs = s.toCharArray();
		int num=0;
		for (int i = cs.length - 1; i >= 0; i--){
			char c = cs[i];
			int n = c - '0';
			num+=n*Math.pow(10, (cs.length-1-i));
		}
		
		return num;
	}
	
	public int conv(String s){
		char[] cs = s.toCharArray();
		int num = 0;
		for(int i = 0; i < cs.length; i++){
			num*=10;
			num+=cs[i]-'0';
		}
		return num;
	}
	public static void main(String[] args) {
		StringToInt s = new StringToInt();
		System.out.println(s.conv("1234"));
	}

}
