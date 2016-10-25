package a5.rrajendr;

import a6jedi.ColorPixel;
import a6jedi.GrayPixel;
import a6jedi.PictureImpl;
import a6jedi.Pixel;
import a6jedi.Picture;
import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;


public class A6JediTest {
	

	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	private Picture testSource() {
		PictureImpl p = new PictureImpl(4, 4);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(3, 0, RED);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, BLUE);
		p.setPixel(2, 1, GREEN);
		p.setPixel(3, 1, BLUE);
		p.setPixel(0, 2, BLACK);
		p.setPixel(1, 2, BLACK);
		p.setPixel(2, 2, WHITE);
		p.setPixel(3, 2, WHITE);
		p.setPixel(0, 3, GREEN);
		p.setPixel(1, 3, BLUE);
		p.setPixel(2, 3, BLACK);
		p.setPixel(3, 3, WHITE);
		return p;
	}
		
	static public String[] getTestNames() {
		String[] test_names = {"testIteratorZigZag"};
		
		return test_names;
	}
		
	@Test
	public void testIteratorZigZag() {
		Picture source = this.testSource();
        Iterator<Pixel> zzIterator = source.zigzag();
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)RED, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)RED, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)GREEN, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLACK, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLUE, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)RED, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)RED, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)GREEN, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLACK, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)GREEN, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLUE, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)WHITE, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLUE, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)WHITE, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLACK, zzIterator.next());
        Assert.assertTrue((boolean)zzIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)WHITE, zzIterator.next());
        Assert.assertFalse((boolean)zzIterator.hasNext());
	}
}
