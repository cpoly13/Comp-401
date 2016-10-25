package a5.lly23;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;


//compare null values with equals equals (==)
// == looks at reference; one looks at what its pointing to 
//assertTrue and assertFalse

public class A6NoviceTest {
	Pixel r = new ColorPixel(0.5, 0, 0);
	Pixel g = new ColorPixel(0, 0.5, 0);
	Pixel b = new ColorPixel(0, 0, 0.5);
	//returns an array of strings corresponding to each JUnit test
	static public String[] getTestNames() {
		String[] test_names = new String[6];
		
		test_names[0] = "testCoordinate";
		test_names[1] = "testSetPixel";
		test_names[2] = "testGetPixel";
		test_names[3] = "testSubPictureExtract";
		test_names[4] = "testhasNext()";
		test_names[5] = "testnext()";
		
		return test_names;
	}
		
	@Test //must have @Test and signature (public void)
	//coordinate is comparing the coordinate passed through with the actual coordinates of the object
	public void testCoordinate() {
		Coordinate c = new Coordinate(2,3);

		assertEquals("X-coordinate does not match", 2, c.getX());
		assertEquals("Y-coordinate does not match", 3, c.getY());
		
		Coordinate c1 = new Coordinate(1,5);

		assertEquals("X-coordinate does not match", 1, c1.getX());
		assertEquals("Y-coordinate does not match", 5, c1.getY());
	}
	
	@Test
	//test compares 
	public void testSetPixel() {
		Picture pic = new PictureImpl(5, 5);
		Pixel p = new ColorPixel(0.6, 1.0, 0.9);
		Coordinate c = new Coordinate(4,1);
		
		pic.setPixel(c, p);
		
		assertEquals("Pixel not set right", pic.getPixel(4, 1).getRed(), p.getRed(), 0.01);
		
		Picture pic1 = new PictureImpl(12, 3);
		Pixel p1 = new ColorPixel(1.0, 0.2, 0.4);
		Coordinate c1 = new Coordinate(9,1);
		
		pic1.setPixel(c1, p1);
		
		assertEquals("Pixel not set right", pic1.getPixel(9, 1).getBlue(), p1.getBlue(), 0.001);
	}
	

	@Test
	public void testGetPixel() {
		Picture pic = new PictureImpl(5, 5);
		Pixel p = new ColorPixel(0.2, 1.0, 1.0);
		Coordinate c = new Coordinate(0, 4);
		
		pic.setPixel(c, p);
		
		assertTrue(pic.getPixel(c).equals(p));
		
		Picture pic1 = new PictureImpl(4, 10);
		Pixel p1 = new ColorPixel(0, 1.0, 1.0);
		Coordinate c1 = new Coordinate(0, 3);
		
		pic1.setPixel(c1, p1);
		
		assertTrue(pic1.getPixel(c1).equals(p1));
	}
	
	@Test
	public void testSubPictureExtract() {
		Picture source = new PictureImpl(6,6);
		SubPicture sp = new SubPictureImpl(source, 2, 1, 2, 2);

		assertEquals("Pixel at SubPicture does not match accordingly to Picture", source.getPixel(2, 1).getIntensity(), sp.getPixel(0, 0).getIntensity(), 0.01);
		assertEquals("Pixel at SubPicture does not match accordingly to Picture", source.getPixel(3, 3).getIntensity(), sp.getPixel(1, 2).getIntensity(), 0.01);

		Picture source1 = new PictureImpl(10, 11);
		SubPicture sp1 = new SubPictureImpl(source, 3, 0, 3, 4);

		assertEquals("Pixel at SubPicture does not match accordingly to Picture", source1.getPixel(4, 1).getIntensity(), sp1.getPixel(1, 1).getIntensity(), 0.01);
		assertEquals("Pixel at SubPicture does not match accordingly to Picture", source1.getPixel(4, 2).getIntensity(), sp1.getPixel(1, 2).getIntensity(), 0.01);

	}
	
	@Test
	public void testhasNext() {
		Picture source = new PictureImpl(3, 2);
		Iterator<Pixel> p = source.iterator();
		
		assertTrue(p.hasNext());
		
		Iterator<Pixel> p1 = source.iterator();
		
		assertTrue(p1.hasNext());
	}
	
	@Test
	public void testnext() {
		Picture source = new PictureImpl(3, 2);
		Iterator<Pixel> p = source.iterator();
		
		assertEquals("x and y are not within range of width and height", source.getPixel(0, 0).getIntensity(), p.next().getIntensity(), 0.01);
	
		Picture source1 = new PictureImpl(6, 12);
		Iterator<Pixel> p1 = source.iterator();
		
		assertEquals("x and y are not within range of width and height", source1.getPixel(5, 0).getIntensity(), p1.next().getIntensity(), 0.01);
	}
		
}
