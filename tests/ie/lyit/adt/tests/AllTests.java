package ie.lyit.adt.tests;

import ie.lyit.adt.tests.algorithms.recursion.AllRecursionAlgorithmTests;
import ie.lyit.adt.tests.algorithms.searching.AllSearchAlgorithmTests;
import ie.lyit.adt.tests.algorithms.sorting.AllSortAlgorithmTests;
import ie.lyit.adt.tests.datastructures.AllDataStructureTests;
import ie.lyit.adt.tests.tools.AllToolsTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All unit tests of adt.reference tests suite
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ AllDataStructureTests.class, AllSearchAlgorithmTests.class,
		AllSortAlgorithmTests.class, AllRecursionAlgorithmTests.class,
		AllToolsTests.class })
public class AllTests {
	// Groups all sub-categories of unit tests
}
