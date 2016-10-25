package a5.rrajendr;


import java.util.Iterator;
import org.junit.Test;
import org.junit.Assert;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;
import java.util.Iterator;


public class A6NoviceTest {
		

	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	private static final Coordinate A = new Coordinate(0,0);
	private static final Coordinate B = new Coordinate(1,0);
	private static final Coordinate C = new Coordinate(2,0);
	private static final Coordinate D = new Coordinate(3,0);
	private static final Coordinate E = new Coordinate(0,1);
	private static final Coordinate F = new Coordinate(1,1);
	private static final Coordinate G = new Coordinate(2,1);
	private static final Coordinate H = new Coordinate(3,1);
	private static final Coordinate I = new Coordinate(0,2);
	private static final Coordinate J = new Coordinate(1,2);
	private static final Coordinate K = new Coordinate(2,2);
	private static final Coordinate L = new Coordinate(3,2);
	private static final Coordinate M = new Coordinate(0,3);
	private static final Coordinate N = new Coordinate(1,3);
	private static final Coordinate O = new Coordinate(2,3);
	private static final Coordinate P = new Coordinate(3,3);

	
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
		String[] test_names ={"testSubPicGetPixelCoordinate", "testIteratorNovice"};
		
		return test_names;
	}
		
	@Test
	public void testSubPicGetPixelCoordinate() {
		Picture source = this.testSource();
		SubPicture sp = source.extract(F,P); 
		
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(F), (Object)sp.getPixel(A));
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(G), (Object)sp.getPixel(B));
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(H), (Object)sp.getPixel(C));
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(J), (Object)sp.getPixel(E));
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(K), (Object)sp.getPixel(F));
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(L), (Object)sp.getPixel(G));
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(N), (Object)sp.getPixel(I));
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(O), (Object)sp.getPixel(J));
        Assert.assertEquals((String)"Pixel returned from Subpicture not same value as corresponding pixel from Source.",
        		(Object)source.getPixel(P), (Object)sp.getPixel(K));

	}
	
	@Test
	public void testIteratorNovice() {
		Picture source = this.testSource();
        Iterator<Pixel> noviceIterator = source.iterator();
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)RED, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)RED, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)RED, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)RED, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)GREEN, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLUE, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)GREEN, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLUE, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLACK, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLACK, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)WHITE, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)WHITE, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)GREEN, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLUE, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)BLACK, noviceIterator.next());
        Assert.assertTrue((boolean)noviceIterator.hasNext());
        Assert.assertEquals((String)"Next pixel retrieved by iterator is not expected pixel", 
        		(Object)WHITE, noviceIterator.next());
        Assert.assertFalse((boolean)noviceIterator.hasNext());
	}
}
