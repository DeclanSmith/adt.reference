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
		// Implement me!
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
		return -1; // Remove this, and implement
	}
}
