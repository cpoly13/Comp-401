package a5.dezarae;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
        return new String[]{"testCoordinateGet", "testOverloadedSetAndGetPixel", 
        		"testOverloadedSubPictureExtract", "testHasNext", "testNext"};
    }
		
	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	@Test
	public void testCoordinateGet() {
		
		//tests getX() and getY to ensure they return the correct values
		
		Coordinate c1 = new Coordinate (10, 12);
		Coordinate c2 = new Coordinate (1, 5);
		Coordinate c3 = new Coordinate (0, 0);
		Coordinate c4 = new Coordinate (5, 1);
		
		assertEquals("X value retrieved does not match expected value.",
				c1.getX(), 10);
		assertEquals("X value retrieved does not match expected value.",
				c2.getX(), 1);
		assertEquals("X value retrieved does not match expected value.",
				c3.getX(), 0);
		assertEquals("X value retrieved does not match expected value.",
				c4.getX(), 5);
		assertEquals("Y value retrieved does not match expected value.",
				c1.getY(), 12);
		assertEquals("Y value retrieved does not match expected value.",
				c2.getY(), 5);
		assertEquals("Y value retrieved does not match expected value.",
				c3.getY(), 0);
		assertEquals("Y value retrieved does not match expected value.",
				c4.getY(), 1);
		
	}
	
	@Test
	public void testOverloadedSetAndGetPixel() {
		
		//tests setPixel to ensure a pixel value changes to match
		//inputed values
		Picture p = new PictureImpl(4, 4);
		
		Coordinate c1 = new Coordinate (0, 0);
		Coordinate c2 = new Coordinate (3, 1);
		Coordinate c3 = new Coordinate (1, 3);
		Coordinate c4 = new Coordinate (2, 1);
		
		Pixel p1 = RED;
		Pixel p2 = BLUE;
		Pixel p3 = GREEN;
		Pixel p4 = WHITE;
		Pixel p5 = BLACK;
		
		p.setPixel(c1, p1);
		assertEquals("Pixel value returned at coordinate does not match expected value.",
				p.getPixel(c1), RED);
		p.setPixel(c2, p2);
		assertEquals("Pixel value returned at coordinate does not match expected value.",
				p.getPixel(c2), BLUE);
		p.setPixel(c3, p3);
		assertEquals("Pixel value returned at coordinate does not match expected value.",
				p.getPixel(c3), GREEN);
		p.setPixel(c4, p4);
		assertEquals("Pixel value returned at coordinate does not match expected value.",
				p.getPixel(c4), WHITE);
		p.setPixel(c1, p5);
		assertEquals("Pixel value returned at coordinate does not match expected value.",
				p.getPixel(c1), BLACK);
		
	}
	
	@Test
	public void testOverloadedSubPictureExtract() {
		
		//ensures that a subpicture created using two coordinates
		//creates an accurate subpicture
		
		Picture p = new PictureImpl(5,5);
		
		p.setPixel(0, 0, RED);
		p.setPixel(0, 1, RED);
		p.setPixel(0, 2, RED);
		p.setPixel(0, 3, RED);
		p.setPixel(0, 4, RED);
		p.setPixel(1, 0, BLUE);
		p.setPixel(1, 1, BLUE);
		p.setPixel(1, 2, BLUE);
		p.setPixel(1, 3, BLUE);
		p.setPixel(1, 4, BLUE);
		p.setPixel(2, 0, GREEN);
		p.setPixel(2, 1, GREEN);
		p.setPixel(2, 2, GREEN);
		p.setPixel(2, 3, GREEN);
		p.setPixel(2, 4, GREEN);
		p.setPixel(3, 0, WHITE);
		p.setPixel(3, 1, WHITE);
		p.setPixel(3, 2, WHITE);
		p.setPixel(3, 3, WHITE);
		p.setPixel(3, 4, WHITE);
		p.setPixel(4, 0, BLACK);
		p.setPixel(4, 1, BLACK);
		p.setPixel(4, 2, BLACK);
		p.setPixel(4, 3, BLACK);
		p.setPixel(4, 4, BLACK);
		
		
		Coordinate c1 = new Coordinate (0, 4);
		Coordinate c2 = new Coordinate (4, 1);
		Coordinate c3 = new Coordinate (4, 3);
		Coordinate c4 = new Coordinate (2, 1); 
		
		SubPicture sp1 = p.extract(c4, c1);
		
		assertEquals("SubPicture created using coordinates does not match expected SubPicture", 
				p.getPixel(2,1), sp1.getPixel(2,0));
		
		SubPicture sp2 = p.extract(c4, c3);
		
		assertEquals("SubPicture created using coordinates does not match expected SubPicture", 
				p.getPixel(3,2), sp2.getPixel(1,1));
	}
	
	@Test
	public void testHasNext() {
		
		//tests HasNext to ensure it returns the correct boolean value
		
		Picture p1 = new PictureImpl(3,3);
		
		Iterator<Pixel> iteration1 = p1.iterator();
		
		assertEquals("HasNext did not return the expected boolean value", 
				iteration1.hasNext(), true);
		
		
		
	}
	
	@Test
	public void testNext() {
		
		//tests Next to ensure it returns the correct pixel
		
		Picture p = new PictureImpl(3,3);
		
		p.setPixel(0, 0, RED);
		
		Iterator<Pixel> iteration = p.iterator();
		
		assertEquals("Next did not return the correct pixel", 
				iteration.next(), RED);
	}	
		
	
}
