package a5.rbowser;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel BLACK = new GrayPixel(0);
	private static final Pixel WHITE = new GrayPixel(1);
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		test_names[2] = "testTile";
		
		
		return test_names;
	}
		
	
	@Test 
	public void sampleTest()
	{
		Picture p = new PictureImpl(4, 4);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(2, 0, BLUE);
		p.setPixel(3, 0, BLUE);
		p.setPixel(0, 1, BLACK);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 1, RED);
		p.setPixel(3, 1, GREEN);
		p.setPixel(0, 2, GREEN);
		p.setPixel(1, 2, BLUE);
		p.setPixel(2, 2, BLACK);
		p.setPixel(2, 3, BLACK);
		p.setPixel(0, 3, RED);
		p.setPixel(1, 3, GREEN);
		p.setPixel(2, 3, WHITE);
		p.setPixel(3, 3, BLUE);
		
		Iterator i = p.sample(1, 1, 2, 2);
		assertEquals("The iterator does not return the correct pixel", p.getPixel(1, 1), i.next());
		assertEquals("The iterator does not return the correct pixel", p.getPixel(3, 1), i.next());
		assertEquals("The iterator does not return the correct pixel", p.getPixel(1, 3), i.next());
		assertEquals("The iterator does not return the correct pixel", p.getPixel(3, 3), i.next());
		
	}
	@Test
	public void windowTest()
	{
		Picture p = new PictureImpl(5, 5);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(2, 0, BLUE);
		p.setPixel(3, 0, BLUE);
		p.setPixel(4, 0, BLUE);
		p.setPixel(0, 1, BLACK);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 1, RED);
		p.setPixel(3, 1, GREEN);
		p.setPixel(4, 1, WHITE);
		p.setPixel(0, 2, GREEN);
		p.setPixel(1, 2, BLUE);
		p.setPixel(2, 2, BLACK);
		p.setPixel(2, 3, BLACK);
		p.setPixel(2, 4, RED);
		p.setPixel(0, 3, RED);
		p.setPixel(1, 3, GREEN);
		p.setPixel(2, 3, WHITE);
		p.setPixel(3, 3, BLUE);
		p.setPixel(0, 4, BLACK);
		p.setPixel(1, 4, GREEN);
		p.setPixel(2, 4, WHITE);
		p.setPixel(3, 4, BLUE);
		p.setPixel(4, 4, RED);
		
		Iterator <SubPicture> i = p.window(3, 2);
		//window_iter.next();
		SubPicture sub = p.extract(0, 0, 3, 2);
		Coordinate test = new Coordinate(0,0);
		assertEquals(p.extract(0,0,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(1,0,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(2,0,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(0,1,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(1,1,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(2,1,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(0,2,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(1,2,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(2,2,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(0,3,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(1,3,3,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(2,3,3,2).getPixel(test), i.next().getPixel(test));




	}
	@Test
	public void testTile()
	{
		Picture p = new PictureImpl(5, 5);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(2, 0, BLUE);
		p.setPixel(3, 0, BLUE);
		p.setPixel(4, 0, BLUE);
		p.setPixel(0, 1, BLACK);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 1, RED);
		p.setPixel(3, 1, GREEN);
		p.setPixel(4, 1, WHITE);
		p.setPixel(0, 2, GREEN);
		p.setPixel(1, 2, BLUE);
		p.setPixel(2, 2, BLACK);
		p.setPixel(2, 3, BLACK);
		p.setPixel(2, 4, RED);
		p.setPixel(0, 3, RED);
		p.setPixel(1, 3, GREEN);
		p.setPixel(2, 3, WHITE);
		p.setPixel(3, 3, BLUE);
		p.setPixel(0, 4, BLACK);
		p.setPixel(1, 4, GREEN);
		p.setPixel(2, 4, WHITE);
		p.setPixel(3, 4, BLUE);
		p.setPixel(4, 4, RED);
		Iterator <SubPicture> i = p.tile(2, 2);
		Coordinate test = new Coordinate(0,0);
		assertEquals(p.extract(0,0,2,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(2,0,2,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(0,2,2,2).getPixel(test), i.next().getPixel(test));
		assertEquals(p.extract(2,2,2,2).getPixel(test), i.next().getPixel(test));

		
				
	}
}
