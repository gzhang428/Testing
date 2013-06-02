package common;
import java.util.HashMap;


public class DNode {
	public Boolean visited;
	public String name;
	public HashMap<DNode, Integer> neighbors;
	public int dist;
	public DNode path;
	
	public DNode(String name){
		neighbors = new HashMap<DNode, Integer>();
		visited = false;
		this.name=name;
		dist = Integer.MAX_VALUE;
		path = null;
		
	}
	

	public String toString(){
		return name + ":" + dist;
		
	}
}
