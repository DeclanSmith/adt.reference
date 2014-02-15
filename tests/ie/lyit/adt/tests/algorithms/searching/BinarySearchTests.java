package ie.lyit.adt.tests.algorithms.searching;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ie.lyit.adt.algorithms.searching.BinarySearch;
import ie.lyit.adt.tools.RandomArray;

import java.util.Random;

import org.junit.Test;

/**
 * Binary search unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class BinarySearchTests {

	/**
	 * Tests the basic functionality of the binary search algorithm
	 * 
	 * @throws Exception
	 */
	@Test
	public void basicTest() throws Exception {
		Random random = new Random();
		int[] randomArray = RandomArray.randomIntArray(1000, true, false);
		int randomIndex = random.nextInt(1000);
		assertEquals(randomIndex, BinarySearch.binaryIntSearch(randomArray,
				randomArray[randomIndex]));
	}
	
	/**
	 * Tests if the search algorithm correctly handles items not found
	 */
	@Test
	public void notFoundTest() {
		int[] numbers = new int[] { 1, 2, 3 };
		assertEquals(0, BinarySearch.binaryIntSearch(numbers, 1));
		assertEquals(-1, BinarySearch.binaryIntSearch(numbers, 4));
	}

	/**
	 * Tries to demonstrate the log2(n) efficiency
	 * 
	 * @throws Exception
	 */
	@Test
	public void logarithmicTest() throws Exception {
		for (int i = 0; i < 100; i++) {
			Random random = new Random();
			int[] randomArray = RandomArray.randomIntArray(1000, true, false);
			int randomIndex = random.nextInt(1000);
			assertEquals(randomIndex, BinarySearch.binaryIntSearch(randomArray,
					randomArray[randomIndex], 0, randomArray.length));
			assertTrue(BinarySearch.lastRunComparisons <= 10);
		}
	}
	
	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new BinarySearch();
	}
}
