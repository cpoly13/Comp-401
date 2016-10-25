package a5.sjs4025;

//Contributors: Quentin Hawkins & Krishan Patel

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "exampleTest";
		test_names[1] = "testIteratorPixel";
		test_names[2] = "testSetAndGetPixel";
		test_names[3] = "testExtract";
		
		return test_names;
	}
	
	@Test
	public void exampleTest() {
	}
		
	@Test
	public void testIteratorPixel() {
		Picture p = new PictureImpl(4, 4);
		Iterator<Pixel> iterPixel = p.iterator();
		assertEquals("hasNext Error", iterPixel.hasNext(), true);
		assertEquals("Wrong Pixel Return", iterPixel.next(), p.getPixel(0, 0));
	}
	
	@Test
	public void testSetAndGetPixel() {
		Picture p = new PictureImpl(4, 4);
		Pixel a = new ColorPixel(1, 1, 1);
		p.setPixel(0, 0, a);
		assertEquals(a, p.getPixel(0, 0));
	}	
	
	@Test
	public void testExtract() {
		Picture p = new PictureImpl(5, 5);
		Coordinate coord1 = new Coordinate(1, 1);
		Coordinate coord2 = new Coordinate(4, 4);
		SubPicture pic = p.extract(coord1, coord2);
		assertEquals(4, pic.getWidth());
	}
}
