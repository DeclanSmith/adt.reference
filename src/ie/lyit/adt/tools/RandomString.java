package ie.lyit.adt.tools;

import java.util.Random;

/**
 * Random string generator
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class RandomString {
	/**
	 * Full alpha numeric character set (upper and lower case + numbers)
	 */
	public final static String fullAlphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

	/**
	 * Full alphabet character set (upper and lower case)
	 */
	public final static String fullAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";

	/**
	 * Upper case alphabet character set
	 */
	public final static String upperCaseAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * Lower case alphabet character set
	 */
	public final static String lowerCaseAlpha = "abcdefghijklmnopqrstuvxyz";

	/**
	 * Generates a random string (full alpha numeric set)
	 * 
	 * @param length
	 *            The desired length of the random string
	 * @return The random string
	 */
	public static String generateRandomString(int length) {
		return generateRandomString(fullAlphaNumeric, length);
	}

	/**
	 * Generates a random string
	 * 
	 * @param characters
	 *            The allowed character to use
	 * @param length
	 *            The desired length of the random string
	 * @return The random string
	 */
	public static String generateRandomString(String characters, int length) {
		return generateRandomString(new Random(), characters, length);
	}

	/**
	 * Generates a random string
	 * 
	 * @param randomGenerator
	 *            The random number generator to use (if already existing)
	 * @param characters
	 *            The allowed character to use
	 * @param length
	 *            The desired length of the random string
	 * @return The random string
	 */
	public static String generateRandomString(Random randomGenerator,
			String characters, int length) {
		if (randomGenerator == null) {
			throw new IllegalArgumentException(
					"Must provide initialized random number generator!");
		}

		if (characters == null || characters.length() == 0) {
			throw new IllegalArgumentException(
					"No or invalid character set specified!");
		}

		if (length < 1) {
			throw new IllegalArgumentException(
					"String length must be at least 1!");
		}

		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(randomGenerator.nextInt(characters
					.length()));
		}
		return new String(text);
	}
}
