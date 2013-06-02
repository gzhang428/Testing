package linkedin;

public class Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Number n = new Number();
		System.out.println(n.isNumber("-12345"));
	}

	private boolean isNumber(String string) {
		char[] str = string.toCharArray();
		
		boolean dec = false;
		for(int  i = 0; i < str.length; i++){
			if( str[i] == '-' || str[i] == '+'){
				if( i != 0)
					return false;
			}
			else if(str[i] == '.'){
				if(dec)
					return false;
				else{
					dec = true;
					if (i == str.length - 1)
						return false;
					
				}
			}
			else if(str[i] < '0' || str[i] > '9')
				return false;
		}
		
		
		return true;
	}

}
