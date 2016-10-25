package a5.wtcarter;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[9];
		
		test_names[0] = "exampleTest";
		test_names[1] = "setPixelInvalidCoord";
		test_names[2] = "setPixelNullCoord";
		test_names[3] = "setPixelNullPixel";
		test_names[4] = "getPixelInvalidCoord";
		test_names[5] = "getPixelNullCoord";
		test_names[6] = "extractNullCoord";
		test_names[7] = "iteratorPathTest";
		test_names[8] = "iteratorNextTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void setPixelInvalidCoord() {
		
		//TEST NEGATIVE X COORDINATE
		try {
			Picture pic1 = new PictureImpl(5, 5);
			pic1.setPixel(new Coordinate(-1, 0), new GrayPixel(0.5));
			fail("Did not raise exception for pixel with negative x coordinate");
		}
		catch (RuntimeException e) {
			
		}
		
		//TEST X COORDINATE GREATER THAN PICTURE WIDTH
		try {
			Picture pic2 = new PictureImpl(5, 5);
			pic2.setPixel(new Coordinate(5, 0), new GrayPixel(0.5));
			fail("Did not raise exception for pixel with x coordinate greater than picture width");
		}
		catch (RuntimeException e) {
			
		}
		
		//TEST NEGATIVE Y COORDINATE
		try {
			Picture pic3 = new PictureImpl(5, 5);
			pic3.setPixel(new Coordinate(0, -1), new GrayPixel(0.5));
			fail("Did not raise exception for pixel with negative y coordinate");
		}
		catch (RuntimeException e) {
			
		}
		
		//TEST Y COORDINATE GREATER THAN PICTURE HEIGHT
		try {
			Picture pic4 = new PictureImpl(5, 5);
			pic4.setPixel(new Coordinate(0, 5), new GrayPixel(0.5));
			fail("Did not raise exception for pixel with y coordinate greater than picture height");
		}
		catch (RuntimeException e) {
			
		}
	}
	
	@Test
	public void setPixelNullCoord() {
		try {
			Picture pic = new PictureImpl(5, 5);
			pic.setPixel(null, new GrayPixel(0.5));
			fail ("Did not raise exception for null Coordinate parameter");
		}
		catch (RuntimeException e) {
			
		}
	}
	
	@Test
	public void setPixelNullPixel() {
		try {
			Picture pic = new PictureImpl(5, 5);
			pic.setPixel(new Coordinate(3, 3), null);
			fail ("Did not raise exception for null Pixel parameter");
		}
		catch (RuntimeException e) {
			
		}
	}

	@Test
	public void getPixelInvalidCoord() {

		//TEST NEGATIVE X COORDINATE
		try {
			Picture pic1 = new PictureImpl(5, 5);
			pic1.getPixel(new Coordinate(-1, 0));
			fail("Did not raise exception for negative x coordinate");
		}
		catch (RuntimeException e) {
			
		}
		
		//TEST X COORDINATE GREATER THAN PICTURE WIDTH
		try {
			Picture pic2 = new PictureImpl(5, 5);
			pic2.getPixel(new Coordinate(5, 0));
			fail("Did not raise exception for x coordinate greater than picture width");
		}
		catch (RuntimeException e) {
			
		}
		
		//TEST NEGATIVE Y COORDINATE
		try {
			Picture pic3 = new PictureImpl(5, 5);
			pic3.getPixel(new Coordinate(0, -1));
			fail("Did not raise exception for negative y coordinate");
		}
		catch (RuntimeException e) {
			
		}
		
		//TEST Y COORDINATE GREATER THAN PICTURE HEIGHT
		try {
			Picture pic4 = new PictureImpl(5, 5);
			pic4.getPixel(new Coordinate(0, 5));
			fail("Did not raise exception for y coordinate greter than picture height");
		}
		catch (RuntimeException e) {
			
		}
	}
	
	@Test
	public void getPixelNullCoord() {
		//TEST WITH NULL COORDINATE PARAMETER
		try {
			Picture pic = new PictureImpl(5, 5);
			pic.getPixel(null);
			fail ("Did not raise exception for null Coordinate parameter");
		}
		catch (RuntimeException e) {
			
		}
	}

	@Test
	public void extractNullCoord() {
		Picture pic = new PictureImpl(5, 5);
		
		//TEST WITH NULL COORDINATE A
		try {
			SubPicture sub1 = pic.extract(null, new Coordinate(3, 3));
			fail("Did not raise exception for null Coordinate A");
		} 
		catch (RuntimeException e) {
			
		}
		
		//TEST WITH NULL COORDINATE B
		try {
			SubPicture sub2 = pic.extract(new Coordinate(0, 1), null);
			fail("Did not raise exception for null Coordinate B");
		}
		catch (RuntimeException e) {
			
		}
	}
	
	@Test
	public void iteratorPathTest() {
		Picture pic = new PictureImpl(2, 2);
		Iterator<Pixel> iter = pic.iterator();
		
		pic.setPixel(new Coordinate(1, 0), new GrayPixel(0.8));
		pic.setPixel(new Coordinate(0, 1), new GrayPixel(0.2));
		
		String result = "";
		while (iter.hasNext()) {
			result += iter.next().getChar();
		}
		
		if (!(result.equals(">-X>"))) {
			fail("Iterator did not retrieve expected pixels");
		}
	}
	
	@Test
	public void iteratorNextTest() {
		Picture pic = new PictureImpl(2, 3);
		Iterator<Pixel> iter = pic.iterator();
		try {
			for (int i = 0; i < 7; i++) {
				iter.next();
			}
			fail("Did not throw exception for iterator out of bounds");
		}
		catch (RuntimeException e){
			
		}
	}
}