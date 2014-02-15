package ie.lyit.adt.tests.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ie.lyit.adt.datastructures.Stack;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Stack unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class StackTests {

	/**
	 * Base constructor and generic array creation test
	 */
	@Test
	public void baseConstructorTest() {
		Stack<Integer> testStack = new Stack<Integer>();
		assertTrue(testStack.isEmpty());
		assertFalse(testStack.isFull());
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		testStack.push(4);
		testStack.push(5);
		assertTrue(testStack.isFull());
		assertFalse(testStack.isEmpty());

		testStack = new Stack<Integer>(2);
		testStack.push(1);
		testStack.push(2);
		assertTrue(testStack.isFull());
	}

	/**
	 * Push/Peek/Pop test
	 */
	@Test
	public void pushPeekPopTest() {
		Stack<Integer> testStack = new Stack<Integer>();
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		assertEquals(3, testStack.peek().intValue());
		assertEquals(3, testStack.peek().intValue());
		assertEquals(3, testStack.pop().intValue());
		testStack.push(4);
		assertEquals(4, testStack.pop().intValue());
		assertEquals(2, testStack.pop().intValue());
		assertEquals(1, testStack.pop().intValue());
		assertTrue(testStack.isEmpty());
	}

	/**
	 * Reset method test
	 */
	@Test
	public void resetTest() {
		Stack<Integer> testStack = new Stack<Integer>();
		testStack.push(1);
		testStack.push(2);
		assertFalse(testStack.isEmpty());
		testStack.reset();
		assertTrue(testStack.isEmpty());
	}

	/**
	 * ToString method test
	 */
	@Test
	public void toStringTest() {
		Stack<Integer> testStack = new Stack<Integer>();
		assertEquals("Stack []", testStack.toString());
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		assertEquals("Stack [1, 2, 3]", testStack.toString());
	}

	/**
	 * Stack of size 0 test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void emptyStackTest() {
		new Stack<Integer>(0);
	}

	/**
	 * Pop empty test
	 */
	@Test(expected = NoSuchElementException.class)
	public void emptyPopTest() {
		Stack<Integer> testStack = new Stack<Integer>();
		testStack.pop();
	}

	/**
	 * Push full test
	 */
	@Test(expected = IllegalStateException.class)
	public void fullPushTest() {
		Stack<Integer> testStack = new Stack<Integer>(1);
		testStack.push(1);
		testStack.push(2);
	}

	/**
	 * Peek empty test
	 */
	@Test(expected = NoSuchElementException.class)
	public void emptyPeekTest() {
		Stack<Integer> testStack = new Stack<Integer>();
		testStack.peek();
	}
}
