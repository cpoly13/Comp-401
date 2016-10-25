package a5.lly23;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;
import a6jedi.ColorPixel;

public class A6JediTest {
	Pixel r = new ColorPixel(0.5, 0, 0);
	Pixel g = new ColorPixel(0, 0.5, 0);
	Pixel b = new ColorPixel(0, 0, 0.5);
	
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "testzigzag";
		
		return test_names;
	}
	
	@Test
	public void testzigzag() {
		Picture source = new PictureImpl(2, 2);
		Iterator<Pixel> zigZagPic = source.zigzag();
		
		source.setPixel(0, 0, r);
		source.setPixel(1, 0, g);
		source.setPixel(0, 1, b);
		source.setPixel(1, 1, r);
		
		assertTrue(source.getPixel(0, 0).equals(zigZagPic.next()));
		assertTrue(source.getPixel(1, 0).equals(zigZagPic.next()));
		assertTrue(source.getPixel(0, 1).equals(zigZagPic.next()));
		assertTrue(source.getPixel(1, 1).equals(zigZagPic.next()));
	}
}
