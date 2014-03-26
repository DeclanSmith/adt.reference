package ie.lyit.adt.tests.datastructures;

import static org.junit.Assert.*;
import ie.lyit.adt.datastructures.BinarySearchTree;
import ie.lyit.adt.datastructures.BinarySearchTreeNode;
import ie.lyit.adt.datastructures.TreeTraversalCallback;

import org.junit.Test;

/**
 * Binary search tree unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class BinarySearchTreeTests {
	/**
	 * Tree insertion tests
	 */
	@Test
	public void insertionTest() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		assertEquals(tree.getSize(), 0);
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		assertEquals(tree.getSize(), 3);
		tree.print();
	}

	/**
	 * Duplicate insertion test
	 */
	@Test(expected = IllegalStateException.class)
	public void duplicateInsertTest() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(1);
		tree.insert(1);
	}

	/**
	 * Tree search tests
	 */
	@Test
	public void searchTest() {
		BinarySearchTree<Integer> tree = createDemoBalancedTree();
		assertEquals(tree.search(99), null);
		assertNotNull(tree.search(11));
		System.out.println(tree.search(11));
		assertEquals(tree.search(11).key, new Integer(11));
	}

	/**
	 * Tree deletion tests
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deleteTest() {
		System.out.println("=====================================");
		System.out.println("Deletion tests");
		System.out.println("=====================================");
		BinarySearchTree<Integer> tree = createDemoBalancedTree();
		int size = tree.getSize();
		tree.delete(15);
		tree.print();
		System.out.println("-------------------------------------");
		tree.delete(13);
		tree.delete(14);
		tree.print();
		System.out.println("-------------------------------------");
		tree.delete(8);
		tree.print();
		System.out.println("-------------------------------------");
		tree.delete(3);
		tree.delete(2);
		tree.print();
		assertEquals(tree.getSize(), size - 6);
		tree.clear();
		tree.insert(1);
		tree.insert(2);
		tree.delete(1);
		tree.delete(99);
	}

	/**
	 * Traverse in order test
	 */
	@Test
	public void traversalTest() {
		System.out.println("=====================================");
		System.out.println("In-order traversal");
		System.out.println("=====================================");
		BinarySearchTree<Integer> tree = createDemoBalancedTree();
		tree.traverseInOrder(new TraversalConsolePrinter());
	}

	/**
	 * Tree balancing tests
	 */
	@Test
	public void balanceTest() {
		System.out.println("=====================================");
		System.out.println("Balance traversal");
		System.out.println("=====================================");
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		for (int i = 1; i <= 20; i++) {
			tree.insert(i);
		}
		tree.print();
		System.out.println("-------------------------------------");
		tree.balance();
		tree.print();
	}

	/**
	 * Tree print tests
	 */
	@Test
	public void printTest() {
		System.out.println("=====================================");
		System.out.println("Print tests");
		System.out.println("=====================================");
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		// Only root
		tree.insert(8);
		tree.print();

		// Empty tree
		tree.clear();
		tree.print();

		// Large balanced tree
		tree = createDemoBalancedTree();
		tree.print();
		System.out.println(tree.search(8));
	}

	/**
	 * Creates a large balanced tree of height=4 and size=16
	 * 
	 * @return The demo tree
	 */
	private BinarySearchTree<Integer> createDemoBalancedTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(8);
		tree.insert(4);
		tree.insert(12);
		tree.insert(6);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(5);
		tree.insert(7);
		tree.insert(10);
		tree.insert(14);
		tree.insert(9);
		tree.insert(11);
		tree.insert(13);
		tree.insert(20);
		tree.insert(15);
		return tree;
	}

	/**
	 * Tree traversal console printer
	 * 
	 * @author markus.korbel@lyit.ie
	 * 
	 */
	private class TraversalConsolePrinter implements
			TreeTraversalCallback<Integer> {
		@Override
		public void traversalCallback(BinarySearchTreeNode<Integer> node) {
			System.out.println(node.key.toString());
		}
	}
}
