package a5.vinli;

import static org.junit.Assert.*;

import java.awt.Color;
import java.nio.file.spi.FileSystemProvider;
import java.util.Iterator;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		return new String[] {"sampleTest", "windowTest"};
	}
	
	Picture aPicture = new PictureImpl(20, 20);
		
	
	private static boolean comparePixel(Pixel p, Pixel c) {
		double ptotal = p.getBlue() + p.getRed() + p.getGreen() + p.getIntensity();
		double ctotal = c.getBlue() + c.getRed() + c.getGreen() + c.getIntensity();
		if (ctotal == ptotal) {
			return true;
		}
		return false;
	}
	
	@Test
	public void sampleTest() {
		// This method tests the sample method
		Iterator<Pixel> iterator = aPicture.sample(0, 0, 1, 1);
		Pixel aPixel = new ColorPixel(.3, .2, .1);
		Pixel bPixel = new ColorPixel(.5, .6, .2);
		for (int i = 0; i < aPicture.getHeight(); i++) {
			for (int j = 0; j < aPicture.getWidth(); j++) {
				switch(j) {
				case 0: case 2: case 4: case 6: case 8: aPicture.setPixel(j, i, aPixel);
				break;
				case 10: case 12: case 14: case 16: case 18: aPicture.setPixel(j, i, bPixel);
				}
			}
		}
		
		for (int i = 0; i < aPicture.getHeight(); i++) {
			for (int j = 0; j < aPicture.getWidth(); j++) {
				assertTrue(comparePixel(iterator.next(), aPicture.getPixel(j, i)));
			}
		}
		
		Iterator<Pixel> iterator2 = aPicture.sample(0, 0, 2, 1);
		while(iterator2.hasNext()) {
			for (int i = 0; i < 10; i++) {
				if (i < 5) {
					assertTrue(comparePixel(iterator2.next(), aPixel));
				} else {
					assertTrue(comparePixel(iterator2.next(), bPixel));
				}
			}
		}
	}
	
	@Test
	public void windowTest() {
		// This method tests the window method
		Iterator<SubPicture> iterator = aPicture.window(1, 1);
		int count = 0;
		while(iterator.hasNext()) {
			iterator.next();
			count ++;
		}
		assertEquals(400, count);
		
		Pixel aPixel = new ColorPixel(.4, .2, .1);
		for (int i = 0; i < aPicture.getWidth() - 8; i++) {
			for (int j = 0; j < aPicture.getHeight() - 8; j++) {
				aPicture.setPixel(i, j, aPixel);
			}
		}
		Iterator<SubPicture> iterator2 = aPicture.window(9, 9);
		while(iterator2.hasNext()) {
			assertTrue(comparePixel(iterator2.next().getPixel(0, 0), aPixel));
		}
	}
	
	
	

}
