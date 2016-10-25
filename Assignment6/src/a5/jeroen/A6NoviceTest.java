package a5.jeroen;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;


public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "testCoordinates";
		test_names[1] = "itineratorTest";
		
		return test_names;
	}
		
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	
	@Test
	public void testCoordinates() {
		
		Coordinate c1 = new Coordinate(2,2);
		Coordinate c2 = new Coordinate(4,4);
		assertEquals("Coordinate does not store x correctly",
				c1.getX(),2);
		assertEquals("Coordinate does not store y correctly",
				c1.getY(),2);		
		
		Picture p1 = new PictureImpl(6,6);
		SubPicture sp1 = p1.extract(c1, c2);
		SubPicture sp2 = p1.extract(2, 2, 3, 3);
		
		assertEquals("SubPicture extract using Coordinates incorrect",
				sp1.getWidth(),3);
		
		assertEquals("SubPicture extract using Coordinates incorrect",
				isTheSamePicture(sp1,sp2),true);
		
		
	}
	
	@Test
	public void itineratorTest() {
		Picture p3 = new PictureImpl(3, 3);
		p3.setPixel(0, 0, RED);
		p3.setPixel(1, 0, RED);
		p3.setPixel(2, 0, RED);
		p3.setPixel(0, 1, GREEN);
		p3.setPixel(1, 1, BLUE);
		p3.setPixel(2, 1, WHITE);
		p3.setPixel(0, 2, BLACK);
		p3.setPixel(1, 2, BLACK);
		p3.setPixel(2, 2, RED);
		
		Iterator<Pixel> iter = p3.iterator();
				
		
		assertEquals("Iterator hasNext broken",
				iter.hasNext(),true);	
				
		assertEquals("Iterator returned wrong pixel",
				iter.next(),p3.getPixel(1, 0));
		
		for (int x=0; x<8; x++) {
			iter.next();
		}
		
		assertEquals("Iterator hasNext broken",
				iter.hasNext(),false);
	}
	
	
	public static boolean isTheSamePicture(Picture p1, Picture p2){
		if (p1==null||p2==null){
			throw new IllegalArgumentException("Pics null");
		} else if (p1.getWidth()!=p2.getWidth()||p1.getHeight()!=p2.getHeight()) {
			return false;
		} else {
			boolean theSame=true;
			for (int x=0; x<p1.getWidth(); x++) {
				for (int y=0; y<p1.getHeight(); y++) {
					if (!p1.getPixel(x, y).equals(p2.getPixel(x, y))) {
						theSame=false;
					}
				}
			}
		return theSame;
		}
	}
}
