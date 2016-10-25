package a5.ericaly;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


import a6novice.*;



public class A6NoviceTest {

		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "a6NoviceTestOne";
		test_names[1] = "a6NoviceTestTwo";	
		test_names[2] = "a6NoviceTestThree";
		return test_names;
	}
		
	@Test
	public void a6NoviceTestOne() {
		Picture picture = new PictureImpl(5,4);
		try{
			SubPicture SubOne = new SubPictureImpl(picture, -1,2,2,2);
			fail("xOffset can't be negative");
		} catch (IllegalArgumentException e) {
		}
		try{
			SubPicture SubTwo = new SubPictureImpl(picture, 1,-1,1,1);
			fail("yOffset can't be negative");
		} catch (IllegalArgumentException e) {
		
		}
	}
	@Test
	public void a6NoviceTestTwo() {
		Picture p = new PictureImpl(4,4);
		Iterator<Pixel> i = p.iterator();
		assertEquals("Word", i.hasNext(), true);
		}
	@Test
	public void a6NoviceTestThree() {
		  assertEquals(23, new Coordinate(23, 0).getX());
		  assertEquals(18, new Coordinate(0, 18).getY());
	}
}

		

	
	


