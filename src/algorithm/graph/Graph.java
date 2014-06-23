package algorithm.graph;

import java.util.Iterator;
import java.util.List;


public class Graph {
	public int V;
	public int E;
	public Vertex[] vertice;
	
	public Graph(int V){
		this.V = V;
		E = 0;
		vertice = new Vertex[V];
		for (int i = 0; i < V; i++){
			vertice[i] = new Vertex(i);
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("V: " + V + ", E: " + E +"\n");
		for(Vertex v: vertice){
			if (v != null){
				sb.append(v);
			}
		}
		return sb.toString();
	}

	public void addEdge(int start, int end, int weight) {
		vertice[start].edges.add(new Edge(vertice[start], vertice[end], weight));
		E ++;
	}

	public void addEdge(int start, int end) {
		addEdge(start, end, 1);
	}


	public void removeEdge(int startIndex, int endIndex) {
		List<Edge> edges = vertice[startIndex].edges;
		for (Iterator<Edge> it = edges.iterator(); it.hasNext(); ){
			Edge e = it.next();
			if (e.end.index  == endIndex){
				it.remove();
			}
		}
		E --;
	}
}
