package ie.lyit.adt.algorithms.sorting;

/**
 * Quick sort algorithm
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class QuickSort {
	/**
	 * Integer array quick sort
	 * 
	 * @param a
	 *            The array to sort
	 */
	public static void quickSortInt(int[] a) {
		quickSortInt(a, 0, a.length - 1);
	}

	/**
	 * Integer array quick sort
	 * 
	 * @param a
	 *            The array to sort
	 * @param p
	 *            The current left boundary (initially 0)
	 * @param r
	 *            The current right boundary (initially a.length - 1)
	 */
	private static void quickSortInt(int[] a, int p, int r) {
		// BASE CASE: Array of length 1
		if (p < r) {
			// Partition the array into two subArrays (left and right of the
			// pivot element)
			int q = partitionInt(a, p, r);

			// Recursively sort the left and right subArrays using quick sort
			quickSortInt(a, p, q - 1);
			quickSortInt(a, q + 1, r);
		}
	}

	/**
	 * Integer array partition function
	 * 
	 * @param a
	 *            The array we are sorting
	 * @param p
	 *            The current left boundary
	 * @param r
	 *            The current right boundary
	 * @return The index of the chosen pivot element x in array a
	 */
	private static int partitionInt(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for (int j = p; j <= (r - 1); j++) {
			// Compare elements against the pivot to decide in which of the
			// subArrays to place them
			if (a[j] <= x) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		int temp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = temp;
		return i + 1;
	}

	/**
	 * Quick sort
	 * 
	 * @param a
	 *            The array to sort
	 */
	public static <T extends Comparable<T>> void quickSort(T[] a) {
		quickSort(a, 0, a.length - 1);
	}

	/**
	 * Quick sort
	 * 
	 * @param a
	 *            The array to sort
	 * @param p
	 *            The current left boundary (initially 0)
	 * @param r
	 *            The current right boundary (initially a.length - 1)
	 */
	private static <T extends Comparable<T>> void quickSort(T[] a, int p, int r) {
		// BASE CASE: Array of length 1
		if (p < r) {
			// Partition the array into two subArrays (left and right of the
			// pivot element)
			int q = partition(a, p, r);

			// Recursively sort the left and right subArrays using quick sort
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	/**
	 * Comparable array partition function
	 * 
	 * @param a
	 *            The array we are sorting
	 * @param p
	 *            The current left boundary
	 * @param r
	 *            The current right boundary
	 * @return The index of the chosen pivot element x in array a
	 */
	private static <T extends Comparable<T>> int partition(T[] a, int p, int r) {
		T x = a[r];
		int i = p - 1;
		for (int j = p; j <= (r - 1); j++) {
			// Compare elements against the pivot to decide in which of the
			// subArrays to place them
			if (a[j].compareTo(x) < 1) {
				i++;
				T temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		T temp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = temp;
		return i + 1;
	}
}
