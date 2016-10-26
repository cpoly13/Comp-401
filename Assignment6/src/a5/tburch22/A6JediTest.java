package a5.tburch22;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    // final pixel values for the purpose of testing methods that retrieve
    // pixels
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);

    // method with an output of strings that represent the names of the tests in
    // the class
    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testZigZagIterator";

	return test_names;
    }

    // Test to check whether the zig zag iterator works as specified by the
    // description
    @Test
    public void testZigZagIterator() {
	Picture pic1 = new PictureImpl(5, 5);

	// loop to set odd diagonal pixels to red and even to green
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		if ((i + j) % 2 == 0)
		    pic1.setPixel(j, i, RED);
		else
		    pic1.setPixel(j, i, GREEN);
	    }
	}

	/*
	 * all of the tests for the iterator. Works by using a call to next()
	 * and comparing with the expected result. A blank call to next is used
	 * to move the iterator along between tests
	 */
	Iterator<Pixel> zigIter = pic1.zigzag();

	assertEquals("Pixel retrieved by iterator does not match the next expected pixel in" + "the zigzag pattern",
		RED, zigIter.next());
	assertEquals("Pixel retrieved by iterator does not match the next expected pixel in" + "the zigzag pattern",
		GREEN, zigIter.next());

	zigIter.next();

	assertEquals("Pixel retrieved by iterator does not match the next expected pixel in" + "the zigzag pattern",
		RED, zigIter.next());

	zigIter.next();
	zigIter.next();

	assertEquals("Pixel retrieved by iterator does not match the next expected pixel in" + "the zigzag pattern",
		GREEN, zigIter.next());

	for (int i = 0; i < 17; i++) {
	    zigIter.next();
	}

	assertEquals("Pixel retrieved by iterator does not match the next expected pixel in" + "the zigzag pattern",
		RED, zigIter.next());

    }
}
