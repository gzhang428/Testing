package common;
public class Storm8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 2, 2, 3, 0 }, { 0, 3, 1, 1 }, { 1, 2, 2, 1 },
				{ 4, 1, 2, 2 } };
		Storm8 s = new Storm8();
		System.out.println(s.rice_chessboard(a));

	}

	public int rice_chessboard(int[][] a) {

		int max = a[0][0];
		int maxx = 0, maxi = 0, maxj = 0;
		int i = 0, j = 0;

		while (i < a.length) {
			System.out.println(i);
			while (j < a[i].length) {
				System.out.println(j);
				if (i < a.length -1 && j < a[i].length -1) {
					maxx = Math.max(a[i + 1][j], a[i][j + 1]);
					System.out.println(maxx);
					if (maxx == a[i + 1][j]) {
						maxi = i + 1;
						maxj = j;
					} else {
						maxi = i;
						maxj = j + 1;
					}

					
				}
				i = maxi;
				j = maxj;
				max += maxx;
			}

		}
		return max;
	}

}
