package a5.amg1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "testExtract";
		test_names[1] = "testGetX";
		test_names[2] = "testGetY";
		
		return test_names;
	}
		
	@Test
	public void testExtract() {
		Coordinate c3 = new Coordinate(1,1);
		Coordinate c4 = new Coordinate(3,3);
		Picture pic= new PictureImpl(10,10);
		SubPicture subPic = pic.extract(c3, c4);
		assertEquals(3,subPic.getWidth());
	}
	
	@Test
	public void testGetX() {
		Coordinate a= new Coordinate(1,1);
		Coordinate b= new Coordinate(3,3);
		assertEquals(1,a.getX());
		assertEquals(3,b.getX());
		
	}
	
	@Test
	public void testGetY() {
		Coordinate a= new Coordinate(1,1);
		Coordinate b= new Coordinate(3,3);
		assertEquals(1,a.getY());
		assertEquals(3,b.getY());
		
	}
	
}
