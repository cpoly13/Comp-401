package a5.abbatude;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

//import a6adept.PictureImpl;
//import a6adept.SubPicture;
import a6jedi.Pixel;
import a6jedi.PictureImpl;
import a6jedi.Picture;


public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}
	

		
	@Test
	public void zigzagTest() {
		
		Picture p = new PictureImpl(3,3);
	
		Iterator<Pixel> z = p.zigzag();
		assertEquals(p.getPixel(0, 0), z.next());
		assertEquals(p.getPixel(1, 0), z.next());
		assertEquals(p.getPixel(0, 1), z.next());
		assertEquals(p.getPixel(0, 2), z.next());
		assertEquals(p.getPixel(1, 1), z.next());
		assertEquals(p.getPixel(2, 0), z.next());
		assertEquals(p.getPixel(2, 1), z.next());
		assertEquals(p.getPixel(1, 2), z.next());
		assertEquals(p.getPixel(2, 2), z.next());
	}
}
