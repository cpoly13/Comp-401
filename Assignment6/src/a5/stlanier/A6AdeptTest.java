package a5.stlanier;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
	
	private final Pixel a = new ColorPixel(1, 1, 1);
	private final Pixel b = new ColorPixel(1, 1, 0);
	private final Pixel c = new ColorPixel(1, 0, 0);
	private final Pixel d = new ColorPixel(0, 0, 0);
	private final Pixel e = new ColorPixel(0.1, 0.2, 0.3);
	private Picture myPic = new PictureImpl(11, 11);
	
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "sampleIteratorTests";
		test_names[1] = "windowIteratorTests";
		test_names[2] = "tileIteratorTests";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
		
	}
	
	@Test
	public void sampleIteratorTests(){
		myPic.setPixel(5, 3, a);
		myPic.setPixel(5, 6, b);
		myPic.setPixel(9, 6, c);
		myPic.setPixel(5, 9, d);
		myPic.setPixel(9, 9, e);
		Iterator<Pixel> sampleIt = myPic.sample(5, 3, 4, 3);
		assertEquals("sampleIterator does not traverse picture accurately.", a, sampleIt.next());
		sampleIt.next();
		assertEquals("sampleIterator does not traverse picture accurately.", b, sampleIt.next());
		assertEquals("sampleIterator does not traverse picture accurately.", c, sampleIt.next());
		assertEquals("sampleIterator does not traverse picture accurately.", d, sampleIt.next());
		assertEquals("sampleIterator does not traverse picture accurately.", e, sampleIt.next());
		
		assertEquals("sampleIterator signifies final hasNext() incorrectly.", false, sampleIt.hasNext());
		
		try{
			sampleIt.next();
		} catch (java.util.NoSuchElementException e){
		} catch (RuntimeException e){
			fail("Expected NoSuchElementedException instead of generic RuntimeException.");
		}
		
	}
	
	@Test
	public void windowIteratorTests(){
		myPic.setPixel(5, 3, a);
		myPic.setPixel(5, 6, b);
		myPic.setPixel(9, 6, c);
		myPic.setPixel(5, 9, d);
		Iterator<SubPicture> windowIt = myPic.window(7, 9);
		assertEquals("windowIterator does not accurately frame Picture.", a, windowIt.next().getPixel(5, 3));
		windowIt.next();windowIt.next();windowIt.next();windowIt.next();
		assertEquals("windowIterator does not accurately traverse Picture.", b, windowIt.next().getPixel(5, 5));
		windowIt.next();windowIt.next();
		assertEquals("windowIterator does not accurately traverse Picture.", c, windowIt.next().getPixel(6, 5));
		windowIt.next();windowIt.next();windowIt.next();windowIt.next();windowIt.next();
		assertEquals("windowIterator does not accurately traverse Picture.", d, windowIt.next().getPixel(1, 7));
		assertEquals("windowIterator exceeds Picture boundaries.", false, windowIt.hasNext());
		
		try{
			windowIt.next();
		} catch (java.util.NoSuchElementException e){
		} catch (RuntimeException e){
			fail("Expected NoSuchElementedException instead of generic RuntimeException.");
		}
	}
	
	@Test
	public void tileIteratorTests(){
		myPic.setPixel(5, 3, a);
		myPic.setPixel(5, 6, b);
		myPic.setPixel(5, 9, d);
		Iterator<SubPicture> tileIt = myPic.tile(4, 2);
		tileIt.next();tileIt.next();tileIt.next();
		assertEquals("tileIterator does not accurately traverse Picture.", a, tileIt.next().getPixel(1,1));
		tileIt.next();tileIt.next();tileIt.next();
		assertEquals("tileIterator does not accurately traverse Picture.", b, tileIt.next().getPixel(1,0));
		tileIt.next();
		assertEquals("tileIterator does not accurately traverse Picture.", d, tileIt.next().getPixel(1,1));
		assertEquals("windowIterator exceeds Picture boundaries.", false, tileIt.hasNext());
		
		try{
			tileIt.next();
		} catch (java.util.NoSuchElementException e){
		} catch (RuntimeException e){
			fail("Expected NoSuchElementedException instead of generic RuntimeException.");
		}
	}
}
