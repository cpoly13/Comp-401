package a5.recline;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	/*
	 * This method needs to return an array of strings that correspond to each JUnit test in the class
	 * The autograder will be relying on this method to test my tests
	 */
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "exampleTest";
		
		return test_names;
	}
	
	/*
	 * exampleTest method shows the correct way to declare a JUnit test within the class
	 * note: @Test annotation and correct signature (public void)
	 * If you remove this example test, be sure to remove it from the array of test names in getTestNames() method
	 */
	@Test
	public void exampleTest() {
	}
}
