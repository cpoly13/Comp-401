package a5.mcanders;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "coordinateTest";
		test_names[1]="iteratorTest";
		
		return test_names;
	}
	
	
	static Pixel pOne= new ColorPixel(.333,.333,.333);
	static Pixel pTwo= new GrayPixel(.5);
	static Pixel pThree= new ColorPixel(.567,.125,.321);
	static Pixel pFour= new GrayPixel(0.0);
	
	static Picture p= new PictureImpl(2,2);
	static Picture c= new PictureImpl(2,2); 
	
	static Coordinate c1=new Coordinate(0,0);
	static Coordinate c2=new Coordinate(0,1);
	static Coordinate c3=new Coordinate(1,0);
	static Coordinate c4=new Coordinate(1,1);
		
	@Test
	public void coordinateTest() {
		
		c.setPixel(c1,pOne);
		c.setPixel(c2,pTwo);
		c.setPixel(c3,pThree);
		c.setPixel(c4,pFour);
		
		p.setPixel(0,0,pOne);
		p.setPixel(0,1,pTwo);
		p.setPixel(1,0,pThree);
		p.setPixel(1,1,pFour);
		
		assertEquals("Pixels do not match",c.getPixel(c1),p.getPixel(0,0));
		assertEquals("Pixels do not match",c.getPixel(c2),p.getPixel(0,1));
		assertEquals("Pixels do not match",c.getPixel(c3),p.getPixel(1,0));
		assertEquals("Pixels do not match",c.getPixel(c4),p.getPixel(1,1));
	}
	
	@Test
	public void iteratorTest(){
		
		p.setPixel(0,0,pOne);
		p.setPixel(0,1,pTwo);
		p.setPixel(1,0,pThree);
		p.setPixel(1,1,pFour);
		
		Iterator<Pixel>pitt=p.iterator();
	
			assertEquals("Iterator is broken",pitt.next().getIntensity(),pOne.getIntensity(),.0001);
			assertEquals("Iterator is broken",pitt.next().getIntensity(),pThree.getIntensity(),.0001);
			assertEquals("Iterator is broken",pitt.next().getIntensity(),pTwo.getIntensity(),.0001);
			assertEquals("Iterator is broken",pitt.next().getIntensity(),pFour.getIntensity(),.0001);
	}
}

