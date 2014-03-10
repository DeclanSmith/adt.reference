package ie.lyit.adt.algorithms.recursion;

/**
 * Recursive implementation of the Tower of Hanoi
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class TowerOfHanoi {
	/**
	 * Moves the specified number of discs from pole[orig] to pole[dest] using
	 * pole[temp] for temporary moves
	 * 
	 * @param n
	 *            The number of discs to move (initially the number of all
	 *            discs)
	 * @param orig
	 *            The pole from which we are moving discs away
	 * @param dest
	 *            The destination pole which should contain the discs when we
	 *            are done
	 * @param temp
	 *            The temporary pole (only used while algorithm is running,
	 *            empty before AND after!)
	 * @return A string containing the individual disc movement commands (line
	 *         by line)
	 * @throws IllegalArgumentException
	 *             If 0 or less discs are to be moved
	 */
	public static String moveDiscs(int n, char orig, char dest, char temp) {
		final String DIRECT_MOVE = "Move disk " + n + " from " + orig + " to "
				+ dest + "\n";

		// Move 0 or less discs, error!
		if (n <= 0) {
			throw new IllegalArgumentException(
					"Number of discs has to be at least 1!");
		}

		// This is our base case, moving a single disc is easy
		if (n == 1) {
			return DIRECT_MOVE;
		}

		// Move all the smaller ones on top of us to the temporary pole (so we
		// can move to destination)
		String result = moveDiscs(n - 1, orig, temp, dest);

		// We can now freely move to the destination pole
		result += DIRECT_MOVE;

		// Move all the smaller ones back on top of us (so that those also end
		// up on the destination pole)
		result += moveDiscs(n - 1, temp, dest, orig);

		// This string now contains all move instructions
		return result;
	}
}
