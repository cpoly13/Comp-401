package a5.ashish96;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "exampleTest";
		test_names[1] = "coordinateTest";
		test_names[2] = "extractTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void coordinateTest() {
		Coordinate c = new Coordinate(5,6);
		assertEquals("Coordinate Does Not Store Values", 5, c.getX());
		assertEquals("Coordinate Does Not Store Values", 6, c.getY());	
	}
	
	@Test
	public void extractTest() {
		Coordinate c = new Coordinate (1,2);
		Coordinate d = new Coordinate (8,2);
		Picture newPic = new PictureImpl(20,20);
		assertEquals("extract doesn't work", 8, newPic.extract(c, d).getWidth());
	}
}
