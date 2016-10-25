package a5.vinli;

import static org.junit.Assert.*;

import java.awt.Color;
import java.nio.charset.MalformedInputException;
import java.util.Iterator;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	Pixel aPixel = new ColorPixel(.3, .8, .2);
	Picture aPicture = new PictureImpl(10, 10);
		
	static public String[] getTestNames() {
		return new String[] {"getPixeltest", "iteratorTest"};
	}
	
	@Test
	public void getPixeltest() {
		// This method tests the getPixel command for coordinates
		aPicture.setPixel(2, 2, aPixel);
		Coordinate aCoordinateCoordinate = new Coordinate(2, 2);
		Pixel bPixel = aPicture.getPixel(aCoordinateCoordinate);
		assertTrue(comparePixel(bPixel, aPixel));
		
		Picture subpicture = new SubPictureImpl(aPicture, 2, 2, 2, 2);
		Coordinate bCoordinate = new Coordinate(0, 0);
		Pixel cPixel = subpicture.getPixel(bCoordinate);
		assertTrue(comparePixel(cPixel, aPixel));
	}
	
	@Test
	public void iteratorTest() {
		// This method tests the iterator methods
		Iterator<Pixel> iterator = aPicture.iterator();
		Pixel grapyPixel = new GrayPixel(.5);
		Pixel cPixel = new ColorPixel(.3, .8, .9);
		Pixel dPixel = new ColorPixel(.1, .9, .14);
		Pixel ePixel = new ColorPixel(.9, .9, .9);
		for (int i = 0; i < aPicture.getHeight(); i++) {
			Coordinate coordinate = new Coordinate(2, i);
			aPicture.setPixel(coordinate, cPixel);	
		}
		for (int i = 0; i < aPicture.getHeight(); i++) {
			Coordinate coordinate = new Coordinate(4, i);
			aPicture.setPixel(coordinate, dPixel);
		}
		aPicture.setPixel(0, 0, ePixel);
		for (int i = 0; i < aPicture.getHeight(); i++) {
			for (int j = 0; j < aPicture.getWidth(); j++) {
				Pixel testPixel = aPicture.getPixel(j, i);
				switch(j) {
				case 0: if (i == 0) {
					assertTrue(comparePixel(testPixel, ePixel));
				}
				break;
				case 2: assertTrue(comparePixel(testPixel, cPixel));
				break;
				case 4: assertTrue(comparePixel(testPixel, dPixel));
				break;
				default: assertTrue(comparePixel(grapyPixel, testPixel));
				}
			}
		}
		
		try {
			iterator.remove();
			fail("expected exception");
		} catch (UnsupportedOperationException e) {}
	}
	

	private static boolean comparePixel(Pixel p, Pixel c) {
		double ptotal = p.getBlue() + p.getRed() + p.getGreen() + p.getIntensity();
		double ctotal = c.getBlue() + c.getRed() + c.getGreen() + c.getIntensity();
		if (ctotal == ptotal) {
			return true;
		}
		return false;
	}
}
