package ie.lyit.adt.algorithms.searching;

/**
 * Binary search algorithm - Recursive implementation
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class RecursiveBinarySearch {
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
		// Check if the array is empty
		if (iMax < iMin) {
			return -1;
		}

		// Calculate the midpoint to cut array in half
		int iMid = iMin + ((iMax - iMin) / 2);

		// Three way comparison
		if (array[iMid] > searchFor) {
			// searchFor is in lower sub-array
			return binaryIntSearch(array, searchFor, iMin, iMid - 1);
		} else if (array[iMid] < searchFor) {
			// searchFor is in upper sub-array
			return binaryIntSearch(array, searchFor, iMid + 1, iMax);
		} else {
			// searchFor has been found
			return iMid;
		}
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
}
