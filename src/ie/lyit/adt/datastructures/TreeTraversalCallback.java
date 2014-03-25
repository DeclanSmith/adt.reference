package ie.lyit.adt.datastructures;

/**
 * Tree traversal callback interface
 * 
 * @author markus.korbel@lyit.ie
 * 
 * @param <T>
 *            The type used for tree keys
 */
public interface TreeTraversalCallback<T extends Comparable<T>> {
	/**
	 * A node was visited, here is your callback!
	 * 
	 * @param node
	 *            The node that was visited
	 */
	public void traversalCallback(BinarySearchTreeNode<T> node);
}
