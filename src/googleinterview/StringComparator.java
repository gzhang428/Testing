package googleinterview;
import java.util.Comparator;


public class StringComparator implements Comparator<String> {

	private StringScore ss;
	
	public StringComparator(StringScore ss){
		this.ss = ss;
	}
	@Override
	public int compare(String o1, String o2) {
		int a = ss.score(o1);
		int b = ss.score(o2);
		
		if(a > b)
			return -1;
		else if(a < b)
			return 1;
		else
			return 0;
					
	}



}
