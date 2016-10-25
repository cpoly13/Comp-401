package a5.afatehi;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.GrayPixel;
import a6novice.Pixel;
import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel white = new GrayPixel(1);
	private static final Pixel black = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "exampleTest";
		test_names[1] = "testCoordinate";
		test_names[2] = "testSettersAndGetters";
		test_names[3] = "testIterator";
		
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void testCoordinate(){
		Picture p = new PictureImpl(6,4);
		Coordinate s = new Coordinate(0,1);
		p.setPixel(s, white);
		assertEquals("Result from getX() does not match proper Coordinate",
				s.getX(), 0);
		assertEquals("Result from getY() does not match proper Coordinate",
				s.getY(), 1);
	}
	@Test
	public void testSettersAndGetters(){
		Picture p = new PictureImpl(3, 3);
		Picture s = new PictureImpl(3,3);
		Coordinate x = new Coordinate(0,0);
		p.setPixel(0, 0, white);
		s.setPixel(x, white);
		assertEquals("Result from overload setters and getters does not match old method results"
				,p.getPixel(0, 0),s.getPixel(x));
	}
	@Test
	public void testIterator(){
		Picture p = new PictureImpl(3,3);
		Coordinate s = new Coordinate (0,0);
		p.setPixel(0, 0, white);
		p.setPixel(1, 0, black);
		p.setPixel(2, 0, white);
		p.setPixel(0, 1, black);
		p.setPixel(1, 1, white);
		p.setPixel(2, 1, black);
		p.setPixel(0, 2, white);
		p.setPixel(1, 2, white);
		p.setPixel(2,2, black);
		Iterator<Pixel> iter = p.iterator();
		Pixel test = white;
		int x = s.getX();
		int y = s.getY();
		while (iter.hasNext()){
			for (int i = 0; i<3; i++){
				y = i;
				for(int j = 0; j<3; j++){
					x = j; 
					test = iter.next();
			assertEquals("Test intenity of final pixel does not match expected",
					test, p.getPixel(x, y));
				}
			}
		}
			
	}
	
}
