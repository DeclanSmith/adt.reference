package ie.lyit.adt.tests.algorithms.sorting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ie.lyit.adt.algorithms.sorting.QuickSort;
import ie.lyit.adt.tools.ArraySortingCheck;
import ie.lyit.adt.tools.RandomArray;

import org.junit.Test;

/**
 * Quick sort unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class QuickSortTests {
	/**
	 * Tests if merge sort is sorting int arrays correctly
	 */
	@Test
	public void sortIntArrayTest() {
		int[] array = RandomArray.randomIntArray(100, false, false);
		assertFalse(ArraySortingCheck.isIntArraySorted(array));
		QuickSort.quickSortInt(array);
		assertTrue(ArraySortingCheck.isIntArraySorted(array));
	}

	/**
	 * Tests if merge is sorting Comparable arrays correctly (tests using
	 * Strings)
	 */
	@Test
	public void sortStringGenericTest() {
		String[] randomStrings = RandomArray.randomStringArray(100, 10, false,
				true);
		assertFalse(ArraySortingCheck.isArraySorted(randomStrings));
		QuickSort.quickSort(randomStrings);
		assertTrue(ArraySortingCheck.isArraySorted(randomStrings));
	}

	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new QuickSort();
	}
}
