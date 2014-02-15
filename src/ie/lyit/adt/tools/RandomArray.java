package ie.lyit.adt.tools;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Random array generator
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class RandomArray {
	/**
	 * Creates a random integer array of the specified size
	 * 
	 * @param size
	 *            The size of the random array
	 * @param sorted
	 *            Should the elements be sorted?
	 * @param allowDuplicates
	 *            Allow duplicate elements in the array?
	 * @return Random integer array of the specified size
	 * @throws IllegalArgumentException
	 *             If the array size is invalid
	 */
	public static int[] randomIntArray(int size, boolean sorted,
			boolean allowDuplicates) throws IllegalArgumentException {
		if (size < 1) {
			throw new IllegalArgumentException("Size must be at least 1!");
		}

		Random randomGenerator = new Random();
		int[] randomArray = new int[size];
		if (allowDuplicates) {
			for (int i = 0; i < size; i++) {
				randomArray[i] = randomGenerator.nextInt();
			}

			if (sorted) {
				Arrays.sort(randomArray);
			}

			return randomArray;
		} else {
			Set<Integer> randomSet = new LinkedHashSet<Integer>();
			while (randomSet.size() < size) {
				randomSet.add(randomGenerator.nextInt());
			}

			int index = 0;
			for (Integer element : randomSet) {
				randomArray[index++] = element.intValue();
			}

			if (sorted) {
				Arrays.sort(randomArray);
			}

			return randomArray;
		}
	}

	/**
	 * Creates a random string array of the specified size
	 * 
	 * @param size
	 *            The size of the random array
	 * @param stringLength
	 *            The length of the strings to generate
	 * @param sorted
	 *            Should the elements be sorted?
	 * @param allowDuplicates
	 *            Allow duplicate elements in the array?
	 * @return Random string array of the specified size
	 * @throws IllegalArgumentException
	 *             If the array size is invalid
	 */
	public static String[] randomStringArray(int size, int stringLength,
			boolean sorted, boolean allowDuplicates)
			throws IllegalArgumentException {
		if (size < 1) {
			throw new IllegalArgumentException("Size must be at least 1!");
		}
		
		if (stringLength < 1) {
			throw new IllegalArgumentException("String length must be at least 1!");
		}

		Random randomGenerator = new Random();
		String[] randomArray = new String[size];
		if (allowDuplicates) {
			for (int i = 0; i < size; i++) {
				randomArray[i] = RandomString.generateRandomString(
						randomGenerator, RandomString.fullAlphaNumeric,
						stringLength);
			}

			if (sorted) {
				Arrays.sort(randomArray);
			}

			return randomArray;
		} else {
			Set<String> randomSet = new LinkedHashSet<String>();
			while (randomSet.size() < size) {
				randomSet.add(RandomString.generateRandomString(
						randomGenerator, RandomString.fullAlphaNumeric,
						stringLength));
			}

			int index = 0;
			for (String element : randomSet) {
				randomArray[index++] = element;
			}

			if (sorted) {
				Arrays.sort(randomArray);
			}

			return randomArray;
		}
	}
}
