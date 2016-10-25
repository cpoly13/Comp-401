package a5.samhelen;

import static org.junit.Assert.*;


import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	double precision;
	
	@Before
	public void setUp() {
		precision = 0.0001;	
	}
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "getCoordinateBasic";
		test_names[1] = "subPicExtractTest";
		test_names[2] = "iteratorTest";
		
		return test_names;
	}
		
	
	
	@Test
	public void getCoordinateBasic() {
		Coordinate c1 = new Coordinate(1, 3);
		
		
		assertEquals("x-value does not match value given by constructor", 1, c1.getX());
		assertEquals("y-value does not match value given by constructor", 3, c1.getY());
	}
	
	@Test
	public void subPicExtractTest() {
		Picture p = new PictureImpl(4, 3);
		
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, BLUE);
		p.setPixel(2, 0, BLACK);
		p.setPixel(3, 0, BLUE);
		p.setPixel(0, 1, BLUE);
		p.setPixel(1, 1, GREEN);
		p.setPixel(2, 1, WHITE);
		p.setPixel(3, 1, BLACK);
		p.setPixel(0, 2, GREEN);
		p.setPixel(1, 2, RED);
		p.setPixel(2, 2, BLACK);
		p.setPixel(3, 2, WHITE);
	
		
		SubPicture sp1 = p.extract(1,  1, 3, 2);
		
		
		Coordinate coord_a = new Coordinate(1, 1);
		Coordinate coord_b = new Coordinate(3, 2);
		SubPicture sp2 = p.extract(coord_a, coord_b);
		
		
		//check the expected pixels for sp1 
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 1), sp1.getPixel(0, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 1), sp1.getPixel(1, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 2), sp1.getPixel(0, 1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp1.getPixel(1, 1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(3, 1), sp1.getPixel(2, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(3, 2), sp1.getPixel(2, 1));
		
		//check the expected pixels for sp2
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 1), sp2.getPixel(0, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 1), sp2.getPixel(1, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 2), sp2.getPixel(0, 1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp2.getPixel(1, 1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(3, 1), sp2.getPixel(2, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(3, 2), sp2.getPixel(2, 1));
		
		//check that the subpictures are the correct size
		assertEquals("Subpicture has incorrect width", 3, sp1.getWidth());
		assertEquals("Subpicture has incorrect width", 3, sp2.getWidth());
		assertEquals("Subpicture has incorrect height", 2, sp1.getHeight());
		assertEquals("Subpicture has incorrect height", 2, sp2.getHeight());
	}
	
	@Test
	public void iteratorTest(){
		Picture p = new PictureImpl(3,3);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, BLUE);
		p.setPixel(2, 0, BLACK);
		p.setPixel(0, 1, BLUE);
		p.setPixel(1, 1, GREEN);
		p.setPixel(2, 1, WHITE);
		p.setPixel(0, 2, GREEN);
		p.setPixel(1, 2, RED);
		p.setPixel(2, 2, BLACK);
		Iterator <Pixel> iter = p.iterator();

		assertEquals("Pixel doesn't match", p.getPixel(0, 0), iter.next());
		assertEquals("Pixel doesn't match", p.getPixel(1, 0), iter.next());
		assertEquals("Pixel doesn't match", p.getPixel(2, 0), iter.next());
		assertEquals("Pixel doesn't match", p.getPixel(0, 1), iter.next());
		assertEquals("Pixel doesn't match", p.getPixel(1, 1), iter.next());
		assertEquals("Pixel doesn't match", p.getPixel(2, 1), iter.next());
		assertEquals("Pixel doesn't match", p.getPixel(0, 2), iter.next());
		assertEquals("Pixel doesn't match", p.getPixel(1, 2), iter.next());
		assertEquals("Pixel doesn't match", p.getPixel(2, 2), iter.next());
		
		
	}
	
}
