package ie.lyit.adt.algorithms.sorting;

/**
 * Bubble sort algorithm
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class BubbleSort {
	/**
	 * Sorts an integer array ascending using bubble sort
	 * 
	 * @param arrayToSort
	 *            The array to sort
	 */
	public static void bubbleSortInt(int[] arrayToSort) {
		boolean swapped;
		int round = 0;
		do {
			swapped = false;
			for (int i = 1; i < arrayToSort.length - round; i++) {
				if (arrayToSort[i - 1] > arrayToSort[i]) {
					int temp = arrayToSort[i - 1];
					arrayToSort[i - 1] = arrayToSort[i];
					arrayToSort[i] = temp;
					swapped = true;
				}
			}
			
			round++;
		} while (swapped);
	}

	/**
	 * Sorts a generic array ascending (elements implementing Comparable<T>
	 * interface) using bubble sort
	 * 
	 * @param arrayToSort
	 *            The array to sort
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] arrayToSort) {
		boolean swapped;
		int round = 0;
		do {
			swapped = false;
			for (int i = 1; i < arrayToSort.length - round; i++) {
				if (arrayToSort[i - 1].compareTo(arrayToSort[i]) > 0) {
					T temp = arrayToSort[i - 1];
					arrayToSort[i - 1] = arrayToSort[i];
					arrayToSort[i] = temp;
					swapped = true;
				}
			}
			
			round++;
		} while (swapped);
	}
}
