package common;
public class Selection {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Selection s = new Selection();
		int[] array = { 4,2,6};
		int a = s.select(array, 1);
		System.out.println(a);
		int b = s.quickSelect(array, 0, 2, 1);
		System.out.println(b);

	}

	private int quickSelect(int[] array, int i, int j, int k) {

		

		// if there are still elements that need to be examined run
		// partition and quicksort on the half that is relevant
		if (i < j) {

			int p = partition(array, i, j);

			// p is equal to k (kRank) return p
			if (p == k)
				return array[p];

			// else determine which half of the array needs to be sent to
			// quick select recursively
			else {
				if (k < p)
					return (quickSelect(array, i, p - 1, k));
				else
					return (quickSelect(array, p + 1, j, k));
			}
		}

		// else return the kth value
		else
			return array[i];
	}

	public int partition(int[] array, int low, int high) {
		int p = array[low];
		int i = low;
		for (int j = low + 1; j <= high; j++) {
			if (array[j] < p) {
				i++;
				swap(array, i, j);

			}
		}
		swap(array, i, low);
		return i;

	}

	private int select(int[] array, int k) {
		int n = array.length;
		for (int i = 0; i <= k; i++) {
			int min = array[i];
			int index = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < min) {
					min = array[j];
					index = j;
				}
			}
			swap(array, i, index);
		}
		return array[k];
	}

	private void swap(int[] array, int i, int index) {
		int t = array[i];
		array[i] = array[index];
		array[index] = t;
	}

}
