package a5.wtcarter;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "exampleTest";
		test_names[1] = "sampleTest";
		test_names[2] = "windowTest";
		test_names[3] = "tileTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void sampleTest() {
		Picture pic = new PictureImpl(12, 12);
		Iterator<Pixel> iter = pic.sample(0, 0, 3, 4);
		
		pic.setPixel(new Coordinate(0, 0), new GrayPixel(0.8));
		pic.setPixel(new Coordinate(3, 0), new GrayPixel(0.2));
		pic.setPixel(new Coordinate(3, 4), new GrayPixel(0.3));
		pic.setPixel(new Coordinate(3, 3), new GrayPixel(0.4));
		pic.setPixel(new Coordinate(6, 8), new GrayPixel(0.7));
		
		String expected = "-X>>>D>>>>:>";
		String result = "";
		
		while (iter.hasNext()) {
			result += iter.next().getChar();
		}
		
		if (!(result.equals(expected))) {
			fail("Sample Iterator did not return coordinates in expected order");
		}
	}
	
	@Test
	public void windowTest() {
		Picture pic = new PictureImpl(5, 5);
		Iterator<SubPicture> iter = pic.window(2, 2);
		
		pic.setPixel(new Coordinate(2, 1), new GrayPixel(0.8));
		
		SubPicture sub1 = iter.next();
		SubPicture sub2 = iter.next();
		SubPicture sub3 = iter.next();
		SubPicture sub4 = iter.next();
		SubPicture sub5 = iter.next();
		SubPicture sub6 = iter.next();
		
		if (sub2.getPixel(new Coordinate(1, 1)).getChar() != '-') {
			fail("Iterator did not follow expected path");
		}
		
		if (sub3.getPixel(new Coordinate(0, 1)).getChar() != '-') {
			fail("Iterator did not follow expected path");
		}
		
		if (sub6.getPixel(new Coordinate(1, 0)).getChar() != '-') {
			fail("Iterator did not follow expected path");
		}
	}
	
	@Test
	public void tileTest() {
		Picture pic = new PictureImpl(5, 5);
		Iterator<SubPicture> iter = pic.tile(2, 2);
		
		pic.setPixel(1, 1, new GrayPixel(0.8));
		pic.setPixel(2, 0, new GrayPixel(0.2));
		pic.setPixel(2, 3, new GrayPixel(0.8));
		
		SubPicture sub1 = iter.next();
		SubPicture sub2 = iter.next();
		SubPicture sub3 = iter.next();
		SubPicture sub4 = iter.next();
		
		if (sub1.getPixel(new Coordinate(1, 1)).getChar() != '-') {
			fail("Iterator did not follow expected path");
		}
		
		if (sub2.getPixel(new Coordinate(0, 0)).getChar() != 'X') {
			fail("Iterator did not follow expected path");
		}
		
		if (sub4.getPixel(new Coordinate(0, 1)).getChar() != '-') {
			fail("Iterator did not follow expected path");
		}
	}
}
