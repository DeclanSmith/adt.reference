package ie.lyit.adt.tests.algorithms.recursion;

import static org.junit.Assert.assertEquals;
import ie.lyit.adt.algorithms.recursion.TowerOfHanoi;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Tower of Hanoi algorithm unit tests
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
public class TowerOfHanoiTests {
	/**
	 * Test for moving a single disc
	 */
	@Test
	public void singleDiscTest() {
		String singleMove = TowerOfHanoi.moveDiscs(1, 'A', 'B', 'C');
		assertEquals("Move disk 1 from A to B\n", singleMove);
	}

	/**
	 * Test for moving two discs
	 */
	@Test
	public void twoDiscTest() {
		String twoDiscMoves = TowerOfHanoi.moveDiscs(2, 'A', 'B', 'C');
		String solution = "Move disk 1 from A to C\nMove disk 2 from A to B\nMove disk 1 from C to B\n";
		assertEquals(solution, twoDiscMoves);
	}

	/**
	 * Test for moving four discs
	 */
	@Test
	public void fourDiscTest() {
		String fourDiscMoves = TowerOfHanoi.moveDiscs(4, 'A', 'B', 'C');
		System.out.println("============= 4 disc move commands =============");
		System.out.println(fourDiscMoves);
		System.out.println("================================================");
		String solution = "Move disk 1 from A to C\nMove disk 2 from A to B\nMove disk 1 from C to B\nMove disk 3 from A to C\nMove disk 1 from B to A\nMove disk 2 from B to C\nMove disk 1 from A to C\nMove disk 4 from A to B\nMove disk 1 from C to B\nMove disk 2 from C to A\nMove disk 1 from B to A\nMove disk 3 from C to B\nMove disk 1 from A to C\nMove disk 2 from A to B\nMove disk 1 from C to B\n";
		assertEquals(solution, fourDiscMoves);
	}

	/**
	 * Tests if the complexity 0(2^n -1) is correct
	 */
	@Test
	@Ignore
	public void exponentialTest() {
		int singleMovesFormula = ((int) Math.pow(2, 1)) - 1;
		int singleMovesCounted = TowerOfHanoi.moveDiscs(1, 'A', 'B', 'C')
				.split("Move", -1).length - 1;
		assertEquals(singleMovesFormula, singleMovesCounted);
		System.out.println("One disc requires moves: " + singleMovesFormula);

		int twoMovesFormula = ((int) Math.pow(2, 2)) - 1;
		int twoMovesCounted = TowerOfHanoi.moveDiscs(2, 'A', 'B', 'C').split(
				"Move", -1).length - 1;
		assertEquals(twoMovesFormula, twoMovesCounted);
		System.out.println("Two disc requires moves: " + twoMovesFormula);

		int fourMovesFormula = ((int) Math.pow(2, 4)) - 1;
		int fourMovesCounted = TowerOfHanoi.moveDiscs(4, 'A', 'B', 'C').split(
				"Move", -1).length - 1;
		assertEquals(fourMovesFormula, fourMovesCounted);
		System.out.println("Four disc requires moves: " + fourMovesFormula);

		int tenMovesFormula = ((int) Math.pow(2, 10)) - 1;
		int tenMovesCounted = TowerOfHanoi.moveDiscs(10, 'A', 'B', 'C').split(
				"Move", -1).length - 1;
		assertEquals(tenMovesFormula, tenMovesCounted);
		System.out.println("Ten disc requires moves: " + tenMovesFormula);

		int twentyMovesFormula = ((int) Math.pow(2, 20)) - 1;
		int twentyMovesCounted = TowerOfHanoi.moveDiscs(20, 'A', 'B', 'C')
				.split("Move", -1).length - 1;
		assertEquals(twentyMovesFormula, twentyMovesCounted);
		System.out.println("Twenty disc requires moves: " + twentyMovesFormula);

		System.out.println("64 discs would require moves: "
				+ ((long)(Math.pow(2, 64) - 1)));
	}

	/**
	 * Tests if Java can handle 30 disc moves (it can not, enable only when
	 * checking this case, this test takes more than 30 seconds on my Core-I7 to
	 * complete)
	 */
	@Test(expected = OutOfMemoryError.class)
	@Ignore
	public void thirtyTest() {
		String thirty = TowerOfHanoi.moveDiscs(30, 'A', 'B', 'C');
		System.out.println(thirty);
	}

	/**
	 * Tests what happens if we instruct a move of 0 discs
	 */
	@Test(expected = IllegalArgumentException.class)
	public void zeroDiscExceptionTest() {
		TowerOfHanoi.moveDiscs(0, 'A', 'B', 'C');
	}

	/**
	 * Default constructor test
	 */
	@Test
	public void defaultConstructorTest() {
		// Static tool class still has default constructor (to get 100% coverage
		// we need to test it too)
		new TowerOfHanoi();
	}
}
