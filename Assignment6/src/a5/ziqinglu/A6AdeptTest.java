package a5.ziqinglu;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
	
		test_names[0] = "sampleiteratorTest";
		return test_names;
	}
		
	@Test
	public void SampleTest(){
		Picture p = new PictureImpl(15,15);
		for(int i = 0; i<p.getWidth()-1;i++){
			for(int j = 0; j <p.getHeight()-1;j++){
				p.setPixel(i, j, RED);
		}
		}
		Iterator<Pixel> sample_iter = p.sample(2,3,3,4);
		
//		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
//				   p.getPixel(new Coordinate(2,3)),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(2,3),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(5,3),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(8,3),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(11,3),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(14,3),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(2,7),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(5,7),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(8,7),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(11,7),sample_iter.next());
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				   p.getPixel(14,7),sample_iter.next());
	
	}
	}

