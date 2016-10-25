package a5.brandybs;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;
//import a6novice.ColorPixel;
//import a6novice.GrayPixel;
//import a6novice.Pixel;

public class A6AdeptTest {
		
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		return test_names;
	}
		
	@Test
	public void sampleTest() {
		
		Picture p = new PictureImpl(5,5);
		
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(3, 0, RED);
		p.setPixel(4, 0, RED);
		
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, RED);
		p.setPixel(2, 1, GREEN);
		p.setPixel(3, 1, BLUE);
		p.setPixel(4, 1, GREEN);
		
		p.setPixel(0, 2, BLUE);
		p.setPixel(1, 2, BLUE);
		p.setPixel(2, 2, BLUE);
		p.setPixel(3, 2, BLUE);
		p.setPixel(4, 2, BLUE);
		
		p.setPixel(0, 3, BLACK);
		p.setPixel(1, 3, WHITE);
		p.setPixel(2, 3, BLACK);
		p.setPixel(3, 3, BLUE);
		p.setPixel(4, 3, BLACK);
		
		p.setPixel(0, 4, WHITE);
		p.setPixel(1, 4, WHITE);
		p.setPixel(2, 4, WHITE);
		p.setPixel(3, 4, WHITE);
		p.setPixel(4, 4, WHITE);
		
		Iterator<Pixel> weirdo = p.sample(1, 1, 2, 2);
		
		assertEquals("iterator didn't do the right thing",
				p.getPixel(1, 1), weirdo.next());
		assertEquals("iterator didn't do the right thing",
				p.getPixel(3, 1), weirdo.next());
		assertEquals("iterator didn't do the right thing",
				p.getPixel(1, 3), weirdo.next());
		assertEquals("iterator didn't do the right thing",
				p.getPixel(3, 3), weirdo.next());
		
	}
	
	@Test
	public void windowtest(){
		
Picture p = new PictureImpl(5,5);
		
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(3, 0, RED);
		p.setPixel(4, 0, RED);
		
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, RED);
		p.setPixel(2, 1, GREEN);
		p.setPixel(3, 1, BLUE);
		p.setPixel(4, 1, GREEN);
		
		p.setPixel(0, 2, BLUE);
		p.setPixel(1, 2, BLUE);
		p.setPixel(2, 2, BLUE);
		p.setPixel(3, 2, BLUE);
		p.setPixel(4, 2, BLUE);
		
		p.setPixel(0, 3, BLACK);
		p.setPixel(1, 3, WHITE);
		p.setPixel(2, 3, BLACK);
		p.setPixel(3, 3, BLUE);
		p.setPixel(4, 3, BLACK);
		
		p.setPixel(0, 4, WHITE);
		p.setPixel(1, 4, WHITE);
		p.setPixel(2, 4, WHITE);
		p.setPixel(3, 4, WHITE);
		p.setPixel(4, 4, WHITE);
		
		Iterator<SubPicture> weirdo = p.window(3, 2);
		
		//assertEquals("iterator didn't do the right thing",
			//	p.extract(0, 0, 3, 2).compareSubPictures(), weirdo.next().compareSubPictures());
		
		assertTrue(compareSubPictures(p.extract(0, 0, 3, 2), weirdo.next()));
		assertTrue(compareSubPictures(p.extract(1, 0, 3, 2), weirdo.next()));
		assertTrue(compareSubPictures(p.extract(2, 0, 3, 2), weirdo.next()));
		
		assertTrue(compareSubPictures(p.extract(0, 1, 3, 2), weirdo.next()));
		assertTrue(compareSubPictures(p.extract(1, 1, 3, 2), weirdo.next()));
		assertTrue(compareSubPictures(p.extract(2, 1, 3, 2), weirdo.next()));
		
		assertTrue(compareSubPictures(p.extract(0, 2, 3, 2), weirdo.next()));
		assertTrue(compareSubPictures(p.extract(1, 2, 3, 2), weirdo.next()));
		assertTrue(compareSubPictures(p.extract(2, 2, 3, 2), weirdo.next()));
		
		assertTrue(compareSubPictures(p.extract(0, 3, 3, 2), weirdo.next()));
		assertTrue(compareSubPictures(p.extract(1, 3, 3, 2), weirdo.next()));
		assertTrue(compareSubPictures(p.extract(2, 3, 3, 2), weirdo.next()));
	}
	private boolean compareSubPictures(SubPicture a, SubPicture b){
		return (a.getXOffset() == b.getXOffset()
				&& a.getYOffset() == b.getYOffset()
				&& a.getWidth() == b.getWidth()
				&& a.getHeight() == b.getHeight() );
				
	}
}
