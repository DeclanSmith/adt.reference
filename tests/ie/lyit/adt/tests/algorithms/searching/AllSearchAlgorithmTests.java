package ie.lyit.adt.tests.algorithms.searching;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All search algorithm unit tests suite
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ BinarySearchTests.class, LinearSearchTests.class,
		RecursiveBinarySearchTests.class })
public class AllSearchAlgorithmTests {
	// Groups all search algorithm unit tests
}
