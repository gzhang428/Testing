package algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DijkstraShortestPath {

	public static void main(String[] args) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath();
		Graph g = dijkstraShortestPath.createGraph();
		//Graph g = dijkstraShortestPath.readGraph("dijkstraData.txt");
		System.out.println(g);
		int d = dijkstraShortestPath.findShortedPath(g, 0, 3);
		System.out.println(d);
	}

	private Graph readGraph(String file) {
		Graph g = new Graph(200);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine()) != null){
				String[] str = line.split("\t");
				int start = Integer.parseInt(str[0]) - 1;
				for (int i = 1; i < str.length; i ++){
					String[] endStr = str[i].split(",");
					int end = Integer.parseInt(endStr[0]) - 1;
					int weight = Integer.parseInt(endStr[1]);
					g.addEdge(start, end, weight);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}

	private int findShortedPath(Graph g, int i, int j) {
		List<Vertex> visitedVertice = new ArrayList<Vertex>();
		Vertex startVertex = g.vertice[i];
		startVertex.distance = 0;
		startVertex.visited = true;
		visitedVertice.add(startVertex);
		while (true) {
			int min = Integer.MAX_VALUE;
			Vertex next = null;
			for (Vertex vertex: visitedVertice){
				for (Edge edge: vertex.edges){
					Vertex endVertex = edge.end;
					if (!endVertex.visited){
						if (vertex.distance + edge.weight < min){
							min = vertex.distance + edge.weight;
							next = endVertex;
						}
					}
				}
			}
			
			if (next == null){
				return Integer.MAX_VALUE;
			} else {
				next.distance = min;
				next.visited = true;
				visitedVertice.add(next);
				if (next == g.vertice[j]){
					return next.distance;
				}
			}
		}
	}

	private Graph createGraph() {
		Graph g = new Graph(4);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 4);
		g.addEdge(1, 2, 2);
		g.addEdge(3, 1, 6);
		return g;
	}

}
