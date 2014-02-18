package ie.lyit.adt.tests.tools;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tools unit tests suite
 * 
 * @author markus.korbel@lyit.ie
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ RandomArrayTests.class, RandomStringTests.class,
		ArraySortingCheckTests.class })
public class AllToolsTests {
	// Groups all tools unit tests
}
