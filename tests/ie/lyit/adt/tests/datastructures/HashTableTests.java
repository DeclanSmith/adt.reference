package ie.lyit.adt.tests.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import ie.lyit.adt.datastructures.HashTable;
import ie.lyit.adt.tools.RandomArray;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

/**
 * Hash table unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class HashTableTests {

	/**
	 * Basic hash table storage test
	 * 
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Test
	public void basicStorageTest() throws IllegalArgumentException,
			NoSuchAlgorithmException, IOException {
		HashTable<Integer, String> hashTable = new HashTable<Integer, String>(1);

		// Add item and check
		hashTable.add(4469, "markus");
		assertEquals(1, hashTable.size());
		assertTrue(hashTable.contains(4469));
		assertEquals("markus", hashTable.get(4469));

		// Add item and check
		hashTable.add(1234, "test");
		assertEquals(2, hashTable.size());
		assertTrue(hashTable.contains(1234));
		assertEquals("test", hashTable.get(1234));

		// Check get with non-existent
		assertNull(hashTable.get(0));

		// New remove an item
		hashTable.remove(1234);
		assertFalse(hashTable.contains(1234));

		// Remove non-existent
		hashTable.remove(0);
	}

	/**
	 * Tests if all elements are stored and retrieved correctly even with
	 * collisions
	 * 
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Test
	public void collisionTest() throws IllegalArgumentException,
			NoSuchAlgorithmException, IOException {
		// Hash table has 256 slots, if we add more we are guaranteed to have
		// collisions
		HashTable<Integer, String> hashTable = new HashTable<Integer, String>(1);

		// Add 1000 elements with random (no duplicates!) strings
		String[] randomStrings = RandomArray.randomStringArray(1000, 10, false,
				false);
		for (int i = 0; i < 1000; i++) {
			hashTable.add(i, randomStrings[i]);
		}

		assertEquals(1000, hashTable.size());
		
		// Check if all keys are found
		for (int i = 0; i < 1000; i++) {
			assertTrue(hashTable.contains(i));
		}

		// Check if all keys are still mapped to correct random string
		for (int i = 0; i < 1000; i++) {
			assertEquals(randomStrings[i], hashTable.get(i));
		}

		// Remove them one by one to see if the hash table scales back correctly
		for (int i = 0; i < 1000; i++) {
			hashTable.remove(i);
			assertFalse(hashTable.contains(i));
		}
		
		assertEquals(0, hashTable.size());
	}

	/**
	 * Duplicate key exception test
	 * 
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void duplicateKeyTest() throws IllegalArgumentException,
			NoSuchAlgorithmException, IOException {
		HashTable<Integer, String> hashTable = new HashTable<Integer, String>(1);
		hashTable.add(4469, "markus");
		assertEquals(1, hashTable.size());
		assertTrue(hashTable.contains(4469));
		hashTable.add(4469, "doesn't matter");
	}

	/**
	 * Illegal MD5 byte count exception tests
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void illegalMD5ByteCountTest() throws NoSuchAlgorithmException {
		try {
			new HashTable<Integer, String>(0);
			fail("Should not reach!");
		} catch (IllegalArgumentException e) {
		}
		try {
			new HashTable<Integer, String>(4);
			fail("Should not reach!");
		} catch (IllegalArgumentException e) {
		}
	}
}
