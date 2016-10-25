package a5.jawitzke;

// Maria Gillcoat
// Andrew Jacober
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
	
		test_names[0] = "testIterator";
		test_names[1] = "getterTest";
		test_names[2] = "setterTest";
		
		
		return test_names;
	}
		

	@Test
	public void testIterator(){
		
		//create Picture p of width 3 height 5
		Picture p = new PictureImpl(2,2);
	
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, BLUE);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1,1,WHITE);


		
		Iterator<Pixel> i = p.iterator();
		// test tp see of iterator is working through
		assertTrue(i.hasNext());
		assertEquals("Pixel values dont match", i.next(), RED);
		assertTrue(i.hasNext());
		assertEquals("Pixel values dont match", i.next(), BLUE);
		assertTrue(i.hasNext());
		assertEquals("Pixel values dont match", i.next(), GREEN);
		assertTrue(i.hasNext());
		assertEquals("Pixel values dont match", i.next(), WHITE);
		assertFalse(i.hasNext());
	}
	@Test 
	public void getterTest(){
		
		Picture p = new PictureImpl(2,2);
		
		p.setPixel(1, 0, RED);
		//create a specific coordinate
		Coordinate c = new Coordinate(1,0);
		//test to see if getX() is funcitoning properly
		assertEquals(1, c.getX());
		// test to see if getY() is funcitoning properly
		assertEquals(0, c.getY());
		
		assertEquals(RED,p.getPixel(c));
	}
	
	@Test
	public void setterTest(){
		// create new picture 
		Picture p = new PictureImpl(5,5);
		// create a coordinate in picture
		Coordinate c1=new Coordinate(1,1);
		// create another coordinate in picture
		Coordinate c2=new Coordinate(3,3);
		
		p.setPixel(c1, RED);
		
		p.setPixel(c2, WHITE);
		// test to see if width matches that of the two coordinates
		assertEquals(p.getPixel(1, 1), RED);
		// test to see if height matches taht of the two coordinates
		assertEquals(p.getPixel(3, 3), WHITE);
		
	}
	
	
		
	
	
}
