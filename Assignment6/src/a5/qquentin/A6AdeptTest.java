package a5.qquentin;

//Steven Sin and Krishan Patel

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
	public static final Pixel RED = new ColorPixel(1,0,0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "exampleTest";
		test_names[1] = "sampleTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void sampleTest() {
		Picture p =  new PictureImpl(10,6);
		int x = 2;
		int y = 3;
		int dx = 3;
		int dy = 4;
		Iterator<Pixel> iteratorTest = p.sample(x,y,dx,dy);
		while(iteratorTest.hasNext()) {
			p.setPixel(x,y, RED);
			if(x + dx < p.getWidth()) {
				x += dx;	
			} else {
				y += dy;
				x += dx;
			}
			assertEquals(iteratorTest.next(), RED);
		}
		
		
	}
}

