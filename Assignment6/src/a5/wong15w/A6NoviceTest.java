package a5.wong15w;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "testCoordinateConstructor";
		test_names[1]="testOverloadedPictureMethods";
		test_names[2]="testIterator";
		return test_names;
	}
		
	@Test
	public void testCoordinateConstructor(){
		Coordinate p=new Coordinate(1,2);
		
		int xCoord=1;
		int yCoord=2;
		
		assertEquals("X coordinate do not match expected",xCoord,p.getX());
		assertEquals("Y coordinate do not match expected",yCoord,p.getY());
	}
	@Test
	public void testOverloadedPictureMethods(){
		Picture s=new PictureImpl(4,4); 
		Coordinate origin=new Coordinate(0,0);
		Coordinate p=new Coordinate(1,2);
		Pixel q=new ColorPixel(.2,.4,.3);
		s.setPixel(p, q);
		SubPicture extracted=s.extract(origin,p);
		assertEquals("Pixel does not match the pixel it was set to",q,s.getPixel(p));
		assertEquals("The extracted method did not extract correctly",q,extracted.getPixel(p));
	}
	@Test
	public void testIterator(){
		Picture it=new PictureImpl(2,2);
		
		Coordinate a=new Coordinate(0,0);
		Coordinate b=new Coordinate(1,0);
		Coordinate c=new Coordinate(0,1);
		Coordinate d=new Coordinate(1,1);
		ColorPixel aa=new ColorPixel(.1,.1,.1);
		ColorPixel bb=new ColorPixel(.2,.2,.2);
		ColorPixel cc=new ColorPixel(.3,.3,.3);
		ColorPixel dd=new ColorPixel(.4,.4,.4);
		
		it.setPixel(a,aa);
		it.setPixel(b, bb);
		it.setPixel(c, cc);
		it.setPixel(d, dd);
		
		Iterator<Pixel> picIt=it.iterator();
		double intensity[]=new double[4];
		int i=0;
		while(picIt.hasNext())
		{
			intensity[i]=picIt.next().getIntensity();
			i++;
		}
		double correctIntensity[]={.1,.2,.3,.4};
		assertTrue("Did not traverse the colleciton correctly",Arrays.equals(correctIntensity, intensity));
	}
}
