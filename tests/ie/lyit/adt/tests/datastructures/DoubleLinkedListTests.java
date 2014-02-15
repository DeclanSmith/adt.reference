package ie.lyit.adt.tests.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import ie.lyit.adt.datastructures.DoubleLinkedList;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Double linked list unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class DoubleLinkedListTests {

	/**
	 * Add/get/remove first tests
	 */
	@Test
	public void addGetRemoveFirstTests() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addFirst("markus");
		assertEquals("markus", list.getFirst());
		list.addFirst("grace");
		assertEquals("grace", list.getFirst());
		assertEquals("grace", list.removeFirst());
		assertEquals("markus", list.getFirst());
		assertEquals("markus", list.removeFirst());
	}

	/**
	 * Add/get/remove last tests
	 */
	@Test
	public void addGetRemoveLastTests() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addLast("markus");
		assertEquals("markus", list.getLast());
		list.addLast("grace");
		assertEquals("grace", list.getLast());
		assertEquals("grace", list.removeLast());
		assertEquals("markus", list.getLast());
		assertEquals("markus", list.removeLast());
	}

	/**
	 * Add/get/remove first/last mixed tests
	 */
	@Test
	public void addGetRemoveMixedTests() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addFirst("markus");
		assertEquals("markus", list.getFirst());
		assertEquals("markus", list.getLast());

		list.addFirst("grace");
		assertEquals("grace", list.getFirst());
		assertEquals("markus", list.getLast());

		list.addLast("eliza");
		assertEquals("grace", list.getFirst());
		assertEquals("eliza", list.getLast());

		assertEquals("grace", list.removeFirst());
		assertEquals("markus", list.getFirst());
		assertEquals("eliza", list.getLast());

		assertEquals("eliza", list.removeLast());
		assertEquals("markus", list.getFirst());
		assertEquals("markus", list.getLast());

		assertEquals("markus", list.removeLast());
		try {
			list.getFirst();
			fail("Should not reach!");
		} catch (NoSuchElementException e) {
			assertNotNull(e);
			// If we are getting this exception the list successfully reset back
			// to first=null when removing last
		}
	}
	
	/**
	 * Reverse method test
	 */
	@Test
	public void reverseTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addFirst("grace");
		list.addFirst("eliza");
		list.addLast("markus");
		
		assertEquals("eliza", list.getFirst());
		assertEquals("markus", list.getLast());
		list.reverse();
		assertEquals("markus", list.getFirst());
		assertEquals("eliza", list.getLast());
		
		// Check if double linking is again correct
		ListIterator<String> iterator = list.listIterator();
		assertEquals(-1, iterator.previousIndex());
		assertFalse(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(0, iterator.nextIndex());
		assertEquals("markus", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.nextIndex());
		assertEquals("grace", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.nextIndex());
		assertEquals("eliza", iterator.next());
		assertFalse(iterator.hasNext());
		assertEquals(3, iterator.nextIndex());

		assertEquals(2, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("eliza", iterator.previous());
		assertEquals(1, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("grace", iterator.previous());
		assertEquals(0, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("markus", iterator.previous());
		assertEquals(-1, iterator.previousIndex());
		assertFalse(iterator.hasPrevious());
	}

	/**
	 * Empty list iterator test
	 */
	@Test
	public void emptyListIteratorTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		ListIterator<String> iterator = list.listIterator();
		assertFalse(iterator.hasNext());
	}
	
	/**
	 * List iterator test
	 */
	@Test
	public void iteratorTest() {
		// Set up basic list
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addFirst("grace");
		list.addFirst("eliza");
		list.addLast("markus");

		// Check iterator status for each step
		ListIterator<String> iterator = list.listIterator();
		assertEquals(-1, iterator.previousIndex());
		assertFalse(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(0, iterator.nextIndex());
		assertEquals("eliza", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.nextIndex());
		assertEquals("grace", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.nextIndex());
		assertEquals("markus", iterator.next());
		assertFalse(iterator.hasNext());
		assertEquals(3, iterator.nextIndex());

		assertEquals(2, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("markus", iterator.previous());
		assertEquals(1, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("grace", iterator.previous());
		assertEquals(0, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("eliza", iterator.previous());
		assertEquals(-1, iterator.previousIndex());
		assertFalse(iterator.hasPrevious());
	}

	/**
	 * Iterator add/set/remove test
	 */
	@Test
	public void iteratorAddSetRemoveTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addFirst("grace");
		list.addFirst("santa");
		list.addFirst("eliza");
		list.addFirst("markus");
		list.addFirst("stranger");

		// Test set/add/remove methods (remove and removeFirst)
		ListIterator<String> iterator = list.listIterator();
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
		
		// Test addMiddle
		assertEquals("eliza mae", iterator.next());
		iterator.add("eva");
		assertEquals("eva", iterator.previous());
		assertEquals("eva", iterator.next());
		assertEquals("grace", iterator.next());
		
		// Test removeLast
		assertEquals("elvis", iterator.next());
		assertFalse(iterator.hasNext());
		iterator.remove();
		assertFalse(iterator.hasNext());
		assertEquals("grace", iterator.previous());
		
		// Check if double chaining is still correct
		iterator = list.listIterator();
		assertEquals(-1, iterator.previousIndex());
		assertFalse(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(0, iterator.nextIndex());
		assertEquals("marian", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.nextIndex());
		assertEquals("markus", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.nextIndex());
		assertEquals("eliza mae", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(3, iterator.nextIndex());
		assertEquals("eva", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(4, iterator.nextIndex());
		assertEquals("grace", iterator.next());
		assertFalse(iterator.hasNext());
		assertEquals(5, iterator.nextIndex());

		assertEquals(4, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("grace", iterator.previous());
		assertEquals(3, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("eva", iterator.previous());
		assertEquals(2, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("eliza mae", iterator.previous());
		assertEquals(1, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("markus", iterator.previous());
		assertEquals(0, iterator.previousIndex());
		assertTrue(iterator.hasPrevious());
		assertEquals("marian", iterator.previous());
		assertEquals(-1, iterator.previousIndex());
		assertFalse(iterator.hasPrevious());
	}

	/**
	 * Empty getFirst test
	 */
	@Test(expected = NoSuchElementException.class)
	public void emptyGetFirstTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.getFirst();
	}

	/**
	 * Empty removeFirst test
	 */
	@Test(expected = NoSuchElementException.class)
	public void emptyRemoveFirstTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.removeFirst();
	}

	/**
	 * Empty getLast test
	 */
	@Test(expected = NoSuchElementException.class)
	public void emptyGetLastTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.getLast();
	}

	/**
	 * Empty removeLast test
	 */
	@Test(expected = NoSuchElementException.class)
	public void emptyRemoveLastTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.removeLast();
	}
	
	/**
	 * Iterator call next at the end test
	 */
	@Test(expected = NoSuchElementException.class)
	public void iteratorEndNextTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
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
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
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
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addFirst("single");
		ListIterator<String> iterator = list.listIterator();
		iterator.set("wont work");
	}
	
	/**
	 * Iterator call previous at the beginning test
	 */
	@Test(expected = NoSuchElementException.class)
	public void iteratorBeginningPreviousTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addFirst("single");
		ListIterator<String> iterator = list.listIterator();
		iterator.previous();
	}
}
