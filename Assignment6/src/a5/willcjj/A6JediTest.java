package a5.willcjj;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

//import a6adept.Pixel;
//import a6adept.GrayPixel;
//import a6adept.Picture;
//import a6adept.PictureImpl;
import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "exampleTest";
		test_names[1] = "zigzagTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void zigzagTest() {
		double intensity[] = {0.0,0.01,0.02,0.03,0.04,0.05,0.06,0.07,0.08,0.09,0.10,0.11,0.12,0.13,0.14,0.15};
		
		Picture pic = new PictureImpl (4,4);
		pic.setPixel(0, 0, new GrayPixel(0.0));
		pic.setPixel(1, 0, new GrayPixel(0.01));
		pic.setPixel(0, 1, new GrayPixel(0.02));
		pic.setPixel(0, 2, new GrayPixel(0.03));
		pic.setPixel(1, 1, new GrayPixel(0.04));
		pic.setPixel(2, 0, new GrayPixel(0.05));
		pic.setPixel(3, 0, new GrayPixel(0.06));
		pic.setPixel(2, 1, new GrayPixel(0.07));
		pic.setPixel(1, 2, new GrayPixel(0.08));
		pic.setPixel(0, 3, new GrayPixel(0.09));
		pic.setPixel(1, 3, new GrayPixel(0.10));
		pic.setPixel(2, 2, new GrayPixel(0.11));
		pic.setPixel(3, 1, new GrayPixel(0.12));
		pic.setPixel(3, 2, new GrayPixel(0.13));
		pic.setPixel(2, 3, new GrayPixel(0.14));
		pic.setPixel(3, 3, new GrayPixel(0.15));
		
		Iterator<Pixel> zigzag_iter = pic.zigzag();
		for (int i = 0; i < 16; i++) {
			Pixel temp = zigzag_iter.next();
			assertEquals("Error", temp.getIntensity(), intensity[i], 0.001);

		}
		assertEquals("Zigzag", zigzag_iter.hasNext(),false);
	}
}
