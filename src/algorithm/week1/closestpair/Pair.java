package algorithm.week1.closestpair;

public class Pair {
	public Point start;
	public Point end;
	public double distance;
	
	public String toString(){
		return String.format("start=%s end=%s distance=%f\n", start, end, distance);
	}
}