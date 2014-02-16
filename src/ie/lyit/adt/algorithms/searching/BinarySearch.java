package ie.lyit.adt.algorithms.searching;

/**
 * Binary search algorithm
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class BinarySearch {
	/**
	 * Contains the number of comparisons performed on the last run
	 */
	public static int lastRunComparisons;

	/**
	 * Binary integer array search
	 * 
	 * @param array
	 *            The array to search within
	 * @param searchFor
	 *            The number to search for
	 * @param iMin
	 *            The minimum index boundary
	 * @param iMax
	 *            The maximum index boundary
	 * @return The index of the item or -1 if the item was not found
	 */
	public static int binaryIntSearch(int[] array, int searchFor, int iMin,
			int iMax) {
		int comparisons = 0;
		while (iMax >= iMin) {
			comparisons++;
			int iMid = iMin + ((iMax - iMin) / 2);
			if (array[iMid] == searchFor) {
				lastRunComparisons = comparisons;
				return iMid;
			}

			if (array[iMid] < searchFor) {
				iMin = iMid + 1;
			} else {
				iMax = iMid - 1;
			}
		}

		lastRunComparisons = comparisons;
		return -1;
	}

	/**
	 * Binary string array search
	 * 
	 * @param array
	 *            The array to search within
	 * @param searchFor
	 *            The string to search for
	 * @param iMin
	 *            The minimum index boundary
	 * @param iMax
	 *            The maximum index boundary
	 * @return The index of the item or -1 if the item was not found
	 */
	public static int binaryStringSearch(String[] array, String searchFor,
			int iMin, int iMax) {
		int comparisons = 0;
		while (iMax >= iMin) {
			comparisons++;
			int iMid = iMin + ((iMax - iMin) / 2);
			if (array[iMid].equals(searchFor)) {
				lastRunComparisons = comparisons;
				return iMid;
			}

			if (array[iMid].compareTo(searchFor) < 0) {
				iMin = iMid + 1;
			} else {
				iMax = iMid - 1;
			}
		}

		lastRunComparisons = comparisons;
		return -1;
	}

	/**
	 * Binary generic array search
	 * 
	 * @param array
	 *            The array to search within
	 * @param searchFor
	 *            The item to search for
	 * @param iMin
	 *            The minimum index boundary
	 * @param iMax
	 *            The maximum index boundary
	 * @return The index of the item or -1 if the item was not found
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] array,
			T searchFor, int iMin, int iMax) {
		int comparisons = 0;
		while (iMax >= iMin) {
			comparisons++;
			int iMid = iMin + ((iMax - iMin) / 2);
			if (array[iMid].equals(searchFor)) {
				lastRunComparisons = comparisons;
				return iMid;
			}

			if (array[iMid].compareTo(searchFor) < 0) {
				iMin = iMid + 1;
			} else {
				iMax = iMid - 1;
			}
		}

		lastRunComparisons = comparisons;
		return -1;
	}

	/**
	 * Binary integer array search
	 * 
	 * @param array
	 *            The array to search within
	 * @param searchFor
	 *            The number to search for
	 * @return The index of the item or -1 if the item was not found
	 */
	public static int binaryIntSearch(int[] array, int searchFor) {
		return binaryIntSearch(array, searchFor, 0, array.length - 1);
	}

	/**
	 * Binary string array search
	 * 
	 * @param array
	 *            The array to search within
	 * @param searchFor
	 *            The string to search for
	 * @return The index of the item or -1 if the item was not found
	 */
	public static int binaryStringSearch(String[] array, String searchFor) {
		return binaryStringSearch(array, searchFor, 0, array.length - 1);
	}

	/**
	 * Binary generic array search
	 * 
	 * @param array
	 *            The array to search within
	 * @param searchFor
	 *            The item to search for
	 * @return The index of the item or -1 if the item was not found
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] array,
			T searchFor) {
		return binarySearch(array, searchFor, 0, array.length - 1);
	}
}
