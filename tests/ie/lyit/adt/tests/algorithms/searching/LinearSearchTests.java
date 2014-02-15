package ie.lyit.adt.tests.algorithms.searching;

import static org.junit.Assert.assertEquals;
import ie.lyit.adt.algorithms.searching.LinearSearch;
import ie.lyit.adt.tools.RandomArray;

import java.util.Random;

import org.junit.Test;

/**
 * Linear search unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class LinearSearchTests {
	/**
	 * Tests the basic functionality of the linear search algorithm
	 */
	@Test
	public void basicIntTest() {
		Random random = new Random();
		int[] randomArray = RandomArray.randomIntArray(1000, false, false);
		int randomIndex = random.nextInt(1000);
		assertEquals(randomIndex, LinearSearch.linearIntSearch(randomArray,
				randomArray[randomIndex]));
	}

	/**
	 * Tests if the search algorithm correctly handles items not found
	 */
	@Test
	public void intNotFoundTest() {
		int[] numbers = new int[] { 1, 2, 3 };
		assertEquals(0, LinearSearch.linearIntSearch(numbers, 1));
		assertEquals(-1, LinearSearch.linearIntSearch(numbers, 4));
	}

	/**
	 * Tests the basic functionality of the linear search algorithm
	 */
	@Test
	public void basicStringTest() {
		Random random = new Random();
		String[] randomArray = RandomArray.randomStringArray(1000, 10, false,
				false);
		int randomIndex = random.nextInt(1000);
		assertEquals(randomIndex, LinearSearch.linearStringSearch(randomArray,
				randomArray[randomIndex]));
	}

	/**
	 * Tests if the search algorithm correctly handles items not found
	 */
	@Test
	public void stringNotFoundTest() {
		String[] strings = new String[] { "a", "b", "c" };
		assertEquals(1, LinearSearch.linearStringSearch(strings, "b"));
		assertEquals(-1, LinearSearch.linearStringSearch(strings, "d"));
	}

	/**
	 * Tests if the average efficiency of the linear search is n/2
	 */
	@Test
	public void trendingTest() {
		int totalComparisons = 0;
		Random random = new Random();

		for (int i = 0; i < 50000; i++) {
			int[] randomArray = RandomArray.randomIntArray(50, false, false);
			int randomIndex = random.nextInt(50);
			int searchIndex = LinearSearch.linearIntSearch(randomArray,
					randomArray[randomIndex]);
			totalComparisons += searchIndex >= 0 ? searchIndex : 50;
			assertEquals(randomIndex, searchIndex);
		}

		assertEquals(25.0, totalComparisons / 50000.0, 2.5);
	}

	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new LinearSearch();
	}
}
