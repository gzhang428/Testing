package common;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Subset {

	public Subset(){
		
	}
	
	ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index){
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else{
			allsubsets = getSubset(set, index+1);
			int item = set.get(index);
			//System.out.println("item="+item);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset: allsubsets)
			{	
//				System.out.println("================subset==================");
//				System.out.println(subset);
//				
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				
				//System.out.println(newsubset);
				moresubsets.add(newsubset);
				//System.out.println("================end subset==================");
			}
			allsubsets.addAll(moresubsets);
		}
		
		return allsubsets;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subset s = new Subset();
		//int [] a = {1,2,3,4};
		ArrayList<Integer> set = new ArrayList<Integer>();

		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		System.out.println(s.getSubset(set, 0));
		
	}

}
