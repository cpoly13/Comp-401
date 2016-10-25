package a5.jmoore98;

import static org.junit.Assert.*;
//import java.util.Iterator;
import org.junit.Test;
import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = {"exampleTest", "coordinateConstructorTest", "coordinateGetPixelTest"};
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test	//Test to make sure coordinate sets at correct inputs
	public void coordinateConstructorTest() {
		Coordinate c = new Coordinate(1, 1);
		
		assertEquals("X-Value does not match value given to constructor", 1, c.getX());
		assertEquals("Y-Value does not match value given to constructor", 1, c.getY());
	}
	
	@Test	//Test the overloaded getPixel method with coordinate as parameter
	public void coordinateGetPixelTest() {
		Coordinate c = new Coordinate(1, 1);
		Pixel pix = new ColorPixel(1, 0, 0);
		Picture p = new PictureImpl(3, 3);
		p.setPixel(c, pix);
		assertEquals("Pixel not set at correct coordinate", pix, p.getPixel(c));
	}
}
