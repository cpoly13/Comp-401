package a5.astrand;

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
		String[] test_names = new String[4];

		test_names[0] = "coordinateTest";
		test_names[1] = "iteratortest";
		test_names[2] = "testsetpixel";
		test_names[3] = "testExtract";
		
		

		return test_names;
	}

	@Test
	public void coordinateTest(){
		Picture pic = new PictureImpl(3,3);
		Coordinate point = new Coordinate(1,2); //test input values

		assertEquals(1,point.getX()); //See if they are same
		assertEquals(2,point.getY()); //See if they are different
		assertEquals(pic.getPixel(1,2), pic.getPixel(point));

		

	}
	

	@Test
	public void iteratortest(){
		Pixel p = new GrayPixel(.5);
		Picture pic = new PictureImpl(3,3);
		Coordinate point = new Coordinate(1,5); //test input values
		Iterator<Pixel> itr = pic.iterator();

		for (int x=0; x < pic.getHeight(); x++) {
			for (int y=0; y < pic.getWidth(); y++) {
				point = new Coordinate(x,y);
				if(itr.hasNext() == true){
					p=itr.next();
					assertEquals(p, pic.getPixel(point));	
				}else if(itr.hasNext() == false){
					try {
						itr.next();
						fail("Expected IllegalArgumentException next on iterator - at end of array");
					} catch (IllegalArgumentException e) {
					} catch (RuntimeException e) {
						fail("Expected IllegalArgumentException but got generic RuntimeException");
					}

				}
			}
		}

	}

	@Test
	public void testsetpixel(){
		Picture pic = new PictureImpl(3,3);
		Coordinate point = new Coordinate(1,2); //test input values

		pic.setPixel(point, RED);
		assertEquals("Did not set correct Pixel", RED, pic.getPixel(point));
		assertEquals("Pixels are not the same", pic.getPixel(1,2), pic.getPixel(point));
		
		pic.setPixel(point, BLUE);
		assertEquals("Pixel retrieved in not correct", BLUE , pic.getPixel(point));

	}

	@Test
	public void testExtract() {
		Picture p = new PictureImpl(3, 3);
		Coordinate point1 = new Coordinate(1,1);
		Coordinate point2 = new Coordinate(2,2);
		Coordinate point3 = new Coordinate(1,2);
		Coordinate point4 = new Coordinate(2,1);
		Coordinate point5 = new Coordinate(1,0);
		Coordinate point6 = new Coordinate(0,0);
		Coordinate point7 = new Coordinate(0,1);
		Coordinate point8 = new Coordinate(2,0);
		Coordinate point9 = new Coordinate(0,2);

		p.setPixel(point6, RED);
		p.setPixel(point5, RED);
		p.setPixel(point8, RED);
		p.setPixel(point7, GREEN);
		p.setPixel(point1, BLUE);
		p.setPixel(point4, WHITE);
		p.setPixel(point9, BLACK);
		p.setPixel(point3, BLACK);
		p.setPixel(point2, RED);

		SubPicture sp = p.extract(point1, point2);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(point1), sp.getPixel(point6));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(point4), sp.getPixel(point5));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(point3), sp.getPixel(point7));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(point2), sp.getPixel(point1));

		SubPicture sp2 = sp.extract(point1, point1);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(point2), sp2.getPixel(point6));

	}
	
}
