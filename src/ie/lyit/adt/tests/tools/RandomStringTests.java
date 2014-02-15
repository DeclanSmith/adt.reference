package ie.lyit.adt.tests.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import ie.lyit.adt.tools.RandomString;

import java.util.Random;

import org.junit.Test;

/**
 * Random string generator unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class RandomStringTests {

	/**
	 * Test the length only method
	 */
	@Test
	public void onlyLengthTest() {
		String randomString = RandomString.generateRandomString(10);
		assertEquals(10, randomString.length());
		assertFalse(randomString.contains("@"));
	}

	/**
	 * Character set tests
	 */
	@Test
	public void characterSetTest() {
		String randomString = RandomString.generateRandomString(
				RandomString.lowerCaseAlpha, 50);
		assertEquals(randomString.toLowerCase(), randomString);
		assertFalse(randomString.contains("0"));
		assertFalse(randomString.contains("1"));
		assertFalse(randomString.contains("2"));
		assertFalse(randomString.contains("3"));
		assertFalse(randomString.contains("4"));
		assertFalse(randomString.contains("5"));
		assertFalse(randomString.contains("6"));
		assertFalse(randomString.contains("7"));
		assertFalse(randomString.contains("8"));
		assertFalse(randomString.contains("9"));

		randomString = RandomString.generateRandomString(
				RandomString.upperCaseAlpha, 50);
		assertEquals(randomString.toUpperCase(), randomString);
		assertFalse(randomString.contains("0"));
		assertFalse(randomString.contains("1"));
		assertFalse(randomString.contains("2"));
		assertFalse(randomString.contains("3"));
		assertFalse(randomString.contains("4"));
		assertFalse(randomString.contains("5"));
		assertFalse(randomString.contains("6"));
		assertFalse(randomString.contains("7"));
		assertFalse(randomString.contains("8"));
		assertFalse(randomString.contains("9"));

		randomString = RandomString.generateRandomString("x", 10);
		assertEquals("xxxxxxxxxx", randomString);
	}

	/**
	 * Existing random number generator test
	 */
	@Test
	public void existingRngTest() {
		Random randomGenerator = new Random();
		String randomString = RandomString.generateRandomString(
				randomGenerator, RandomString.fullAlphaNumeric, 10);
		assertEquals(10, randomString.length());
	}

	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new RandomString();
	}

	/**
	 * NULL random generator test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nullRngTest() {
		RandomString.generateRandomString(null, RandomString.fullAlphaNumeric,
				10);
	}

	/**
	 * NULL charset test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nullCharsetTest() {
		RandomString.generateRandomString(null, 10);
	}

	/**
	 * Empty charset test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void emptyCharsetTest() {
		RandomString.generateRandomString("", 10);
	}

	/**
	 * Less than 1 string length test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void lessThan1LengthTest() {
		RandomString.generateRandomString(0);
	}
}
