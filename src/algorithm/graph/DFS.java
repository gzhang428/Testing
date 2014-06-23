package algorithm.graph;

import java.util.List;

import algorithm.Stack;

public class DFS {

	public static void main(String[] args) {
		DFS dfs = new DFS();
		Graph g = dfs.createGraph();
		System.out.println(g);
		dfs.search(g, 1);
		System.out.println(g);
	}
	private void search(Graph g, int start) {
		Stack<Vertex> stack = new Stack<Vertex>();
		Vertex startVertex = g.vertice[start];
		startVertex.visited = true;
		stack.push(startVertex);
		while(!stack.empty()){
			Vertex v = stack.pop();
			List<Edge> edges = v.edges;
			for (Edge edge: edges){
				Vertex vertex = edge.end;
				if (!vertex.visited){
					vertex.visited = true;
					vertex.prev = v;
					stack.push(vertex);
				}
			}
		}
	}
	
	private Graph createGraph() {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(1, 3);
		g.addEdge(3, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 2);
		g.addEdge(2, 4);
		g.addEdge(4, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 5);
		g.addEdge(5, 3);
		g.addEdge(4, 5);
		g.addEdge(5, 4);
		return g;
	}
}
