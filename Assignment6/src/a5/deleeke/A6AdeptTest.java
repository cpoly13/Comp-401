package a5.deleeke;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "testPictureSampleMethod";
		test_names[1] = "testWindow";

		return test_names;
	}

	@Test
	public void testPictureSampleMethod() {
		Picture pic = new PictureImpl(15, 10);
		Iterator<Pixel> picIter = pic.sample(2, 3, 3, 4);
		Pixel[] expected = { pic.getPixel(2, 3), pic.getPixel(5, 3), pic.getPixel(8, 3), pic.getPixel(11, 3),
				pic.getPixel(14, 3), pic.getPixel(2, 7), pic.getPixel(5, 7), pic.getPixel(8, 7), pic.getPixel(11, 7),
				pic.getPixel(14, 7) };
		for (Pixel e : expected) {
			assertTrue(e.equals(picIter.next()));
		}
	}

	@Test
	public void testWindow() {
		Picture pic = new PictureImpl(5, 5);
		Iterator<SubPicture> window_iter = pic.window(3, 2);
		SubPicture[] expected = { pic.extract(0, 0, 3, 2), 
								  pic.extract(1, 0, 3, 2), 
								  pic.extract(2, 0, 3, 2),
								  pic.extract(0, 1, 3, 2), 
								  pic.extract(1, 1, 3, 2), 
								  pic.extract(2, 1, 3, 2), 
								  pic.extract(0, 2, 3, 2),
								  pic.extract(1, 2, 3, 2), 
								  pic.extract(2, 2, 3, 2), 
								  pic.extract(0, 3, 3, 2), 
								  pic.extract(1, 3, 3, 2),
								  pic.extract(2, 3, 3, 2) };
		int i = 0;
		while (window_iter.hasNext()){
			SubPicture testobj = window_iter.next();
			assertTrue(testobj.getXOffset() == expected[i].getXOffset());
			assertTrue(testobj.getYOffset() == expected[i].getYOffset());
			assertTrue(testobj.getSource().equals(expected[i].getSource()));
			i++;
		}
	}

}
