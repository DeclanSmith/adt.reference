package ie.lyit.adt.datastructures;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Hash table
 * 
 * @author markus.korbel@lyit.ie
 * @param <T>
 *            The data type of the keys
 * @param <U>
 *            The data type of the values
 */
public class HashTable<T extends Serializable & Comparable<T>, U> {
	/**
	 * The array containing the hash table
	 */
	private HashTableEntry[][] hashTable;

	/**
	 * The number of MD5 hash bytes used for indexing (1: 256 entries, 2: 64K
	 * entries, 3: 16M entries)
	 */
	private int md5ByteCount;

	private MessageDigest md5;

	/**
	 * Creates new hash table
	 * 
	 * @param md5ByteCount
	 *            The number of MD5 hash bytes used for indexing (1: 256
	 *            entries, 2: 64K entries, 3: 16M entries)
	 * @throws IllegalArgumentException
	 *             If the MD5 byte count is out of range
	 * @throws NoSuchAlgorithmException
	 *             If the JVM does not support MD5 hashes
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int md5ByteCount) throws IllegalArgumentException,
			NoSuchAlgorithmException {
		if (md5ByteCount < 1 || md5ByteCount > 3) {
			throw new IllegalArgumentException("Invalid MD5 hash byte count!");
		}

		this.md5ByteCount = md5ByteCount;
		this.hashTable = (HashTableEntry[][]) Array.newInstance(
				HashTableEntry.class, (int) Math.pow(2, 8 * md5ByteCount), 0);
		md5 = MessageDigest.getInstance("MD5");
	}

	/**
	 * Add an element to the hash table
	 * 
	 * @param key
	 *            The key of the value
	 * @param value
	 *            The value to store under the key
	 * @throws IllegalArgumentException
	 *             If the specified key is already contained in the hash table
	 * @throws IOException
	 *             If the key cannot be converted to a byte array (implement
	 *             Serializable!)
	 */
	public void add(T key, U value) throws IllegalArgumentException,
			IOException {
		if (this.contains(key)) {
			throw new IllegalArgumentException("Key is already present!");
		}

		byte[] md5Hash = this.md5.digest(this.keyToByteArray(key));
		int md5Index = this.getMD5IndexPosition(md5Hash);

		HashTableEntry[] newArray = Arrays.copyOf(this.hashTable[md5Index],
				this.hashTable[md5Index].length + 1);
		newArray[newArray.length - 1] = new HashTableEntry(key, value);
		Arrays.sort(newArray);
		this.hashTable[md5Index] = newArray;
	}

	/**
	 * Returns the current size (number of stored elements) of the hash table
	 * 
	 * @return The number of elements stored
	 */
	public int size() {
		int totalElements = 0;
		for (int i = 0; i < (int) Math.pow(2, this.md5ByteCount * 8); i++) {
			totalElements += this.hashTable[i].length;
		}

		return totalElements;
	}

	/**
	 * Checks if the hash table contains the specified key
	 * 
	 * @param key
	 *            The key to search for
	 * @return True if the key is contained, false if not
	 * @throws IOException
	 *             If the key cannot be converted to a byte array (implement
	 *             Serializable!)
	 */
	public boolean contains(T key) throws IOException {
		byte[] md5Hash = this.md5.digest(this.keyToByteArray(key));
		int md5Index = this.getMD5IndexPosition(md5Hash);

		for (int i = 0; i < this.hashTable[md5Index].length; i++) {
			if (this.hashTable[md5Index][i].key.equals(key)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Retrieves the value stored using the specified key
	 * 
	 * @param key
	 *            The key to look for
	 * @return The element stored under the key, or NULL if the key is contained
	 *         within the hash table
	 * @throws IOException
	 *             If the key cannot be converted to a byte array (implement
	 *             Serializable!)
	 */
	public U get(T key) throws IOException {
		if (this.contains(key)) {
			byte[] md5Hash = this.md5.digest(this.keyToByteArray(key));
			int md5Index = this.getMD5IndexPosition(md5Hash);

			for (int i = 0; i < this.hashTable[md5Index].length; i++) {
				if (this.hashTable[md5Index][i].key.equals(key)) {
					return this.hashTable[md5Index][i].value;
				}
			}
		}

		return null;
	}

	/**
	 * Convert key into byte array so it can be hashed
	 * 
	 * @param key
	 *            The key to convert
	 * @return The byte representation of the key
	 */
	private byte[] keyToByteArray(T key) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bos);
		out.writeObject(key);
		return bos.toByteArray();
	}

	/**
	 * Helper method that converts the first 1-3 bytes of the MD5 hash into an
	 * index position in our hash table
	 * 
	 * @param md5Hash
	 *            The MD5 hash of the entry
	 * @return The index position within the table
	 */
	private int getMD5IndexPosition(byte[] md5Hash) {
		int index = 0;
		for (int i = 0; i < this.md5ByteCount; i++) {
			// Don't forget that java bytes are signed! +128 to have only positive values
			index = index * 256 + ((int) md5Hash[i] + 128);
		}

		return index;
	}

	/**
	 * Represents a single hash table entry
	 * 
	 * @author markus.korbel@lyit.ie
	 * 
	 */
	private class HashTableEntry implements Comparable<T>, Serializable {
		/**
		 * Serializable version UID
		 */
		private static final long serialVersionUID = 7359992375071487609L;

		/**
		 * The key of the entry
		 */
		T key;

		/**
		 * The value of the entry
		 */
		U value;

		/**
		 * Default constructor
		 * 
		 * @param key
		 *            The key of the entry
		 * @param value
		 *            The value of the entry
		 */
		public HashTableEntry(T key, U value) {
			this.key = key;
			this.value = value;
		}

		@SuppressWarnings("unchecked")
		@Override
		public int compareTo(T other) {
			return this.key.compareTo(((HashTableEntry) other).key);
		}
	}
}
