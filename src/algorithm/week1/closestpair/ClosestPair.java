package algorithm.week1.closestpair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPair {

	public static void main(String[] args) {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 1));
		points.add(new Point(1, 3));
		points.add(new Point(2, 3));
		points.add(new Point(4, 2));
		ClosestPair closestPair = new ClosestPair();
		Pair pair = closestPair.bruteForceFind(points);
		pair = closestPair.divideAndConqueFind(points);
	}

	private Pair divideAndConqueFind(List<Point> points) {
		Pair pair = new Pair();
		List<Point> xSortedPoints = new ArrayList<Point>(points);
		Collections.sort(xSortedPoints, new PointComparator("x"));
		List<Point> ySortedPoints = new ArrayList<Point>(points);
		Collections.sort(ySortedPoints, new PointComparator("y"));
		return pair;
	}

	public Pair bruteForceFind(List<Point> points) {
		double min = Double.MAX_VALUE;
		Pair pair = new Pair();
		for (int i = 0; i < points.size() - 1; i++){
			Point start = points.get(i);
			for (int j = i + 1; j < points.size(); j++ ){
				Point end = points.get(j);
				double distance = getDistance(start, end);
				if (distance < min){
					min = distance;
					pair.start = start;
					pair.end = end;
					pair.distance = distance;
				}
			}
		}
		return pair;
	}

	
	private double getDistance(Point start, Point end) {
		return Math.sqrt((start.x - end.x) * (start.x - end.x) + (start.y - end.y) * (start.y - end.y));
	}
}
