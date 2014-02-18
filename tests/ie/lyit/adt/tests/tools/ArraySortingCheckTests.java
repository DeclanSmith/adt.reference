package ie.lyit.adt.tests.tools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ie.lyit.adt.tools.ArraySortingCheck;

import org.junit.Test;

/**
 * Array sorting check unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class ArraySortingCheckTests {
	/**
	 * Checks the sorting check with basic int arrays (special method)
	 */
	@Test
	public void intArrayTests() {
		int[] sorted = new int[] { 1, 2, 4, 5, 5, 7, 9 };
		assertTrue(ArraySortingCheck.isIntArraySorted(sorted));

		int[] unsorted = new int[] { 6, 3, 9, 8 };
		assertFalse(ArraySortingCheck.isIntArraySorted(unsorted));
	}

	/**
	 * Checks the generic sorting check method with Integer arrays
	 */
	@Test
	public void integerArrayTests() {
		Integer[] sorted = new Integer[] { 1, 2, 4, 5, 5, 7, 9 };
		assertTrue(ArraySortingCheck.isArraySorted(sorted));

		Integer[] unsorted = new Integer[] { 6, 3, 9, 8 };
		assertFalse(ArraySortingCheck.isArraySorted(unsorted));
	}

	/**
	 * Checks the generic sorting check method with String arrays
	 */
	@Test
	public void stringArrayTests() {
		String[] sorted = new String[] { "Alfie", "Bernie", "Billy", "Markus" };
		assertTrue(ArraySortingCheck.isArraySorted(sorted));

		String[] unsorted = new String[] { "Markus", "Bernie" };
		assertFalse(ArraySortingCheck.isArraySorted(unsorted));
	}

	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new ArraySortingCheck();
	}
}
