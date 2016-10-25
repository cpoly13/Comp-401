package a5.saujas;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;



public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "iteratorExceptionTest";
		test_names[1] = "iteratorTest";
		
		return test_names;
	}
		
	@Test
	public void iteratorExceptionTest() {
		Picture p = new PictureImpl(5, 5);
		try
		{
			Iterator<Pixel> it = p.sample(10, 10, 1, 1);
			fail("Excepted RuntimeException for out of bound parameters");
		} catch (RuntimeException e)
		{
			
		}
		
	}
	
	@Test
	public void iteratorTest() {
		Picture p = new PictureImpl(5, 5);
		Iterator<SubPicture> it = p.window(5, 5);
		SubPicture itElem = it.next();
		SubPicture checkAgainst = p.extract(0,  0, 5, 5);
		assertTrue("Iterator does not return correct SubPicture", 
				comparePicture(checkAgainst, itElem));
		
		
	}
	
	private static boolean comparePixels(Pixel a, Pixel b) {
		return ((Math.abs(a.getRed()-b.getRed()) < 0.001) &&
				(Math.abs(a.getGreen()-b.getGreen()) < 0.001) &&
				(Math.abs(a.getBlue()-b.getBlue()) < 0.001));
	}
	
	private static boolean comparePicture(Picture a, Picture b) {
		boolean equality = false;
		Iterator<Pixel> itrA = a.iterator();
		Iterator<Pixel> itrB = b.iterator();
		while (itrA.hasNext() && itrB.hasNext())
		{
			equality |= comparePixels(itrA.next(), itrB.next());
		}
		if (itrB.hasNext() || itrA.hasNext())
		{
			equality = false;
		}
		
		return equality;
	}
	
}