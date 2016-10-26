package a5.hasadi;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "exampleTest";

	return test_names;
    }

    @Test
    public void exampleTest() {

	Picture p = new PictureImpl(6, 4);
	try {
	    new SubPictureImpl(p, 7, 2, 1, 1);
	    fail("Expected IllegalArgumentException for x offset >= source width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

    }
}
