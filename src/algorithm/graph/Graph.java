package algorithm.graph;

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

	public void addEdge(int start, int end) {
		vertice[start].adjacencyList.add(vertice[end]);
		E ++;
	}


	public void removeEdge(int startIndex, int endIndex) {
		List<Vertex> endVertice = vertice[startIndex].adjacencyList;
		for (Vertex v: endVertice){
			if (v.index == endIndex){
				endVertice.remove(v);
			}
		}
		E --;
	}
}
