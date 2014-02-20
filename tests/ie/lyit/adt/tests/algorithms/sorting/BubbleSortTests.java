package ie.lyit.adt.tests.algorithms.sorting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ie.lyit.adt.algorithms.sorting.BubbleSort;
import ie.lyit.adt.tools.ArraySortingCheck;
import ie.lyit.adt.tools.RandomArray;

import org.junit.Test;

/**
 * Bubble sort unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class BubbleSortTests {
	/**
	 * Tests if bubble sort is sorting int arrays correctly
	 */
	@Test
	public void sortIntArrayTest() {
		int[] array = RandomArray.randomIntArray(100, false, true);
		assertFalse(ArraySortingCheck.isIntArraySorted(array));
		BubbleSort.bubbleSortInt(array);
		assertTrue(ArraySortingCheck.isIntArraySorted(array));
	}

	/**
	 * Test if bubble sort is sorting generic arrays (string in this case)
	 * correctly
	 */
	@Test
	public void sortStringGenericTest() {
		String[] randomStrings = RandomArray.randomStringArray(100, 10, false,
				true);
		assertFalse(ArraySortingCheck.isArraySorted(randomStrings));
		BubbleSort.bubbleSort(randomStrings);
		assertTrue(ArraySortingCheck.isArraySorted(randomStrings));
	}

	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new BubbleSort();
	}
}
