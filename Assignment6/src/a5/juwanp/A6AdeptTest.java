package a5.juwanp;

import static org.junit.Assert.fail;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "testTileAndWindowExceptions";
		test_names[1] = "testSampleExceptions";

		return test_names;
	}

	@Test
	public void testTileAndWindowExceptions() {

		Picture p = new PictureImpl(10, 15);
		try {
			p.window(11, 15);
			fail("Expected IllegalArgumentException for window width. Must be within the picture");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			p.window(10, 16);
			fail("Expected IllegalArgumentException for window height. Must be within picture.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");

		}

	}

	@Test
	public void testSampleExceptions() {
		Picture p1 = new PictureImpl(10, 15);

		try {
			p1.sample(11, 3, 3, 4);
			fail("Expected IllegalArgumentException for init x. Must be within the picture");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			p1.sample(2, 16, 3, 4);
			fail("Expected IllegalArgumentException for init y. Must be within picture.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			p1.sample(2, 3, -3, 4);
			fail("Expected IllegalArgumentException for negative dx");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			p1.sample(2, 3, 3, -4);
			fail("Expected IllegalArgumentException for negative dy");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

	}

}
