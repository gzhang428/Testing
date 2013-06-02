package common;

public class UnionFind {

	int[] item;
	int[] weight;
	
	public UnionFind(int n) {
		item = new int[n];
		weight = new int[n];
		
		for(int i = 0; i< n; i++){
			item[i] = -1;
			weight[i] = 1;
		}
	}
	
	int find(int i){
		int j = i;
		while(item[j] >=0){
			j = item[j];
		}
		int root = j;
		
		while(item[i] >= 0){
			j = item[i];
			item[i] = root;
			i = j;
		}
		return root;
	}
	
	public void union(int i, int j){
		i = find(i);
		j = find(j);
		
		if(weight[i] > weight[j]){
			item[j] = i;
			weight[i] +=weight[j];
		}
		else{
			item[i] = j;
			weight[j] += weight[i];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
