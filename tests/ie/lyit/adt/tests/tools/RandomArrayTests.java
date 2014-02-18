package ie.lyit.adt.tests.tools;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;

import ie.lyit.adt.tools.ArraySortingCheck;
import ie.lyit.adt.tools.RandomArray;

import org.junit.Test;

/**
 * Random array generator unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class RandomArrayTests {
	/**
	 * Tests the random integer array creation
	 */
	@Test
	public void testRandomIntArray() {
		// Basic tests (prints out generated elements)
		int[] basic = RandomArray.randomIntArray(10, false, true);
		assertTrue(basic.length == 10);

		// Checks if sorting parameter works
		int[] sorted = RandomArray.randomIntArray(10, true, false);
		assertTrue(ArraySortingCheck.isIntArraySorted(sorted));
		
		// Checks if noDuplicates parameter works
		int[] noDuplicates = RandomArray.randomIntArray(1000, false, false);
		Set<Integer> duplicatesCheck = new LinkedHashSet<Integer>();
		for (int element : noDuplicates) {
			assertTrue(duplicatesCheck.add(element));
		}

		// Test sorted but with duplicates
		int[] sortedWithDuplicates = RandomArray.randomIntArray(1000, true, true);
		assertTrue(ArraySortingCheck.isIntArraySorted(sortedWithDuplicates));
	}

	/**
	 * Tests the random string array creation
	 */
	@Test
	public void testRandomStringArray() {
		// Basic tests (prints out generated elements)
		String[] basic = RandomArray.randomStringArray(10, 10, false, true);
		assertTrue(basic.length == 10);
		assertTrue(basic[0].length() == 10);

		// Demonstrate string sorting (works on ASCII chars?)
		assertTrue("a".compareTo("b") < 0);
		assertTrue("A".compareTo("a") < 0);
		assertTrue("a".compareTo("A") > 0);
		assertTrue("a".compareTo("0") > 0);
		assertTrue("A".compareTo("0") > 0);
		assertTrue("0".compareTo("a") < 0);

		// Checks if sorting parameter works
		String[] sorted = RandomArray.randomStringArray(10, 3, true, false);
		assertTrue(ArraySortingCheck.isArraySorted(sorted));

		// Checks if noDuplicates parameter works
		String[] noDuplicates = RandomArray.randomStringArray(1000, 4, false,
				false);
		Set<String> duplicatesCheck = new LinkedHashSet<String>();
		for (String element : noDuplicates) {
			assertTrue(duplicatesCheck.add(element));
		}

		// Test sorted but with duplicates
		String[] sortedWithDuplicates = RandomArray.randomStringArray(1000, 4,
				true, true);
		assertTrue(ArraySortingCheck.isArraySorted(sortedWithDuplicates));
	}

	/**
	 * Checks if the empty integer array size exception get's thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void invalidIntSizeTest() {
		RandomArray.randomIntArray(0, false, false);
	}

	/**
	 * Checks if the empty string array size exception get's thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void invalidStringSizeTest() {
		RandomArray.randomStringArray(0, 10, false, false);
	}

	/**
	 * Checks if the 0 string length exception get's thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void invalidStringLengthTest() {
		RandomArray.randomStringArray(10, 0, false, false);
	}

	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new RandomArray();
	}
}
