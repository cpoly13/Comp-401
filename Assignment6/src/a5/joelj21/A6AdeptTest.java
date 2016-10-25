package a5.joelj21;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "testWindowExceptions";
		test_names[1] = "testSampleExceptions";
		
		return test_names;
	}
		
	@Test
	public void testWindowExceptions() {
		Picture p = new PictureImpl(3, 5);
		try {
			Iterator<SubPicture> window_iter = p.window(4, 5);
			fail("Expected IllegalArgumentException for window width being larger than picture width.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException.");
		}
		try {
			Iterator<SubPicture> window_iter = p.window(3, 6);
			fail("Expected IllegalArgumentException for window height being larger than picture height.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException.");
		}
		try {
			Iterator<SubPicture> window_iter = p.window(-1, 5);
			fail("Expected IllegalArgumentException for negative window width.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException.");
		}
		try {
			Iterator<SubPicture> window_iter = p.window(3, -1);
			fail("Expected IllegalArgumentException for negative window height.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException.");
		}
	}
	@Test
	public void testSampleExceptions() {
		Picture p = new PictureImpl(3, 5);
		try {
			Iterator<Pixel> sample_iter = p.sample(4, 5, 1, 1);
			fail("Expected IllegalArgumentException for initial x not being within picture.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException.");
		}
		try {
			Iterator<Pixel> sample_iter = p.sample(3, 6, 1, 1);
			fail("Expected IllegalArgumentException for initial y not being within picture.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException.");
		}
		try {
			Iterator<Pixel> sample_iter = p.sample(3, 5, -1, 1);
			fail("Expected IllegalArgumentException for negative dx.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException.");
		}
		try {
			Iterator<Pixel> sample_iter = p.sample(3, 5, 1, -1);
			fail("Expected IllegalArgumentException for negative dy.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException.");
		}
	}
}
