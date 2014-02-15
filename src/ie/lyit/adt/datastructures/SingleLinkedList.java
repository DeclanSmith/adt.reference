package ie.lyit.adt.datastructures;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Single linked list
 * 
 * @author markus.korbel@lyit.ie
 * @param <T>
 *            The data type for the linked list data elements
 * 
 */
public class SingleLinkedList<T> {
	/**
	 * The first node in the list (or NULL if the list is empty)
	 */
	private Node<T> first;

	/**
	 * Retrieves the first data element in the list (like Peek in stack)
	 * 
	 * @return The first data element
	 * @throws NoSuchElementException
	 *             If the list is empty
	 */
	public T getFirst() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	/**
	 * Adds a data element at the beginning of the list (moving existing
	 * elements back) (like Push in stack)
	 * 
	 * @param data
	 *            The data element to store
	 */
	public void addFirst(T data) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		newNode.next = first;

		first = newNode;
	}

	/**
	 * Removes and returns the first data element in the list (like Pop in
	 * stack)
	 * 
	 * @return The data element retrieved before removing it
	 * @throws NoSuchElementException
	 *             If the list is empty
	 */
	public T removeFirst() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T obj = first.data;

		first = first.next;
		return obj;
	}

	/**
	 * Reverses the list
	 */
	public void reverse() {
		Node<T> newFirst = null;
		while (first != null) {
			Node<T> currentFirst = first;
			first = first.next;

			currentFirst.next = newFirst;
			newFirst = currentFirst;
		}

		first = newFirst;
	}

	/**
	 * Creates and returns a new list iterator for this list
	 * 
	 * @return The newly generated iterator
	 */
	public ListIterator<T> listIterator() {
		return new LinkedListIterator<T>();
	}

	/**
	 * Single linked list iterator (all double linked methods throw
	 * UnsupportedOperationException)
	 * 
	 * @author markus.korbel@lyit.ie
	 * @param <U>
	 *            The data type for the linked list data elements (same as T in
	 *            parent class, just passed down in listIterator() method)
	 */
	private class LinkedListIterator<U> implements ListIterator<T> {
		/**
		 * The index of the next element returned
		 */
		private int nextIndex = 0;

		/**
		 * Our current iterator position
		 */
		private Node<T> position = null;

		/**
		 * The previously visited position (for remove)
		 */
		private Node<T> previous = null;

		/**
		 * Moves past the next element in the list
		 * 
		 * @return The data element just passed
		 * @throws NoSuchElementException
		 *             If the iterator is at the end of the list
		 */
		@Override
		public T next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			previous = position; // Remember for remove
			if (position == null) {
				position = first;
			} else {
				position = position.next;
			}

			this.nextIndex++;
			return position.data;
		}

		/**
		 * Checks if there is another element in the list (is it save to call
		 * next()?)
		 * 
		 * @return True if there is another element in the list, false if we
		 *         have reached the end
		 */
		@Override
		public boolean hasNext() {
			if (position == null) {
				return first != null;
			} else {
				return position.next != null;
			}
		}

		/**
		 * Removes the element we just passed
		 * 
		 * @throws IllegalStateException
		 *             If the last operation was not next()
		 */
		@Override
		public void remove() throws IllegalStateException {
			if (previous == position) {
				throw new IllegalStateException();
			}

			if (position == first) {
				removeFirst();
			} else {
				previous.next = position.next;
			}

			position = previous;
			this.nextIndex--;
		}

		/**
		 * Change the data in the last node we passed
		 * 
		 * @throws NoSuchElementException
		 *             If the position of the iterator is either before the
		 *             first or after the last element
		 */
		@Override
		public void set(T obj) throws NoSuchElementException {
			if (position == null) {
				throw new NoSuchElementException();
			}

			position.data = obj;
		}

		/**
		 * Insert a new data element after the one just passed (note the
		 * iterator immediately passes the newly inserted element) or at the
		 * beginning of the list (if the iterator hasn't moved yet or the list
		 * is empty)
		 */
		@Override
		public void add(T obj) {
			if (position == null) {
				addFirst(obj);
				position = first;
			} else {
				Node<T> newNode = new Node<T>();
				newNode.data = obj;

				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}

			previous = position;
			this.nextIndex++;
		}

		/**
		 * Returns the index of the element that would be returned by a
		 * subsequent call to next(). (Returns list size if the list iterator is
		 * at the end of the list.)
		 * 
		 * @return The index of the element that would be returned by a
		 *         subsequent call to next, or list size if the list iterator is
		 *         at the end of the list
		 */
		@Override
		public int nextIndex() {
			return this.nextIndex;
		}

		/**
		 * Not supported
		 * 
		 * @return Exception
		 */
		@Override
		public boolean hasPrevious() {
			// Single linked list, this isn't supported
			throw new UnsupportedOperationException();
		}

		/**
		 * Not supported
		 * 
		 * @return Exception
		 */
		@Override
		public T previous() {
			// Single linked list, this isn't supported
			throw new UnsupportedOperationException();
		}

		/**
		 * Not supported
		 * 
		 * @return Exception
		 */
		@Override
		public int previousIndex() {
			// Single linked list, this isn't supported
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Single linked list node
	 * 
	 * @author markus.korbel@lyit.ie
	 * @param <V>
	 *            The data type of the stored element (same as T in parent
	 *            class, passed down)
	 */
	private class Node<V> {
		/**
		 * The data contained in the node
		 */
		public V data;

		/**
		 * The next node in the list (or NULL if we are the last node)
		 */
		public Node<V> next;
	}

}
