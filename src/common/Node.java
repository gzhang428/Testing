package common;
public class Node {

	public Node[] neighbors;
	public Boolean visited;
	public String name;

	public Node(int n, String name) {
		neighbors = new Node[n];
		visited = false;
		this.name=name;
	}
	
	public String toString(){
		return name;
		
	}
}
