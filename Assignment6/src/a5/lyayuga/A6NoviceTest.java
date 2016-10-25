package a5.lyayuga;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


import a6novice.*;

public class A6NoviceTest {
		
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private Picture p = new PictureImpl(6,5);
	
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "exampleTest";
		test_names[1] = "ovldgetpixelTest";
		test_names[2] ="ovldsetngetpixelTest";
		test_names[3] ="rowmajorpixeliteratoTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	@Test
	public void ovldgetpixelTest (){
	Coordinate tc = new Coordinate (3,3);
	p.setPixel(3, 3, RED);
	assertTrue(RED.equals(p.getPixel(tc)));
	
		
	}
	@Test
	public void ovldsetngetpixelTest (){
		Coordinate tc = new Coordinate (2,4);
		p.setPixel(tc, BLUE);
		assertTrue(BLUE.equals(p.getPixel(tc)));
		
	}
	
	@Test
	public void rowmajorpixeliteratoTest() {
		//next() True test at arbitrary point in picture
		Iterator<Pixel> iter = p.iterator();
		p.setPixel(3, 2, BLUE);
		for (int i=0; i<15;i++ ){
			iter.next();
		}
		assertTrue(iter.next().equals(p.getPixel(3,2)));
		
		//hasNext() true test
		assertTrue(iter.hasNext());
		
		//hasNext() false test with next() usage
		Picture p2 = new PictureImpl(1,1);
		Iterator<Pixel> iter2 = p2.iterator();
		iter2.next();
		assertFalse(iter2.hasNext());
		
	}
	
}
