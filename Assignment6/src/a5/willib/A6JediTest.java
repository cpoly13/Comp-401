package a5.willib;

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

	// Test if iterator_window checks errors when needed
	@Test
	public void windowIteratorTest() {
		Picture a = new PictureImpl(15, 10);
		Iterator<SubPicture> iterator_window = a.window(3, 2);
		while (iterator_window.hasNext()) {
			iterator_window.next();
		}
		try {
			iterator_window.next();
			fail("Expected java.util.NoSuchElementException");
		} catch (java.util.NoSuchElementException e) {
		}
	}
}