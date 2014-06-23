package common;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	//public Set<Node> nodes;
	static Node start;
	Node finish;

	public Graph() {
		Node S = new Node(1, "S");
		Node e = new Node(2, "e");
		Node b = new Node(2, "b");
		Node d = new Node(3, "d");
		Node n = new Node(1, "n");
		Node I = new Node(0, "I");
		Node F = new Node(1, "F");

		start = S;
		finish = F;

		S.neighbors[0] = e;
		e.neighbors[0] = n;
		e.neighbors[1] = d;
		b.neighbors[0] = S;
		b.neighbors[1] = F;
		d.neighbors[0] = b;
		d.neighbors[1] = F;
		d.neighbors[2] = n;
		n.neighbors[0] = I;
		F.neighbors[0] = I;

	}

	public static void main(String[] args) {
		Graph g = new Graph();
		//ArrayList<Node> res=g.DFS2(start);
		
		ArrayList<Node> res = g.BFS(start);
		System.out.println(res);

	}

	public ArrayList<Node>  DFS(Node x) {

		
		HashMap<Node, Node> predecessor =new HashMap<Node, Node>();
		predecessor.put(x, null);
		

		Stack<Node> s = new Stack<Node>();
		x.visited = true;
		s.push(x);
		while (!s.empty()) {
			x = s.pop();
			if (x == finish) {
				ArrayList<Node> answer = new ArrayList<Node>();
				while(x != null){
					answer.add(x);
					x=predecessor.get(x);
				}
				return answer;
			}

			for (Node n : x.neighbors) {
				if (!n.visited) {
					n.visited = true;
					s.push(n);
					predecessor.put(n, x);
				}
			}

		}
		return null;

	}

	public ArrayList<Node> BFS(Node x){
		HashMap<Node, Node> predecessor = new HashMap<Node, Node>();
		predecessor.put(x, null);
		Queue<Node> q = new Queue<Node>();
		
		x.visited = true;
		q.enqueue(x);
		
		while(!q.isEmpty()){
			x = q.dequeue();
			if(x == finish){
				ArrayList<Node> res  = new ArrayList<Node>();
				
				while(x!=null){
					res.add(x);
					x = predecessor.get(x);
					
				}
				return res;
			}
			
			for(Node n: x.neighbors){
				if( !n.visited){
					n.visited = true;
					q.enqueue(n);
					predecessor.put(n, x);
				}
			}
		}
		return null;
		
	}
	
	
	

}
