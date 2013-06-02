package common;
import java.util.ArrayList;


public class DGraph {
	//public static DNode start;
	public ArrayList<DNode> nodes;
	
	public DGraph(){
		nodes = new ArrayList<DNode>();
		
		DNode a = new DNode("a");
		DNode b = new DNode("b");
		DNode c = new DNode("c");
		DNode d = new DNode("d");
		DNode e = new DNode("e");
		DNode f = new DNode("f");
		DNode g = new DNode("g");
		
		a.neighbors.put(d, 1);
		a.neighbors.put(b, 2);
		b.neighbors.put(d, 3);
		b.neighbors.put(e, 10);
		c.neighbors.put(a, 4);
		c.neighbors.put(f, 5);
		d.neighbors.put(c, 2);
		d.neighbors.put(e, 2);
		d.neighbors.put(f, 8);
		d.neighbors.put(g, 4);
		e.neighbors.put(g, 6);
		g.neighbors.put(f, 1);
		
		//start = a;
		a.dist = 0;

		
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
		DGraph g = new DGraph();
		g.dijkstra();
		System.out.println(g.nodes);
	}
	public void dijkstra() {
		while(true){
			DNode v = unvisitedSmallestDist();
			//System.out.println(v);
			
			if(v == null)
				break;
			
			v.visited = true;
			
			for(DNode w: v.neighbors.keySet()){
				if(!w.visited){
					if(v.dist + v.neighbors.get(w) < w.dist){
						w.dist = v.dist+ v.neighbors.get(w);
						w.path = v;
					}
				}
			}
		}
	}
	public DNode unvisitedSmallestDist() {
		DNode res = null;
		int min = Integer.MAX_VALUE;
		
		for(DNode n: nodes){
			
			if(!n.visited && n.dist < min){
				res = n;
				min = n.dist;
			}
		}
		
		return res;

	}

}
