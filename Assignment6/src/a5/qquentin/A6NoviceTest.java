package a5.qquentin;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;
//Steven Sin & Krishan Patel

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "exampleTest";
		test_names[1] = "testIteratorPixel";
		test_names[2] = "testSetAndGetPixel";
		test_names[3] = "testExtract";
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void testIteratorPixel() {
		Picture p = new PictureImpl(2,2);
		Iterator<Pixel> iteratingPixel = p.iterator();
		assertEquals("hasNext is not working", iteratingPixel.hasNext(), true);
		assertEquals("Wrong Pixels", iteratingPixel.next(), p.getPixel(0,0));
	}
	@Test
	public void testSetAndGetPixel() {
		Picture p = new PictureImpl(2,2);
		Pixel e = new ColorPixel(1,1,1);
		p.setPixel(0,0,e);
		assertEquals(e,p.getPixel(0,0));
		
	}
	@Test
	public void testExtract() {
		Picture p = new PictureImpl(5,5);
		Coordinate d = new Coordinate(1,1);
		Coordinate e = new Coordinate(3,3);
		SubPicture testSubPic = p.extract(d, e);
		assertEquals(3,testSubPic.getWidth());
	}
}
