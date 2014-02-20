package ie.lyit.adt.algorithms.sorting;

/**
 * Selection sort algorithm
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class SelectionSort {
	/**
	 * Sorts an integer array ascending using selection sort
	 * 
	 * @param arrayToSort
	 *            The array to sort
	 */
	public static void selectionSortInt(int[] arrayToSort) {
		for (int j = 0; j < arrayToSort.length - 1; j++) {
			int iMin = j;
			for (int i = j + 1; i < arrayToSort.length; i++) {
				if (arrayToSort[i] < arrayToSort[iMin]) {
					iMin = i;
				}
			}

			if (iMin != j) {
				int temp = arrayToSort[iMin];
				arrayToSort[iMin] = arrayToSort[j];
				arrayToSort[j] = temp;
			}
		}
	}

	/**
	 * Sorts a generic array ascending (elements implementing Comparable<T>
	 * interface) using selection sort
	 * 
	 * @param arrayToSort
	 *            The array to sort
	 */
	public static <T extends Comparable<T>> void selectionSort(T[] arrayToSort) {
		for (int j = 0; j < arrayToSort.length - 1; j++) {
			int iMin = j;
			for (int i = j + 1; i < arrayToSort.length; i++) {
				if (arrayToSort[i].compareTo(arrayToSort[iMin]) < 0) {
					iMin = i;
				}
			}

			if (iMin != j) {
				T temp = arrayToSort[iMin];
				arrayToSort[iMin] = arrayToSort[j];
				arrayToSort[j] = temp;
			}
		}
	}
}
