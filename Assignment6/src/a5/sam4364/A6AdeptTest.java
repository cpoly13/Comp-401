package a5.sam4364;

import static org.junit.Assert.fail;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;

public class A6AdeptTest {

    static public String[] getTestNames() {

	// test_names[0] = "sampleIteratorTest";
	// test_names[1] = "parameterValidation";

	// return test_names;

	return new String[] { "sampleIteratorTest", "parameterValidation" };
    }

    @Test
    public void sampleIteratorTest() {
	Picture p = new PictureImpl(15, 10);
	try {
	    p.sample(2, 3, 3, 4);
	} catch (IllegalArgumentException e) {
	    fail("X out of bounds error");
	}
    }

    @Test
    public void parameterValidation() {

	Picture p = new PictureImpl(15, 10);
	try {
	    p.sample(2, 3, -1, -2);
	    fail("Expected IllegalArgumentException for x offset >= source width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}
    }

}
