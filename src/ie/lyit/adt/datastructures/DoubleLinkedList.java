package ie.lyit.adt.datastructures;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Double linked list
 * 
 * @author markus.korbel@lyit.ie
 * 
 * @param <T>
 *            The data type for the linked list data elements
 */
public class DoubleLinkedList<T> {
	/**
	 * The first node in the list (or NULL if the list is empty)
	 */
	private Node<T> first;

	/**
	 * The last node in the list (or NULL if the list is empty)
	 */
	private Node<T> last;

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
	 * Retrieves the last data element in the list (like Peek in stack)
	 * 
	 * @return The last data element
	 * @throws NoSuchElementException
	 *             If the list is empty
	 */
	public T getLast() throws NoSuchElementException {
		if (last == null) {
			throw new NoSuchElementException();
		}
		return last.data;
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
		newNode.previous = null;

		if (first != null) {
			first.previous = newNode;
		}

		first = newNode;
		if (last == null) {
			last = newNode;
		}
	}

	/**
	 * Adds a data element at the end of the list (leaving existing element
	 * untouched)
	 * 
	 * @param data
	 *            The data element to store
	 */
	public void addLast(T data) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		newNode.next = null;
		newNode.previous = last;

		if (last != null) {
			last.next = newNode;
		}

		last = newNode;
		if (first == null) {
			first = newNode;
		}
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

		T data = first.data;
		if (first.next != null) {
			first.next.previous = null;
		}
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}

	/**
	 * Removes and returns the last data element in the list
	 * 
	 * @return The data element retrieved before removing it
	 * @throws NoSuchElementException
	 *             If the list is empty
	 */
	public T removeLast() throws NoSuchElementException {
		if (last == null) {
			throw new NoSuchElementException();
		}

		T data = last.data;
		if (last.previous != null) {
			last.previous.next = null;
		}
		last = last.previous;
		if (last == null) {
			first = null;
		}
		return data;
	}

	/**
	 * Reverses the list
	 */
	public void reverse() {
		Node<T> newFirst = null;
		while (first != null) {
			// Save current first and remove it from the old list
			Node<T> currentFirst = first;
			first = first.next;

			// Once update the last pointer
			if (newFirst == null) {
				last = currentFirst;
			}

			// Insert into new list and "rewire"
			currentFirst.next = newFirst;
			newFirst = currentFirst;
			newFirst.previous = null;
			if (newFirst.next != null) {
				newFirst.next.previous = newFirst;
			}
		}

		first = newFirst;
	}

	/**
	 * Double linked list iterator
	 * 
	 * @author markus.korbel@lyit.ie
	 * @param <U>
	 *            The data type for the linked list data elements (same as T in
	 *            parent class, just passed down in listIterator() method)
	 */
	private class LinkedListIterator<U> implements ListIterator<T> {
		/**
		 * The index of the next element returned (subtract 1 for previous
		 * index)
		 */
		private int nextIndex = 0;

		/**
		 * The current iterator position
		 */
		private Node<T> position = null;

		/**
		 * Was the last operation a call to next()? If not remove() is
		 * forbidden!
		 */
		private boolean wasLastCallNext = false;

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

			wasLastCallNext = true;
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
			if (!this.wasLastCallNext) {
				throw new IllegalStateException();
			}

			if (position == first) {
				removeFirst();
			} else if (position == last) {
				removeLast();
			} else {
				// Remove in the middle
				position.previous.next = position.next;
				position.next.previous = position.previous;
			}

			position = position.previous;
			this.nextIndex--;
			this.wasLastCallNext = false;
		}

		/**
		 * Change the data in the last node we passed
		 * 
		 * @throws NoSuchElementException
		 *             If the position of the iterator is either before the
		 *             first or after the last element
		 */
		@Override
		public void set(T data) throws NoSuchElementException {
			if (position == null) {
				throw new NoSuchElementException();
			}

			position.data = data;
		}

		/**
		 * Insert a new data element after the one just passed (note the
		 * iterator immediately passes the newly inserted element) or at the
		 * beginning of the list (if the iterator hasn't moved yet or the list
		 * is empty)
		 */
		@Override
		public void add(T data) {
			this.wasLastCallNext = false;

			if (position == null) {
				addFirst(data);
				position = first;
			} else if (!hasNext()) {
				addLast(data);
				position = last;
			} else {
				// Add in the middle
				Node<T> newNode = new Node<T>();
				newNode.data = data;

				newNode.next = position.next;
				newNode.previous = position;
				position.next.previous = newNode;
				position.next = newNode;
				position = newNode;
			}

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
		 * Checks if there is another element in the list before us (is it save
		 * to call previous()?)
		 * 
		 * @return True if there is another element in the list before us, false
		 *         if we have reached the beginning (or are still there)
		 */
		@Override
		public boolean hasPrevious() {
			return position != null;
		}

		/**
		 * Moves back one element in the list
		 * 
		 * @return The data element just passed backwards
		 * @throws NoSuchElementException
		 *             If the iterator is at the beginning of the list
		 */
		@Override
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}

			this.wasLastCallNext = false;
			T data = position.data;
			position = position.previous;

			this.nextIndex--;
			return data;
		}

		/**
		 * Returns the index of the element we just passed (when moving
		 * forwards), or the next in line (if moving backwards), or -1 if we are
		 * at the beginning of the list
		 */
		@Override
		public int previousIndex() {
			if (position == null) {
				return -1;
			}

			return this.nextIndex - 1;
		}
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
	 * Double linked list node
	 * 
	 * @author markus.korbel@lyit.ie
	 * 
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

		/**
		 * The previous node in the list (or NULL if we are the first node)
		 */
		public Node<V> previous;
	}
}
