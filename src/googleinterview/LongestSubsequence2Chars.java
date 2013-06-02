package googleinterview;
public class LongestSubsequence2Chars {
	public int find(String s){
			
		int[] c = {0,0};
		char[] a = {'&', '&'};
		char[] b = {'^', '^'};
		int[] max = {0, 0};
		
		int p = 0; 
		
		for(int i=0; i<s.length(); i++){
			
			if(c[1] == 0){
			
				a[1] = s.charAt(i);
				max[1] = 1;
				c[1] = 1;
				p = 1;
				
			}else if(c[1] == 1){
				if(s.charAt(i) == a[1]){
					max[1] += 1;
					p++;					
				}else{
					max[1] += 1;
					b[1] = s.charAt(i);
					c[1] += 1;
					p=1;
				}			
				
			}else if(c[1] == 2){
				
				if(s.charAt(i) == a[1] || s.charAt(i) == b[1]){
					max[1] += 1;
					if(s.charAt(i) == s.charAt(i-1)){
						p++;
					}else{
						p=1;
					}
					
				}else{
					a[1] = s.charAt(i-1);
					b[1] = s.charAt(i);
					
					max[1] = p + 1;
					p = 1;
					
					
				}
				
			}
			
			
			if(max[1] > max[0]){
				max[0] = max[1];
				a[0] = a[1];
				b[0] = b[1];
			}
			
			
			
		}
		
		return max[0];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubsequence2Chars s = new LongestSubsequence2Chars();
		String t = "abbbcc";
		System.out.println(s.find(t));

	}

}
