package a5.ayush27;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

//import a6adept.ColorPixel;
//import a6adept.Coordinate;
//import a6adept.Picture;
//import a6adept.PictureImpl;
//import a6adept.Pixel;
import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagIteratorTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagIteratorTest() {
		Picture p = new PictureImpl(15,10);	
		Coordinate c1= new Coordinate(1,2);	
		Pixel cp = new ColorPixel(.5,.2,.1);
		p.setPixel(c1, cp);
		
		Iterator<Pixel> p_zigzagiterator = p.zigzag();
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .2);
		assertTrue(p_zigzagiterator.hasNext());
		assertTrue(p_zigzagiterator.next().getGreen() == .5);
	}
}
