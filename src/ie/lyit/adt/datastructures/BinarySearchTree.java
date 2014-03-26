package ie.lyit.adt.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary search tree data structure
 * 
 * @author markus.korbel@lyit.ie
 * 
 * @param <T>
 *            The data structure type of the keys stored in the tree
 */
public class BinarySearchTree<T extends Comparable<T>> {
	// ==================================================
	// CLASS MEMBERS
	// ==================================================

	/**
	 * The root of the tree
	 */
	private BinarySearchTreeNode<T> root = null;

	/**
	 * The size of the tree
	 */
	private int size = 0;

	// ==================================================
	// BASIC TREE METHODS
	// ==================================================

	/**
	 * Gets the size of the tree
	 * 
	 * @return The size of the tree
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Deletes all nodes and edges
	 */
	public void clear() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * Prints the entire tree
	 */
	public void print() {
		if (this.root != null) {
			this.root.printTree();
		} else {
			System.out.println("Tree is empty!");
		}
	}

	// ==================================================
	// SEARCH
	// ==================================================

	/**
	 * Searches for a key in the tree
	 * 
	 * @param key
	 *            The key to search for
	 * @return The node containing the key or NULL if the key is contained in
	 *         the tree
	 */
	public BinarySearchTreeNode<T> search(T key) {
		return search(this.root, key);
	}

	/**
	 * Searches for a key in the sub-tree starting at node
	 * 
	 * @param node
	 *            The node from which to start searching
	 * @param key
	 *            The key to search for
	 * @return The node containing the key or NULL if the key is contained in
	 *         the tree
	 */
	private BinarySearchTreeNode<T> search(BinarySearchTreeNode<T> node, T key) {
		if (node == null || node.key.compareTo(key) == 0) {
			return node;
		} else if (key.compareTo(node.key) < 0) {
			return search(node.left, key);
		} else {
			return search(node.right, key);
		}
	}

	// ==================================================
	// INSERTION
	// ==================================================

	/**
	 * Insert a new key into the tree
	 * 
	 * @param key
	 *            The key to insert
	 */
	public void insert(T key) {
		if (search(key) != null) {
			throw new IllegalStateException("No duplicate keys allowed!");
		}

		if (this.root != null) {
			insert(this.root, key);
		} else {
			this.root = new BinarySearchTreeNode<T>(key, null);
		}

		this.size++;
	}

	/**
	 * Recursive tree insert method
	 * 
	 * @param node
	 *            The current node we are considering as a parent for the new
	 *            key
	 * @param key
	 *            The key to insert
	 */
	private void insert(BinarySearchTreeNode<T> node, T key) {
		if (key.compareTo(node.key) < 0) {
			if (node.left == null) {
				node.left = new BinarySearchTreeNode<T>(key, node);
			} else {
				insert(node.left, key);
			}
		} else {
			if (node.right == null) {
				node.right = new BinarySearchTreeNode<T>(key, node);
			} else {
				insert(node.right, key);
			}
		}
	}

	// ==================================================
	// DELETION
	// ==================================================

	/**
	 * Delete the specified key from the tree
	 * 
	 * @param key
	 *            The key to delete
	 */
	public void delete(T key) {
		delete(this.root, key);
		this.size--;
	}

	/**
	 * Recursive deletion method
	 * 
	 * @param node
	 *            The current node (call with root initially!) (first during
	 *            search phase, then the node containing the key to delete)
	 * @param key
	 *            The key to delete
	 */
	private void delete(BinarySearchTreeNode<T> node, T key) {
		if (node == null) {
			throw new IllegalArgumentException("Key not found!");
		}

		if (key.compareTo(node.key) < 0) {
			delete(node.left, key);
		} else if (key.compareTo(node.key) > 0) {
			delete(node.right, key);
		} else {
			// We have found the node
			if (node.left != null && node.right != null) {
				// Two children, do a in-order successor deletion
				BinarySearchTreeNode<T> successor = findMinimum(node.right);
				node.key = successor.key;
				delete(successor, successor.key);
			} else if (node.left != null) {
				// Only left child, skip over us
				replaceInParent(node, node.left);
			} else if (node.right != null) {
				// Only right child, skip over us
				replaceInParent(node, node.right);
			} else {
				// No children, just update the parent
				replaceInParent(node, null);
			}
		}
	}

	/**
	 * Gets the minimum (left-most leaf) in a sub-tree
	 * 
	 * @param node
	 *            The node from which to start
	 * @return The minimum key of the sub-tree
	 */
	private BinarySearchTreeNode<T> findMinimum(BinarySearchTreeNode<T> node) {
		BinarySearchTreeNode<T> currentNode = node;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}

		return currentNode;
	}

	/**
	 * Replace a node with a new one in the first one's parent
	 * 
	 * @param node
	 *            The node to replace
	 * @param newNode
	 *            The new node to replace with
	 */
	private void replaceInParent(BinarySearchTreeNode<T> node,
			BinarySearchTreeNode<T> newNode) {
		if (node.parent != null) {
			if (node == node.parent.left) {
				node.parent.left = newNode;
			} else {
				node.parent.right = newNode;
			}
		}

		if (newNode != null) {
			newNode.parent = node.parent;
		}
	}

	// ==================================================
	// IN-ORDER TRAVERSAL
	// ==================================================

	/**
	 * Traverse the tree in-order
	 * 
	 * @param callback
	 *            The callback to use when visiting a node
	 */
	public void traverseInOrder(TreeTraversalCallback<T> callback) {
		traverseInOrder(this.root, callback);
	}

	/**
	 * Recursive in-order tree traversal
	 * 
	 * @param node
	 *            The current node we are visiting
	 * 
	 * @param callback
	 *            The callback to use when visiting a node
	 */
	private void traverseInOrder(BinarySearchTreeNode<T> node,
			TreeTraversalCallback<T> callback) {
		if (node != null) {
			traverseInOrder(node.left, callback);
			callback.traversalCallback(node);
			traverseInOrder(node.right, callback);
		}
	}

	// ==================================================
	// BALANCING
	// ==================================================

	/**
	 * Balances the tree
	 */
	public void balance() {
		List<T> keys = new ArrayList<T>();
		traverseInOrder(new TraversalListAdder(keys));
		this.root = null;
		balanceTree(0, keys.size() - 1, keys);
	}

	/**
	 * Performs a recursive balanced tree rebuild using the sorted list of node
	 * keys
	 * 
	 * @param min
	 *            The current lower bound
	 * @param max
	 *            The current upper bound
	 * @param keys
	 *            The keys to re-insert
	 */
	private void balanceTree(int min, int max, List<T> keys) {
		if (min <= max) {
			int middle = (int) Math.ceil((min + max) / 2.0);
			insert(keys.get(middle));
			balanceTree(min, middle - 1, keys);
			balanceTree(middle + 1, max, keys);
		}
	}

	/**
	 * Tree traversal callback that adds node keys into an array list
	 * 
	 * @author markus.korbel@lyit.ie
	 * 
	 */
	private class TraversalListAdder implements TreeTraversalCallback<T> {
		/**
		 * The list of keys to populate
		 */
		private List<T> keys;

		/**
		 * Constructor
		 * 
		 * @param keys
		 *            The key list
		 */
		public TraversalListAdder(List<T> keys) {
			this.keys = keys;
		}

		/**
		 * Callback method receiving node references during traversal
		 */
		@Override
		public void traversalCallback(BinarySearchTreeNode<T> node) {
			keys.add(node.key);
		}

	}
}
