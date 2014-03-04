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
	 */
	@Test
	public void basicIntTest() {
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
	public void intNotFoundTest() {
		int[] numbers = new int[] { 1, 2, 3 };
		assertEquals(0, BinarySearch.binaryIntSearch(numbers, 1));
		assertEquals(-1, BinarySearch.binaryIntSearch(numbers, 4));
	}

	/**
	 * Tests the basic functionality of the binary search algorithm
	 */
	@Test
	public void basicStringTest() {
		Random random = new Random();
		String[] randomArray = RandomArray.randomStringArray(1000, 10, true,
				false);
		int randomIndex = random.nextInt(1000);
		assertEquals(randomIndex, BinarySearch.binaryStringSearch(randomArray,
				randomArray[randomIndex]));
	}

	/**
	 * Tests if the search algorithm correctly handles items not found
	 */
	@Test
	public void stringNotFoundTest() {
		String[] strings = new String[] { "a", "b", "c" };
		assertEquals(1, BinarySearch.binaryStringSearch(strings, "b"));
		assertEquals(-1, BinarySearch.binaryStringSearch(strings, "d"));
	}

	/**
	 * Tests the basic functionality of the binary search algorithm
	 */
	@Test
	public void basicGenericTest() {
		Random random = new Random();
		Student[] students = new Student[1000];
		int[] randomStudentIDs = RandomArray.randomIntArray(1000, true, false);
		String[] randomPasswords = RandomArray.randomStringArray(1000, 8,
				false, true);
		for (int i = 0; i < 1000; i++) {
			students[i] = new Student(randomStudentIDs[i], randomPasswords[i]);
		}

		int randomIndex = random.nextInt(1000);
		int searchResult = BinarySearch.binarySearch(students,
				students[randomIndex]);
		assertEquals(randomIndex, searchResult);
	}

	/**
	 * Tests if the search algorithm correctly handles items not found
	 */
	@Test
	public void genericNotFoundTest() {
		Student[] students = new Student[] { new Student(1, "test"),
				new Student(99, "random") };
		assertEquals(1, BinarySearch.binarySearch(students, new Student(99,
				"doesn't matter")));
		assertEquals(-1,
				BinarySearch.binarySearch(students, new Student(2, "xxx")));
	}

	/**
	 * Tries to demonstrate the log2(n) efficiency
	 */
	@Test
	public void logarithmicTest() {
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
