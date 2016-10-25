package a5.jaime1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;
import a6novice.Coordinate;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "testCoordinate";
		
		return test_names;
	}
		
	@Test //test Coordinate values
	public void testCoordinate(){
		Coordinate a = new Coordinate(8, 3);
		Coordinate b = new Coordinate(7, 2);
		Coordinate c = new Coordinate(4, 1);
		
		assertEquals("Result from getX() does not match source coordinate",
				8, a.getX());
		assertEquals("Result from getX() does not match source coordinate",
				7, b.getX());
		assertEquals("Result from getX() does not match source coordinate",
				4, c.getX());		
		
	}
}
