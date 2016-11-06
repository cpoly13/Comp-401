package a7tests.cpoly13;

import static org.junit.Assert.*;

import org.junit.Test;

import a7.*;

public class RegionTester {

	@Test
	public void upperLeftLowerRight() {
		Coordinate a= new Coordinate(0,0);
		Coordinate b = new Coordinate(5,2);
		
		Coordinate c= new Coordinate (3,1);
		Coordinate d= new Coordinate (9,4);
		
		
		Region first= new RegionImpl(a,b);
		Region second= new RegionImpl(c,d);
		Region toCompare= new RegionImpl (c, b);
		
		try{
		Region intersect=first.intersect(second);
		
		assertEquals("Not Equal", intersect.getLeft(),toCompare.getLeft());
		
		
		
		}
		catch (NoIntersectionException e){
			fail("Shouldn't have happened");
		}
		
	}
	
	

}
