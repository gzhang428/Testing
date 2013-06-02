package linkedin;

public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power p = new Power();
		System.out.println(p.pow(2, 9));
	}

	private double pow(double i, int j) { 
		if (j == 0 || i ==1)
			return 1;
		boolean negative = false;
		
		if (j < 0 ){
			negative = true;
			j = -j;
		}
		
		double res = 1;
		
		//////////
		while( j > 0){
			if( j % 2 == 1){
				res *= i;
				j--;
			}
			else{
				i = i*i;
				j /= 2;
			}
		}
		
		
		/////////
		if(negative)
			res = 1/res;
		return res;
	}

}
