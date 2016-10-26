package a5.jzacj;

import static org.junit.Assert.*;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testSampleExcep";

	return test_names;
    }

    @Test
    public void testSampleExcep() {
	Picture p = new PictureImpl(5, 5);
	try {
	    p.sample(6, 5, 1, 1);
	    fail("Expected IllegalArgumentException for initial x value greater than Picture x value");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.sample(5, 6, 1, 1);
	    fail("Expected IllegalArgumentException for initial x value greater than Picture x value");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.sample(5, 5, -1, 1);
	    fail("Expected IllegalArgumentException for negative dx value");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.sample(5, 5, 1, -1);
	    fail("Expected IllegalArgumentException for negative dy value");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

    }
}
