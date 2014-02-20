package ie.lyit.adt.algorithms.sorting;

/**
 * Insertion sort algorithm
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class InsertionSort {
	/**
	 * Sorts an integer array ascending using insertion sort
	 * 
	 * @param arrayToSort
	 *            The array to sort
	 */
	public static void insertionSortInt(int[] arrayToSort) {
		for (int i = 1; i < arrayToSort.length; i++) {
			int j = i;
			while (j > 0 && arrayToSort[j - 1] > arrayToSort[j]) {
				int temp = arrayToSort[j - 1];
				arrayToSort[j - 1] = arrayToSort[j];
				arrayToSort[j] = temp;
				j--;
			}
		}
	}

	/**
	 * Sorts a generic array ascending (elements implementing Comparable<T>
	 * interface) using insertion sort
	 * 
	 * @param arrayToSort
	 *            The array to sort
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] arrayToSort) {
		for (int i = 1; i < arrayToSort.length; i++) {
			int j = i;
			while (j > 0 && arrayToSort[j - 1].compareTo(arrayToSort[j]) > 0) {
				T temp = arrayToSort[j - 1];
				arrayToSort[j - 1] = arrayToSort[j];
				arrayToSort[j] = temp;
				j--;
			}
		}
	}
}
