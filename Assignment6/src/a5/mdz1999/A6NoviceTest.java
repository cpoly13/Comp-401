package a5.mdz1999;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "coordinateConstructorTest";
		test_names[1] = "coordinateGetXTest";
		test_names[2] = "coordinateGetYTest";
		
		return test_names;
	}
		
	@Test
	public void coordinateConstructorTest() {
		Coordinate c = new Coordinate(3,5);
		Assert.assertEquals(3, c.getX(), 0.01);
		Assert.assertEquals(5, c.getY(), 0.01);
	}
	
	@Test
	public void coordinateGetXTest() {
		Coordinate c = new Coordinate(3,5);
		Assert.assertEquals(3, c.getX(), 0.01);
		c = new Coordinate(-3,5);
		Assert.assertEquals(-3, c.getX(), 0.01);
		c = new Coordinate(0,5);
		Assert.assertEquals(0, c.getX(), 0.01);
	}
	
	@Test
	public void coordinateGetYTest() {
		Coordinate c = new Coordinate(3,5);
		Assert.assertEquals(5, c.getY(), 0.01);
		c = new Coordinate(3,-5);
		Assert.assertEquals(-5, c.getY(), 0.01);
		c = new Coordinate(3,0);
		Assert.assertEquals(0, c.getY(), 0.01);
	}
}
