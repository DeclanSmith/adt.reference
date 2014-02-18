package ie.lyit.adt.tools;

/**
 * Tool class that checks if arrays are sorted
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class ArraySortingCheck {
	/**
	 * Checks if the specified generic array is sorted ascending
	 * 
	 * @param arrayToCheck
	 *            The generic array to check
	 * @return True if the array is sorted, false otherwise
	 */
	public static <T extends Comparable<T>> boolean isArraySorted(
			T[] arrayToCheck) {
		for (int i = 1; i < arrayToCheck.length; i++) {
			if (arrayToCheck[i - 1].compareTo(arrayToCheck[i]) > 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks if the specified int array is sorted ascending
	 * 
	 * @param arrayToCheck
	 *            The int array to check
	 * @return True if the array is sorted, false otherwise
	 */
	public static boolean isIntArraySorted(int[] arrayToCheck) {
		for (int i = 1; i < arrayToCheck.length; i++) {
			if (arrayToCheck[i - 1] > arrayToCheck[i]) {
				return false;
			}
		}

		return true;
	}
}
