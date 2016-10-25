package a5.aandrei;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.Coordinate;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "testCoordinateConstructor";
		test_names[1] = "testPictureOverloadMethods";
		test_names[2] = "testRowMajorPixelIterator";
		
		return test_names;
	}
	
	 private static final Pixel GRAY = new GrayPixel(0.5);
	 private static final Pixel BLACK = new GrayPixel(1);
	 private static final Pixel WHITE = new GrayPixel(0);
		
	@Test
	public void testCoordinateConstructor() {
	  Coordinate c = new Coordinate(3, 5);
	  
	  assertEquals("x does not match value given to constructor", 
	      3, c.getX());
	  assertEquals("y does not match value given to constructor", 
	      5, c.getY());
	}
	
	@Test
	public void testPictureOverloadMethods() {
	   Picture p = new PictureImpl(6, 5);
	   for (int i = 0; i < 5; i++) {
	     for (int j = 0; j < 6; j++) {
	       p.setPixel(j, i, GRAY);
	     }
	   }
     p.setPixel(2, 3, BLACK);
     Coordinate black = new Coordinate(2, 3);
     
     assertEquals("getPixel overload methed did not return expected Pixel",
         BLACK, p.getPixel(black));
     
     Coordinate white = new Coordinate(4, 2); 
     p.setPixel(white, WHITE);
     
     assertEquals("setPixel overload method did not cause picture to return expected Pixel",
         WHITE, p.getPixel(4, 2));
     
     Coordinate topLeftCorner = new Coordinate(2, 1);
     Coordinate bottomRightCorner = new Coordinate(5, 3);
     Picture subP1 = p.extract(bottomRightCorner, topLeftCorner);
     
     Coordinate bottomLeftCorner = new Coordinate(2, 3);
     Coordinate topRightCorner = new Coordinate(5, 1);
     Picture subP2 = p.extract(topRightCorner, bottomLeftCorner);  

     assertEquals("The SubPicture's getPixel method did not return expected pixel",
         GRAY, subP1.getPixel(2, 2));
     assertEquals("The SubPicture's getPixel method did not return expected pixel",
         GRAY, subP2.getPixel(2, 2));
     assertEquals("The SubPicture's getPixel method did not return expected pixel",
         WHITE, subP1.getPixel(2, 1));
     assertEquals("The SubPicture's getPixel method did not return expected pixel",
         WHITE, subP2.getPixel(2, 1));
     assertEquals("The SubPicture's getPixel method did not return expected pixel",
         BLACK, subP1.getPixel(0, 2));
     assertEquals("The SubPicture's getPixel method did not return expected pixel",
         BLACK, subP2.getPixel(0, 2));
	}
	
	@Test
	public void testRowMajorPixelIterator() {
	  Picture p = new PictureImpl(4, 2);
	  for (int i = 0; i < 4; i++) {
	    p.setPixel(i, 0, GRAY);
	    p.setPixel(i, 1, GRAY);
	  }
	  p.setPixel(0, 1, BLACK);
	  Iterator<Pixel> iter = p.iterator();
	  
	   assertEquals("iterator did not return expected Pixel", 
	       GRAY, iter.next());
	   for (int i = 0; i < 3; i++) {
	     iter.next();
	   }
     assertEquals("iterator did not return expected Pixel", 
         BLACK, iter.next());
     for (int i = 0; i < 3; i++) {
       iter.next();
     }
     try {
       iter.next();
       fail("Expected NoSuchElementException");
     } catch (NoSuchElementException e) {
     } catch (RuntimeException e) {
       fail("Expected NoSuchElementException but got generic RuntimeException");
     }
	}
}
