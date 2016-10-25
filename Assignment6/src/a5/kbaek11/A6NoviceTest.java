package a5.kbaek11;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		
		return new String[] {"testCoordinate", "testSetPixel", "testExtract"};
	}
		
	
	@Test
	public void testCoordinate() {
		Coordinate c = new Coordinate(4,5);
		assertEquals("Coordinate x value is not correct",
			4, c.getX());
		assertEquals("Coordinate y value is not correct",
			5, c.getY());
	}
	
	@Test
	public void testSetPixel() {
		ColorPixel cp = new ColorPixel(0.7, 0.5, 0.4);
		Coordinate c = new Coordinate(1,1);
		Picture pic = new PictureImpl(2,2);
		pic.setPixel(c, cp);
		assertEquals(pic.getPixel(c), cp);
		
	}
	
	@Test
	public void testExtract() {
		Coordinate cornerA = new Coordinate(2,2);
		Coordinate cornerB = new Coordinate(1,5);
		PictureImpl pic = new PictureImpl(6,6);
		SubPicture subPic = pic.extract(cornerA, cornerB);
		assertEquals(subPic.getHeight(), 4);
	}
	
	
	
	
}
