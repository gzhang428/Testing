package algorithm.week1.closestpair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClosestPair {

	public static void main(String[] args) {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 1));
		points.add(new Point(1, 3));
		points.add(new Point(2, 3));
		points.add(new Point(4, 2));
		ClosestPair closestPair = new ClosestPair();
		Pair pair = closestPair.bruteForce(points);
		System.out.println(pair);
		pair = closestPair.divideAndConque(points);
	}

	private Pair divideAndConque(List<Point> points) {
		List<Point> xSortedPoints = new ArrayList<Point>(points);
		Collections.sort(xSortedPoints, new PointComparator("x"));
		List<Point> ySortedPoints = new ArrayList<Point>(points);
		Collections.sort(ySortedPoints, new PointComparator("y"));
		
		return findClosestPair(xSortedPoints, ySortedPoints);
	}

	private Pair findClosestPair(List<Point> xSortedPoints, List<Point> ySortedPoints) {
		if (xSortedPoints.size() == 1){
			Pair pair = new Pair(null, null);
			pair.updateDistance();
			return pair;
		} else if (xSortedPoints.size() == 2){
			Pair pair = new Pair( xSortedPoints.get(0),  xSortedPoints.get(1));
			pair.updateDistance();
			return pair;
		} else {
			int mid = xSortedPoints.size() / 2;
			List<Point> xSortedLeft = xSortedPoints.subList(0, mid);
			List<Point> xSortedRight = xSortedPoints.subList(mid, xSortedPoints.size());
			List<Point> ySortedLeft = getYSortedHalf(ySortedPoints, xSortedLeft);
			List<Point> ySortedRight = getYSortedHalf(ySortedPoints, xSortedRight);
			double xCenter = (xSortedLeft.get(xSortedLeft.size() - 1).x + xSortedRight.get(0).x) / 2;
			
			Pair left = findClosestPair(xSortedLeft, ySortedLeft);
			Pair right = findClosestPair(xSortedRight, ySortedRight);
			
			double delta = Math.min(left.distance, right.distance);
			Pair split = findSplitClosestPair(xSortedLeft, ySortedLeft, xSortedRight, ySortedRight, xCenter, delta);
			
		}
		
		return null;
	}

	private List<Point> getYSortedHalf(List<Point> ySortedPoints, List<Point> xSortedLeft) {
		List<Point> res = new ArrayList<Point>();
		Set<Point> xHalfSet = new HashSet<Point>(xSortedLeft);
		for (Point p: ySortedPoints){
			if (xHalfSet.contains(p)){
				res.add(p);
			}
		}
		return res;
	}

	private Pair findSplitClosestPair(List<Point> xSortedLeft, List<Point> ySortedLeft, 
			List<Point> xSortedRight, List<Point> ySortedRight, double xCenter, double delta) {
		for (int i = xSortedLeft.size() - 1; i >= 0; i--){
			Point p = xSortedLeft.get(i);
			if (p.x > xCenter - delta){
				
			}
		}
		
		for (int i = 0; i < xSortedRight.size(); i++){
			Point p = xSortedRight.get(i);
			if (p.x < xCenter + delta){
				
			}
		}
		
		
		return null;
	}


	public Pair bruteForce(List<Point> points) {
		double min = Double.MAX_VALUE;
		Pair pair = null;
		for (int i = 0; i < points.size() - 1; i++){
			Point start = points.get(i);
			for (int j = i + 1; j < points.size(); j++ ){
				Point end = points.get(j);
				double distance = getDistance(start, end);
				if (distance < min){
					min = distance;
					pair= new Pair(start, end);
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
