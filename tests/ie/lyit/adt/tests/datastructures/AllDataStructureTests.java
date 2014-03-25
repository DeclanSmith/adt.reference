package ie.lyit.adt.tests.datastructures;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All data structure unit tests suite
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ QueueTests.class, StackTests.class,
		SingleLinkedListTests.class, DoubleLinkedListTests.class,
		HashTableTests.class, BinarySearchTreeTests.class })
public class AllDataStructureTests {
	// Groups all data structure unit tests
}
