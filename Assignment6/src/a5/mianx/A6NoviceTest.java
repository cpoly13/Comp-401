package a5.mianx;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
String[] test_names = new String[2];
		
		test_names[0] = "coordinateBasicTest";
		test_names[1] = "coordinateExtractTest";
		
		return test_names;
	}

	@Test
	//test the coordinate overloaded getter and setter method 
	public void coordinateBasicTest() {
		Picture aPicture = new PictureImpl(5,5);
		
		aPicture.setPixel(new Coordinate(1,1), RED);
		aPicture.setPixel(1, 2, RED);
		assertEquals("The overloaded setPixel method is incorrect", 
				aPicture.getPixel(1, 1), aPicture.getPixel(1,2));
		
		aPicture.setPixel(3, 1, GREEN);
		Pixel p1 = aPicture.getPixel(3,1);
		Pixel p2 = aPicture.getPixel(new Coordinate(3,1));
		assertEquals("The overloaded getPixel method is incorrect", p1, p2);
	}
	
	@Test
	//test the coordinate overloaded extract method
	public void coordinateExtractTest() {
			Picture picture1 = new PictureImpl(6,4);
			
			Coordinate c1= new Coordinate (2,0);
			Coordinate c2 = new Coordinate (5,3);
			Picture subPic1 = picture1.extract(2,0, 4, 4);
			Picture subPic2 = picture1.extract(c1, c2);
			
			assertEquals("The overloaded extract method is incorrect", 
					subPic1.getHeight(), subPic2.getHeight());
			assertEquals("The overloaded extract method is incorrect", 
					subPic1.getWidth(), subPic2.getWidth());
			
	}
}
