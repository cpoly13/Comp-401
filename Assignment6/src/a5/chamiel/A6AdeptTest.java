package a5.chamiel;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		test_names[2] = "tileTest";
		
		return test_names;
	}
		
	@Test
	public void sampleTest() {
		Picture pic = new PictureImpl(15, 10);
		for (int i=0; i<15; i++) {
			for (int j=0; j<10; j++) {
				pic.setPixel(i, j, new ColorPixel(Math.random(), Math.random(), Math.random()));
			}
		}
		Iterator<Pixel> it = pic.sample(2, 3, 3, 4);
		assertTrue(it.next().getIntensity() == pic.getPixel(2, 3).getIntensity());
		assertTrue(it.next().getIntensity() == pic.getPixel(5, 3).getIntensity());
		assertTrue(it.next().getIntensity() == pic.getPixel(8, 3).getIntensity());
		assertTrue(it.next().getIntensity() == pic.getPixel(11, 3).getIntensity());
		assertTrue(it.next().getIntensity() == pic.getPixel(14, 3).getIntensity());
		assertTrue(it.next().getIntensity() == pic.getPixel(2, 7).getIntensity());
	}
	
	@Test
	public void windowTest() {
		Picture pic = new PictureImpl(5, 5);
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				pic.setPixel(i, j, new ColorPixel(Math.random(), Math.random(), Math.random()));
			}
		}
		Iterator<SubPicture> it = pic.window(3, 2);
		assertTrue(it.next().getPixel(2,1).getIntensity() ==
				pic.extract(0, 0, 3, 2).getPixel(2, 1).getIntensity());
		assertTrue(it.next().getPixel(2,1).getIntensity() ==
				pic.extract(1, 0, 3, 2).getPixel(2, 1).getIntensity());
		assertTrue(it.next().getPixel(2,1).getIntensity() ==
				pic.extract(2, 0, 3, 2).getPixel(2, 1).getIntensity());
		it.next();
		assertEquals(it.next().getPixel(1,1).getRed(),
				pic.extract(1, 1, 3, 2).getPixel(1, 1).getRed(), .0001);
	}
	
	@Test
	public void tileTest() {
		Picture pic = new PictureImpl(5, 5);
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				pic.setPixel(i, j, new ColorPixel(Math.random(), Math.random(), Math.random()));
			}
		}
		Iterator<SubPicture> it = pic.tile(2, 2);
		assertEquals(it.next().getPixel(2,1).getIntensity(),
				pic.extract(0, 0, 2, 2).getPixel(2, 1).getIntensity(), .0001);
		assertEquals(it.next().getPixel(2,1).getIntensity(), 
				pic.extract(2, 0, 2, 2).getPixel(2, 1).getIntensity(), .0001);
		it.next();
		assertEquals(it.next().getPixel(1,1).getRed(),
				pic.extract(2, 2, 2, 2).getPixel(1, 1).getRed(), .0001);
	}
}
