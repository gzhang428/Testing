package common;
public class Rotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3, 4}, { 5, 6, 7,8 }, {  9, 10,11, 12 }, {13,14,15,16} };

		rotate(m, 4);

	}

	public static void rotate(int[][] m, int n) {

		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i=first; i <last; i++){
				int offset = i - first;
				int top = m[first][i];
				m[first][i]= m[last-offset][first];
				m[last-offset][first] = m[last][last-offset];
				m[last][last-offset] = m[i][last];
				m[i][last] =top;
			}
		}
	}
}
