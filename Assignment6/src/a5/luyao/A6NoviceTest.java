package a5.luyao;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "exampleTest";
		test_names[1] = "testSetPixelANDGetPixel";
		test_names[2] = "testPictureExtract";
		test_names[3] = "testIteratorA";
		test_names[4] = "testIteratorB";
		
		return test_names;
	}
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Coordinate X = new Coordinate (1, 2);
	private static final Coordinate Y = new Coordinate (4, 5);
	private static final Coordinate Z = new Coordinate (7, 5);
		
	@Test
	public void exampleTest() {
	}
	
	// test1: test the new method of setting pixel
	@Test
	public void testSetPixelANDGetPixel() {
		Picture a = new PictureImpl(8,6);
		a.setPixel(X, RED);
		a.setPixel(Y, BLUE);
		a.setPixel(Z, GREEN);
		assertEquals("Pixel on coordinate X from picture a is different with the pixel setted",
				RED, a.getPixel(X));
		assertEquals("Pixel on coordinate Y from picture a is different with the pixel setted",
				BLUE, a.getPixel(Y));
		assertEquals("Pixel on coordinate Z from picture a is different with the pixel setted",
				GREEN, a.getPixel(Z));
	}
	
	@Test
	public void testPictureExtract(){
		Picture a = new PictureImpl(8,6);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				a.setPixel(i, j, BLUE);
			}
		}
		for (int i = 4; i < 8; i++) {
			for (int j = 0; j < 6; j++) {
				a.setPixel(i, j, GREEN);
			}
		}
		for (int i = 2; i < 4; i++) {
			for (int j = 2; j < 4; j++) {
				a.setPixel(i, j, RED);
			}
		}
		
		Picture b = a.extract(X, Z);
		
		assertEquals("Pixel from original Picture a is different from corresponding pixel in the subPicture b",
				a.getPixel(X),b.getPixel(0,0));
		assertEquals("Pixel from original Picture a is different from corresponding pixel in the subPicture b",
				a.getPixel(Y),b.getPixel(4,3));
		assertEquals("Pixel from original Picture a is different from corresponding pixel in the subPicture b",
				a.getPixel(Z),b.getPixel(5,3));
	}
	
	@Test
	public void testIteratorA(){
		Picture b = new PictureImpl(3,2);
		b.setPixel(0, 0, RED);
		b.setPixel(1, 0, GREEN);
		b.setPixel(2, 0, BLUE);
		b.setPixel(2, 1, GREEN);
		b.setPixel(1, 1, BLUE);
		b.setPixel(0, 1, RED);
		
		
		Iterator<Pixel> it = b.iterator();
		assertEquals("1st pixel get by the iterator is wrong", 
			      RED, it.next());
		assertEquals("2nd pixel get by the iterator is wrong", 
				 GREEN, it.next());
		assertEquals("3rd pixel get by the iterator is wrong", 
				BLUE, it.next());	
		assertEquals("4th pixel get by the iterator is wrong", 
			      RED, it.next());
		assertEquals("5th pixel get by the iterator is wrong", 
				BLUE, it.next());
		assertEquals("6th pixel get by the iterator is wrong", 
				 GREEN, it.next());
	}
	
	@Test
	public void testIteratorB(){
		Picture b = new PictureImpl(3,2);
		b.setPixel(0, 0, RED);
		b.setPixel(1, 0, GREEN);
		b.setPixel(2, 0, BLUE);
		b.setPixel(2, 1, GREEN);
		b.setPixel(1, 1, BLUE);
		b.setPixel(0, 1, RED);
		
		
		Iterator<Pixel> it = b.iterator();
		assertTrue("iterator unexpected end", 
			      it.hasNext());
		it.next();
		assertTrue("iterator unexpected end", 
				  it.hasNext());
		it.next();
		assertTrue("iterator unexpected end", 
				  it.hasNext());	
		it.next();
		assertTrue("iterator unexpected end", 
			      it.hasNext());
		it.next();
		assertTrue("iterator unexpected end", 
				  it.hasNext());
		it.next();
		assertTrue("iterator unexpected end", 
				  it.hasNext());
		it.next();
		assertFalse("iterator unexpected Pixel", 
				  it.hasNext());
	}
	
	
}
