package a5.connorca;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel white = new GrayPixel(1.0);
	private static final Pixel black = new GrayPixel(0.0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "testExtractMethod";
		test_names[1] = "testIterator";
		
		return test_names;
	}
			
	@Test
	public void testExtractMethod(){
		Picture p1= new PictureImpl(4,4);
		/*sets all even x-coordinates in original picture to white pixel
		and sets all odd x-coordinates in original picture to black pixel */
		for(int i=0; i<p1.getHeight()-1; i++){
			for(int j=0; j<p1.getWidth()-1;j++){
				if(j%2==0){
					p1.setPixel(j,i,white);
				} else {
					p1.setPixel(j,i,black);
				}
			}
		}
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(2,2);
		Coordinate c3 = new Coordinate(3,3);
		
		SubPicture s1 = p1.extract(c1,c2);
		assertEquals(3,s1.getHeight());
		assertEquals(3,s1.getWidth());
		assertEquals(white, s1.getPixel(2,2));
		
		SubPicture s2 = p1.extract(c2,c3);
		assertEquals(2,s2.getHeight());
		assertEquals(2,s2.getWidth());
		assertEquals(white, s2.getPixel(0,0));
		
		
		
	}
	@Test
	public void testIterator(){
		Picture p = new PictureImpl(2,2);
		p.setPixel(0, 0, white);
		p.setPixel(1, 0, black);
		p.setPixel(0, 1, black);
		p.setPixel(1, 1, white);
		
		Iterator<Pixel> iter = p.iterator();
		Pixel p1 = iter.next();
		Pixel p2 = iter.next();
		Pixel p3 = iter.next();
		Pixel p4 = iter.next();
		
		assertEquals(white,p1);
		assertEquals(black,p2);
		assertEquals(black,p3);
		assertEquals(white,p4);
		
	try{
		for(int i=0; i<4; i++){
			iter.next();
		}
		iter.hasNext();
		fail("there should be no element left in the list");
	} catch(java.util.NoSuchElementException e) {		
	} catch(RuntimeException e) {
		fail("wrong type of exception");
	}
	}
	
}
