package a5.jfisch;

import java.util.Iterator;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

import a6jedi.*;

public class A6JediTest {

	static public String[] getTestNames() {
		String[] test_Names = { "exampleTest", "windowIteratorTest" };

		return test_Names;
	}

	@Test
	public void exampleTest() {
	}

	// Test if window_iterator considers errors when needed
	@Test
	public void windowIteratorTest() {
		Picture a = new PictureImpl(15, 10);
		Iterator<SubPicture> window_iter = a.window(3, 2);
		while (window_iter.hasNext()) {
			window_iter.next();
		}
		try {
			window_iter.next();
			fail("Expected java.util.NoSuchElementException");
		} catch (java.util.NoSuchElementException e) {
		}
	}
}