package a5.corverab;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

//import a6novice.ColorPixel;
//import a6novice.GrayPixel;
//import a6novice.Picture;
//import a6novice.PictureImpl;
//import a6novice.Pixel;
//import a6novice.SubPicture;
import a6adept.*;

public class A6AdeptTest {
	
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	

	static public String[] getTestNames() {
		String[] test_names = new String[5];
		

		
		test_names[0] = "setPixelTest";
		test_names[1] = "getandcoordPixelTest";
		test_names[2]=  "testExtract";
		test_names[3] = "iteratorhasNextTest";
		test_names[4] = "iteratorNextTest";

		return test_names;
	}



	@Test
	public void setPixelTest() {

		Coordinate testCoord = new Coordinate(5,5);

		Picture testPicture = new PictureImpl(10, 10);

		Pixel testPixel = new ColorPixel(1,1,1);

		testPicture.setPixel(testCoord, testPixel);

		testPicture.getPixel(testCoord);
		assertEquals("get out of here with your bullshit", testPixel, testPicture.getPixel(5, 5));


	}
	
	@Test
	public void getandcoordPixelTest() {

		Coordinate testCoord = new Coordinate(5,5);

		Picture testPicture = new PictureImpl(10, 10);

		Pixel testPixel = new ColorPixel(1,1,1);

		testPicture.setPixel(testCoord, testPixel);

		testPicture.getPixel(testCoord);
		assertEquals("get out of here with your bullshit", testPixel, testPicture.getPixel(testCoord));


	}



	
	
	@Test
	public void testExtract() {
		Picture p = new PictureImpl(3, 3);
		
		Coordinate testCoord = new Coordinate(1,1);
		Coordinate testCoord2 = new Coordinate(2,2);
		
		
		
		SubPicture sp = p.extract(testCoord, testCoord2);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 1), sp.getPixel(0, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 1), sp.getPixel(1, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 2), sp.getPixel(0, 1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp.getPixel(1, 1));
		
		SubPicture sp2 = sp.extract(1, 1, 1, 1);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp2.getPixel(0, 0));

	}

	@Test
	public void iteratorhasNextTest() {


		Picture testPicture = new PictureImpl(15, 10);

		Iterator<Pixel> sample_iter = testPicture.sample(2, 3, 3, 4);
		

		assertEquals("iterator has next test is fooked", true, sample_iter.hasNext());


	}
	
	@Test
	public void iteratorNextTest() {


		Picture testPicture = new PictureImpl(15, 10);

		Iterator<Pixel> sample_iter = testPicture.sample(2, 3, 3, 4);
		
		Coordinate c = new Coordinate(2,3);
		
		Pixel p = testPicture.getPixel(c);

		assertEquals("iterator next test is fooked", p, sample_iter.next());


	}
	
	
}
