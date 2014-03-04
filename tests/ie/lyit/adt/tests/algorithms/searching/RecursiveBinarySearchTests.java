package ie.lyit.adt.tests.algorithms.searching;

import static org.junit.Assert.assertEquals;
import ie.lyit.adt.algorithms.searching.RecursiveBinarySearch;
import ie.lyit.adt.tools.RandomArray;

import java.util.Random;

import org.junit.Test;

/**
 * Recursive binary search unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class RecursiveBinarySearchTests {

	/**
	 * Tests the basic functionality of the recursive binary search algorithm
	 */
	@Test
	public void basicIntTest() {
		Random random = new Random();
		int[] randomArray = RandomArray.randomIntArray(1000, true, false);
		int randomIndex = random.nextInt(1000);
		assertEquals(randomIndex, RecursiveBinarySearch.binaryIntSearch(
				randomArray, randomArray[randomIndex]));
	}
	
	/**
	 * Tests if the search algorithm correctly handles items not found
	 */
	@Test
	public void intNotFoundTest() {
		int[] numbers = new int[] { 1, 2, 3 };
		assertEquals(0, RecursiveBinarySearch.binaryIntSearch(numbers, 1));
		assertEquals(-1, RecursiveBinarySearch.binaryIntSearch(numbers, 4));
	}
	
	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new RecursiveBinarySearch();
	}
}
