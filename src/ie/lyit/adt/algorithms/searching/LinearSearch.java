package ie.lyit.adt.algorithms.searching;

/**
 * Linear searching algorithm
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class LinearSearch {
	/**
	 * Linear search inside an integer array
	 * 
	 * @param array
	 *            The array to search
	 * @param searchFor
	 *            The number to search for
	 * @return The index of the number if found, -1 otherwise
	 */
	public static int linearIntSearch(int[] array, int searchFor) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == searchFor) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Linear search inside an string array
	 * 
	 * @param array
	 *            The array to search
	 * @param searchFor
	 *            The string to search for
	 * @return The index of the string if found, -1 otherwise
	 */
	public static int linearStringSearch(String[] array, String searchFor) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(searchFor)) {
				return i;
			}
		}

		return -1;
	}
}
