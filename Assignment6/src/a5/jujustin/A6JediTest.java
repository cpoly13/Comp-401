package a5.jujustin;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagIteratorTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagIteratorTest() {
		

		Pixel green = new ColorPixel(0,1,0);
		Pixel blue = new ColorPixel(0,0,1);
		Pixel red = new ColorPixel(1,0,0);
		
		Picture p = new PictureImpl(3,3);
		Picture check = new PictureImpl(3,3);
		
		//normal picture
		p.setPixel(0,0, green);
		p.setPixel(1,0, green);
		p.setPixel(2,0, green);
		p.setPixel(0,1, blue);
		p.setPixel(1,1, blue);
		p.setPixel(2,1, blue);
		p.setPixel(0,2, red);
		p.setPixel(1,2, red);
		p.setPixel(2,2, red);
		
		//zigzag picture corrected
		check.setPixel(0,0, green);
		check.setPixel(1,0, green);
		check.setPixel(2,0, blue);
		check.setPixel(0,1, red);
		check.setPixel(1,1, blue);
		check.setPixel(2,1, green);
		check.setPixel(0,2, blue);
		check.setPixel(1,2, red);
		check.setPixel(2,2, red);
		
		Iterator<Pixel> pic = p.zigzag();
		Iterator<Pixel> pic2 = check.iterator();
		
		//check correct pic vs zigzag pic
		for(int x = 0; x < 9; x++)
		{
		assertEquals("zigzag test 1",
				pic.next(),  pic2.next());
		assertEquals("zigzag test 2",
				pic.hasNext(), pic2.hasNext());
		}
		
		//check out of bounds boolean
		assertEquals("Out of Bounds check 1",
				pic.hasNext(), pic2.hasNext());
		assertEquals("Out of Bounds check 2",
				pic.hasNext(), pic2.hasNext());

		
		
		
		
	}
}
