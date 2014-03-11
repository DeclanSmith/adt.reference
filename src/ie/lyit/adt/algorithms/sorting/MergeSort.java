package ie.lyit.adt.algorithms.sorting;

/**
 * Merge sort algorithm
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class MergeSort {
	/**
	 * Integer array merge sort
	 * 
	 * @param a
	 *            The array to sort
	 */
	public static void mergeSortInt(int[] a) {
		mergeSortInt(a, new int[a.length], 0, a.length - 1);
	}

	/**
	 * Integer array merge sort
	 * 
	 * @param a
	 *            The array to sort
	 * @param b
	 *            A temporary array for merge operation (has to be at least same
	 *            length as a!)
	 * @param left
	 *            The current left boundary (initially 0)
	 * @param right
	 *            The current right boundary (initially a.length - 1)
	 */
	private static void mergeSortInt(int[] a, int[] b, int left, int right) {
		// Implement me!
	}

	/**
	 * Integer array merge function
	 * 
	 * @param a
	 *            The array containing the subArrays to merge
	 * @param b
	 *            The temporary array we are merging into (before copying back
	 *            into a)
	 * @param left
	 *            The left bound of the subArrays (also beginning of left
	 *            subArray)
	 * @param mid
	 *            The mid point between the subArrays
	 * @param right
	 *            The right bound of the subArrays (also end of right subArray)
	 */
	private static void mergeInt(int[] a, int[] b, int left, int mid, int right) {
		// Implement me!
	}
}
