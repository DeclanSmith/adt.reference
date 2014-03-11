package ie.lyit.adt.tests.algorithms.sorting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All sorting algorithm unit test suite
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ BubbleSortTests.class, SelectionSortTests.class,
		InsertionSortTests.class, MergeSortTests.class, QuickSortTests.class })
public class AllSortAlgorithmTests {
	// Groups all sort algorithm unit tests
}
