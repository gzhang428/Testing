package common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph2 {

	public ArrayList<Node> nodes;
	public HashMap<Node, Integer> indegree;
	public static Node s;

	public Graph2() {
		nodes = new ArrayList<Node>();
		indegree = new HashMap<Node, Integer>();

		Node a = new Node(2, "a");
		Node b = new Node(2, "b");
		Node c = new Node(2, "c");
		Node d = new Node(2, "d");
		Node e = new Node(1, "e");
		Node f = new Node(0, "f");
		Node g = new Node(0, "g");

		a.neighbors[0] = e;
		a.neighbors[1] = f;
		b.neighbors[0] = e;
		b.neighbors[1] = g;
		c.neighbors[0] = d;
		c.neighbors[1] = f;
		d.neighbors[0] = f;
		d.neighbors[1] = g;
		e.neighbors[0] = c;
		
		s=a;

		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		nodes.add(e);
		nodes.add(f);
		nodes.add(g);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph2 g = new Graph2();
//		g.getIndgree();
//		System.out.println(g.indegree);
//		HashMap<Node, Integer> res = g.Topsort();
//		System.out.println(res);
		
		g.unweighted(s);

	}

	public void getIndgree() {
		for (int i = 0; i < nodes.size(); i++) {
			indegree.put(nodes.get(i), 0);
		}

		for (int i = 0; i < nodes.size(); i++) {
			Node x = nodes.get(i);
			for (Node n : x.neighbors) {
				indegree.put(n, indegree.get(n) + 1);
			}
		}
	}

	public HashMap<Node, Integer> Topsort() {
		int count = 0;
		Queue<Node> q = new Queue<Node>();
		HashMap<Node, Integer> topNum = new HashMap<Node, Integer>();

		for (Node n : nodes) {
			if (indegree.get(n) == 0) {
				q.enqueue(n);
			}
		}

		while (!q.isEmpty()) {
			Node x = q.dequeue();
			topNum.put(x, ++count);

			for (Node n : x.neighbors) {
				indegree.put(n, indegree.get(n) - 1);
				if (indegree.get(n) == 0) {
					q.enqueue(n);
				}
			}

		}

		// System.out.println(indegree);
		if (count != nodes.size()) {
			System.out.println("Cycle");

		}

		return topNum;

	}

	public void unweighted(Node start) {

		Queue<Node> q = new Queue<Node>();
		HashMap<Node, Integer> dist = new HashMap<Node, Integer>();
		HashMap<Node, Node> path = new HashMap<Node, Node>();

		for(Node n: nodes){
			dist.put(n, Integer.MAX_VALUE);
		}
		dist.put(start, 0);
		start.visited = true;
		q.enqueue(start);

		while (!q.isEmpty()) {
			Node x = q.dequeue();
			
			for (Node n : x.neighbors) {
				if(!n.visited){
					n.visited = true;
					dist.put(n, dist.get(x) +1);
					path.put(n, x);
					q.enqueue(n);
				}
			}
		}
		
		System.out.println(dist);
		System.out.println(path);
	}
}
