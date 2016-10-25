package a5.austin1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		test_names[2] = "tileTest";
		
		return test_names;
	}
		
	@Test
	public void sampleTest() {
		Picture testPic = new PictureImpl(15, 10);
		Iterator<Pixel> sampler = testPic.sample(2, 3, 3, 4);
		
		testPic.setPixel(5, 3, RED);
		testPic.setPixel(11, 3, GREEN);
		testPic.setPixel(2, 7, BLUE);
		testPic.setPixel(8, 7, GREEN);
		testPic.setPixel(14, 7, RED);
		
		sampler.next();
		assertEquals(sampler.next(), RED);
		sampler.next();
		assertEquals(sampler.next(), GREEN);
		sampler.next();
		assertEquals(sampler.next(), BLUE);
		sampler.next();
		assertEquals(sampler.next(), GREEN);
		sampler.next();
		assertEquals(sampler.next(), RED);
	}
	
	@Test
	public void windowTest() {
		Picture p = new PictureImpl(5,5);
		Iterator<SubPicture> windower = p.window(3, 2);
		
		assertEquals(windower.next().getPixel(1,1), p.extract(0,0,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(1,0,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(2,0,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(0,1,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(1,1,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(2,1,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(0,2,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(1,2,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(2,2,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(0,3,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(1,3,3,2).getPixel(1,1));
		assertEquals(windower.next().getPixel(1,1), p.extract(2,3,3,2).getPixel(1,1));
		
	}
	
	@Test
	public void tileTest() {
		Picture p = new PictureImpl(5,5);
		Iterator<SubPicture> tiler = p.window(3, 2);
		
		assertEquals(tiler.next().getPixel(1,1),p.extract(0,0,2,2).getPixel(1,1));
		assertEquals(tiler.next().getPixel(1,1),p.extract(2,0,2,2).getPixel(1,1));
		assertEquals(tiler.next().getPixel(1,1),p.extract(0,2,2,2).getPixel(1,1));
		assertEquals(tiler.next().getPixel(1,1),p.extract(2,2,2,2).getPixel(1,1));
	}
}
