package ie.lyit.adt.tests.datastructures;

import static org.junit.Assert.*;
import ie.lyit.adt.datastructures.SingleLinkedList;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Single linked list unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class SingleLinkedListTests {

	/**
	 * Add/get/remove first tests
	 */
	@Test
	public void addGetRemoveFirstTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.addFirst("markus");
		assertEquals("markus", list.getFirst());
		list.addFirst("grace");
		assertEquals("grace", list.getFirst());
		assertEquals("grace", list.removeFirst());
		assertEquals("markus", list.getFirst());
	}

	/**
	 * Reverse method test
	 */
	@Test
	public void reverseTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.addFirst("markus");
		list.addFirst("grace");
		list.addFirst("eliza");
		assertEquals("eliza", list.getFirst());
		list.reverse();
		assertEquals("markus", list.getFirst());
	}

	/**
	 * Empty list iterator test
	 */
	@Test
	public void emptyListIteratorTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		ListIterator<String> iterator = list.listIterator();
		assertFalse(iterator.hasNext());
	}

	/**
	 * List iterator test
	 */
	@Test
	public void iteratorTest() {
		// Set up basic list
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.addFirst("grace");
		list.addFirst("santa");
		list.addFirst("eliza");
		list.addFirst("markus");
		list.addFirst("stranger");

		// Check iterator status for each step
		ListIterator<String> iterator = list.listIterator();
		assertTrue(iterator.hasNext());
		assertEquals(0, iterator.nextIndex());
		assertEquals("stranger", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.nextIndex());
		assertEquals("markus", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.nextIndex());
		assertEquals("eliza", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(3, iterator.nextIndex());
		assertEquals("santa", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(4, iterator.nextIndex());
		assertEquals("grace", iterator.next());
		assertFalse(iterator.hasNext());
		assertEquals(5, iterator.nextIndex());

		// Test set/add/remove methods (remove and removeFirst)
		iterator = list.listIterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			if (name.equals("eliza")) {
				int nextIndex = iterator.nextIndex();
				iterator.set("eliza mae");
				assertEquals(nextIndex, iterator.nextIndex());
			}

			if (name.equals("grace")) {
				int nextIndex = iterator.nextIndex();
				iterator.add("elvis");
				assertEquals(nextIndex + 1, iterator.nextIndex());
			}

			if (name.equals("stranger") || name.equals("santa")) {
				int nextIndex = iterator.nextIndex();
				iterator.remove();
				assertEquals(nextIndex - 1, iterator.nextIndex());
			}
		}

		// Test addFirst
		iterator = list.listIterator();
		iterator.add("marian");
		assertEquals("markus", iterator.next());

		// Test if all operations were successful
		iterator = list.listIterator();
		assertEquals("marian", iterator.next());
		assertEquals("markus", iterator.next());
		assertEquals("eliza mae", iterator.next());
		assertEquals("grace", iterator.next());
		assertEquals("elvis", iterator.next());
		assertFalse(iterator.hasNext());
	}

	/**
	 * Empty getFirst test
	 */
	@Test(expected = NoSuchElementException.class)
	public void emptyGetFirstTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.getFirst();
	}

	/**
	 * Empty removeFirst test
	 */
	@Test(expected = NoSuchElementException.class)
	public void emptyRemoveFirstTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.removeFirst();
	}

	/**
	 * Iterator call next at the end test
	 */
	@Test(expected = NoSuchElementException.class)
	public void iteratorEndNextTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.addFirst("single");

		ListIterator<String> iterator = list.listIterator();
		assertEquals("single", iterator.next());
		iterator.next();
	}

	/**
	 * Remove without calling next test
	 */
	@Test(expected = IllegalStateException.class)
	public void removeWithoutNextTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.addFirst("single");
		ListIterator<String> iterator = list.listIterator();
		assertEquals("single", iterator.next());
		iterator.remove();
		iterator.add("another");
		iterator.remove();
	}

	/**
	 * Set before first element test
	 */
	@Test(expected = NoSuchElementException.class)
	public void setBeforeFirstElementTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.addFirst("single");
		ListIterator<String> iterator = list.listIterator();
		iterator.set("wont work");
	}

	/**
	 * Unsupported previous iterator methods test
	 */
	@Test
	public void unsupportedPreviousIteratorTest() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		ListIterator<String> iterator = list.listIterator();

		try {
			iterator.hasPrevious();
			fail("Should not reach");
		} catch (UnsupportedOperationException e) {
			assertNotNull(e);
		}

		try {
			iterator.previous();
			fail("Should not reach");
		} catch (UnsupportedOperationException e) {
			assertNotNull(e);
		}

		try {
			iterator.previousIndex();
			fail("Should not reach");
		} catch (UnsupportedOperationException e) {
			assertNotNull(e);
		}
	}
}
