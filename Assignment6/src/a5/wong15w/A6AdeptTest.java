package a5.wong15w;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "iteratorTest";
		
		return test_names;
	}
		
	@Test
	public void iteratorTest(){
		Picture p=new PictureImpl(6,6);
		ColorPixel test=new ColorPixel(.9,.05,.05);
		Coordinate a=new Coordinate(0,0);
		Coordinate b=new Coordinate(5,0);
		Coordinate d=new Coordinate(0,5);
		Coordinate e=new Coordinate(5,5);
		p.setPixel(a, test);
		p.setPixel(b, test);
		p.setPixel(d, test);
		p.setPixel(e, test);
		Iterator<Pixel> testIter=p.sample(0, 0, 5, 5);
		double testIterArray[]=new double[4];
		int i=0;
		while(testIter.hasNext()){
			testIterArray[i]=testIter.next().getRed();
			i++;
		}
		double redIntensity[]={.9,.9,.9,.9};
		assertTrue("This is correct",Arrays.equals(redIntensity,testIterArray));
		

	}
}
