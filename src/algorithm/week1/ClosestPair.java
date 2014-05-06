package algorithm.week1;

import java.util.ArrayList;
import java.util.List;

public class ClosestPair {

	public class Point {
	
	}


	public static void main(String[] args) {
		double[][] points = {{1, 1}, 
				          {1, 3}, 
				          {2, 3}, 
				          {4, 2}};
		
		ClosestPair closestPair = new ClosestPair();
		int[] pair = closestPair.bruteForceFind(points);
		System.out.println(pair[0] + " " + pair[1]);
		
		
		//List<Point> points = new ArrayList<Point>();
	}

	public int[] bruteForceFind(double[][] points) {
		int[] pair = new int[2];
		int n = points.length;
		double min = Double.MAX_VALUE;
		for (int i = 0; i < n; i++){
			double[] a = points[i];
			for (int j = i + 1; j < n; j++){
				double[] b = points[j];
				double d = distance(a, b);
				if (d < min){
					min = d;
					pair[0] = i;
					pair[1] = j;
				}
			}
		}
		return pair;
	}

	
	private double distance(double[] a, double[] b) {
		int dimension = a.length;
		double distance = 0;
		for (int i = 0; i < dimension; i++){
			distance += (a[i] - b[i]) * (a[i] - b[i]);
		}
		return Math.sqrt(distance);
	}

}
