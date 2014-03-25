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
		// TODO Implement search
		return null;
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
		// TODO Check if the key is already contained?

		// TODO Implement insert
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
		// TODO Implement insert
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
		// TODO Implement deletion
	}

	/**
	 * Gets the minimum (left-most leaf) in a sub-tree
	 * 
	 * @param node
	 *            The node from which to start
	 * @return The minimum key of the sub-tree
	 */
	private BinarySearchTreeNode<T> findMinimum(BinarySearchTreeNode<T> node) {
		// TODO
		return null;
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
		// TODO
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
		// TODO
	}

	// ==================================================
	// BALANCING
	// ==================================================

	/**
	 * Balances the tree
	 */
	public void balance() {
		// TODO
	}

	private void balanceTree(BinarySearchTreeNode<T> root, int min, int max,
			List<BinarySearchTreeNode<T>> nodes) {
		// TODO
	}

	/**
	 * Remove all children from the specified nodes
	 * 
	 * @param nodes
	 *            The nodes to process
	 */
	private void removeChildren(List<BinarySearchTreeNode<T>> nodes) {
		// TODO
	}
}
