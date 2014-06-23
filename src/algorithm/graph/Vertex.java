package algorithm.graph;

import java.util.LinkedList;
import java.util.List;


public class Vertex {
	public int index;
	public boolean visited;
	public int distance;
	public Vertex prev;
	public List<Edge> edges;
	
	public Vertex(int index){
		this.index = index;
		visited = false;
		prev = null;
		distance = Integer.MAX_VALUE;
		edges = new LinkedList<Edge>();
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("index: " + index + ", visited: " + visited+ ", distance: " + distance + ", adjacencyList: ");
		for (Edge e: edges){
			sb.append(e.end.index + " ");
		}
		if (prev != null){
			sb.append("prev: " + prev.index);
		}
		sb.append("\n");
		return sb.toString();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (index != other.index)
			return false;
		return true;
	}
	
}
