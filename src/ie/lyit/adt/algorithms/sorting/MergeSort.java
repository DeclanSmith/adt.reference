package ie.lyit.adt.algorithms.sorting;

import java.lang.reflect.Array;

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
		// BASE CASE: Array of length 1
		if (left < right) {
			// Split into two equal subArrays
			int mid = left + (right - left) / 2;

			// (Sort)/Split the two halves recursively
			mergeSortInt(a, b, left, mid);
			mergeSortInt(a, b, mid + 1, right);

			// Merge the two halves back together (in correct sorted sequence)
			mergeInt(a, b, left, mid + 1, right);
		}
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
		int leftEnd = mid - 1;
		int tmpPos = left;
		int numElements = right - left + 1;

		// While both halves are non-empty
		while ((left <= leftEnd) && (mid <= right)) {
			if (a[left] <= a[mid]) {
				b[tmpPos++] = a[left++];
			} else {
				b[tmpPos++] = a[mid++];
			}
		}

		// If the left half is not empty yet
		while (left <= leftEnd) {
			b[tmpPos++] = a[left++];
		}

		// Or, if the right half is not empty yet
		while (mid <= right) {
			b[tmpPos++] = a[mid++];
		}

		// Move merged elements in B back into A
		for (int i = 0; i < numElements; i++) {
			a[right] = b[right--];
		}
	}

	/**
	 * Merge sort
	 * 
	 * @param a
	 *            The array to sort
	 * @param arrayType
	 *            The data type of the array elements
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void mergeSort(T[] a,
			Class<T> arrayType) {
		mergeSort(a, (T[]) Array.newInstance(arrayType, a.length), 0,
				a.length - 1);
	}

	/**
	 * Merge sort
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
	private static <T extends Comparable<T>> void mergeSort(T[] a, T[] b,
			int left, int right) {
		// BASE CASE: Array of length 1
		if (left < right) {
			// Split into two equal subArrays
			int mid = left + (right - left) / 2;

			// (Sort)/Split the two halves recursively
			mergeSort(a, b, left, mid);
			mergeSort(a, b, mid + 1, right);

			// Merge the two halves back together (in correct sorted sequence)
			merge(a, b, left, mid + 1, right);
		}
	}

	/**
	 * Comparable array merge function
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
	private static <T extends Comparable<T>> void merge(T[] a, T[] b, int left,
			int mid, int right) {
		int leftEnd = mid - 1;
		int tmpPos = left;
		int numElements = right - left + 1;

		// While both halves are non-empty
		while ((left <= leftEnd) && (mid <= right)) {
			if (a[left].compareTo(a[mid]) < 1) {
				b[tmpPos++] = a[left++];
			} else {
				b[tmpPos++] = a[mid++];
			}
		}

		// If the left half is not empty yet
		while (left <= leftEnd) {
			b[tmpPos++] = a[left++];
		}

		// Or, if the right half is not empty yet
		while (mid <= right) {
			b[tmpPos++] = a[mid++];
		}

		// Move merged elements in B back into A
		for (int i = 0; i < numElements; i++) {
			a[right] = b[right--];
		}
	}
}
