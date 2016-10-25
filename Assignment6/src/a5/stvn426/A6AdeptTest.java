package a5.stvn426;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "testSample";
		
		return test_names;
	}
		
	@Test
	public void testSample() {
		Picture p = new PictureImpl(3,3);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, BLUE);
		p.setPixel(2, 1, WHITE);
		p.setPixel(0, 2, BLACK);
		p.setPixel(1, 2, BLACK);
		p.setPixel(2, 2, RED);
		
		Iterator<Pixel> it = p.iterator();
		Iterator<Pixel> sa = p.sample(0,0,1,1);
		for(int i = 0; i < p.getWidth(); i ++ ) {
			for(int j = 0; j < p.getHeight(); j++ ) {
				assertEquals("sample(0,0,1,1) does not match basic iterator",
						it.next(), sa.next());
			}
		}
	}
}
