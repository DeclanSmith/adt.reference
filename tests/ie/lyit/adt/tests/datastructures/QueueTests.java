package ie.lyit.adt.tests.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ie.lyit.adt.datastructures.Queue;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Queue unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class QueueTests {

	/**
	 * Base constructor and generic array creation test
	 */
	@Test
	public void baseConstructorTest() {
		Queue<String> testQueue = new Queue<String>();
		assertTrue(testQueue.isEmpty());
		assertFalse(testQueue.isFull());
		assertEquals(0, testQueue.Size());
		testQueue.Append("first");
		testQueue.Append("second");
		testQueue.Append("third");
		assertEquals(3, testQueue.Size());
		testQueue.Append("fourth");
		testQueue.Append("fifth");
		assertEquals(5, testQueue.Size());
		assertTrue(testQueue.isFull());
		assertFalse(testQueue.isEmpty());

		testQueue = new Queue<String>(1);
		testQueue.Append("single");
		assertTrue(testQueue.isFull());
	}

	/**
	 * Append/Peek/Remove test
	 */
	@Test
	public void appendPeekRemoveTest() {
		Queue<String> testQueue = new Queue<String>();
		testQueue.Append("first");
		testQueue.Append("second");
		testQueue.Append("third");
		assertEquals("first", testQueue.Peek());
		assertEquals("first", testQueue.Peek());
		assertEquals("first", testQueue.Remove());
		testQueue.Append("fourth");
		assertEquals("second", testQueue.Remove());
		assertEquals("third", testQueue.Remove());
		assertEquals("fourth", testQueue.Remove());
		assertTrue(testQueue.isEmpty());
		assertEquals(0, testQueue.Size());
	}

	/**
	 * Array index rollover test
	 */
	@Test
	public void rollOverTest() {
		Queue<String> testQueue = new Queue<String>(3);
		testQueue.Append("first");
		testQueue.Append("second");
		testQueue.Append("third");
		assertEquals("first", testQueue.Remove());
		assertEquals("second", testQueue.Remove());
		testQueue.Append("fourth");
		testQueue.Append("fifth");
		assertEquals(3, testQueue.Size());
		assertEquals("third", testQueue.Remove());
		assertEquals("fourth", testQueue.Remove());
		assertEquals(1, testQueue.Size());
		testQueue.Append("sixth");
		testQueue.Append("seventh");
		assertEquals("fifth", testQueue.Remove());
		assertEquals("sixth", testQueue.Remove());
		assertEquals("seventh", testQueue.Remove());
		assertTrue(testQueue.isEmpty());
	}

	/**
	 * ToString method test
	 */
	@Test
	public void toStringTest() {
		Queue<String> testQueue = new Queue<String>();
		assertEquals("Queue []", testQueue.toString());

		testQueue.Append("first");
		testQueue.Append("second");
		assertEquals("Queue [first, second]", testQueue.toString());
	}

	/**
	 * Queue of size 0 test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void emptyQueueTest() {
		new Queue<String>(0);
	}

	/**
	 * Append full test
	 */
	@Test(expected = IllegalStateException.class)
	public void appendFullTest() {
		Queue<String> testQueue = new Queue<String>(1);
		testQueue.Append("first");
		testQueue.Append("second");
	}

	/**
	 * Remove empty test
	 */
	@Test(expected = NoSuchElementException.class)
	public void removeEmptyTest() {
		Queue<String> testQueue = new Queue<String>();
		testQueue.Remove();
	}

	/**
	 * Peek empty test
	 */
	@Test(expected = NoSuchElementException.class)
	public void peekEmptyTest() {
		Queue<String> testQueue = new Queue<String>();
		testQueue.Peek();
	}
}
