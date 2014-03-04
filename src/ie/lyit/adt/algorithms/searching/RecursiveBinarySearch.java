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
		// TODO implement me!!
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
}
