package algorithm.graph;

import java.util.LinkedList;
import java.util.List;


public class Vertex {
	public int index;
	public List<Vertex> adjacencyList;
	
	public Vertex(int index){
		this.index = index;
		adjacencyList = new LinkedList<Vertex>();
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("index: " + index + ", adjacencyList: ");
		for (Vertex v: adjacencyList){
			sb.append(v.index + " ");
		}
		sb.append("\n");
		return sb.toString();
	}
	
}
