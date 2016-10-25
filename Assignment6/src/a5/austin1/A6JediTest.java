package a5.austin1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "zigzagSquareTest";
		test_names[1] = "zigzagRectangleTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagSquareTest() {
		PictureImpl testPic = new PictureImpl(4,4);
		Coordinate a = new Coordinate(0,2);
		Coordinate b = new Coordinate(1,1);
		Coordinate c = new Coordinate(2,0);

		testPic.setPixel(a, RED);
		testPic.setPixel(b, GREEN);
		testPic.setPixel(c, BLUE);
		Iterator<Pixel> ziggy = testPic.zigzag();
		for(int i=0; i < 3; i++) {
			ziggy.next();
		}
		
		assertEquals(ziggy.next(), RED);
		assertEquals(ziggy.next(), GREEN);
		assertEquals(ziggy.next(), BLUE);
	}
	
	@Test
	public void zigzagRectangleTest() {
		PictureImpl testPic = new PictureImpl(4,3);
		Coordinate a = new Coordinate(2,2);
		Coordinate b = new Coordinate(3,1);
		Coordinate c = new Coordinate(3,2);

		testPic.setPixel(a, RED);
		testPic.setPixel(b, GREEN);
		testPic.setPixel(c, BLUE);
		Iterator<Pixel> ziggy = testPic.zigzag();
		for(int i=0; i < 9; i++) {
			ziggy.next();
		}
		
		assertEquals(ziggy.next(), RED);
		assertEquals(ziggy.next(), GREEN);
		assertEquals(ziggy.next(), BLUE);
	}
}
