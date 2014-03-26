package ie.lyit.adt.datastructures;

/**
 * Binary search tree node
 * 
 * @author markus.korbel@lyit.ie
 * 
 * @param <T>
 *            The data structure type of the keys stored in the tree
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {
	/**
	 * Creates a new binary search tree node
	 * 
	 * @param key
	 *            The key to store in the new node
	 * @param parent
	 *            The parent of the new node
	 */
	public BinarySearchTreeNode(T key, BinarySearchTreeNode<T> parent) {
		this.key = key;
		this.parent = parent;
	}

	/**
	 * The key stored in the node
	 */
	public T key;

	/**
	 * The left child of the node
	 */
	public BinarySearchTreeNode<T> left = null;

	/**
	 * The right child of the node
	 */
	public BinarySearchTreeNode<T> right = null;

	/**
	 * The parent of the node
	 */
	public BinarySearchTreeNode<T> parent;

	/**
	 * Overridden toString method (makes debugging easier)
	 */
	@Override
	public String toString() {
		return "BinarySearchTreeNode [key=" + key + ", leftKey="
				+ (left != null ? left.key : "null") + ", rightKey="
				+ (right != null ? right.key : "null") + "]";
	}

	/**
	 * Prints the sub-tree starting at this node
	 */
	public void printTree() {
		if (right != null) {
			right.printTree(true, "");
		}
		System.out.println(key.toString());
		if (left != null) {
			left.printTree(false, "");
		}
	}

	/**
	 * Recursive tree printer method
	 * 
	 * @param isRight
	 *            Is this node the right child of the parent?
	 * @param indent
	 *            The current indentation string (grows as we go deeper)
	 */
	private void printTree(boolean isRight, String indent) {
		if (right != null) {
			right.printTree(true, indent + (isRight ? "        " : " |      "));
		}
		System.out.print(indent);
		if (isRight) {
			System.out.print(" /");
		} else {
			System.out.print(" \\");
		}
		System.out.print("----- ");
		System.out.println(key.toString());
		if (left != null) {
			left.printTree(false, indent + (isRight ? " |      " : "        "));
		}
	}
}
