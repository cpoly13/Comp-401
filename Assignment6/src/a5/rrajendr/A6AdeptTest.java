package a5.rrajendr;

import org.junit.Assert; 
import java.util.Iterator;
import org.junit.Test;
import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {


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

		String[] test_names = {"testIteratorSample", "testIteratorTile"};

		return test_names;
	}

	@Test
	public void testIteratorSample() {
		Picture source = this.testSource();
		Iterator<Pixel> sampleIterator = source.sample(0, 0, 1, 2);
		Assert.assertTrue((boolean)sampleIterator.hasNext());
		Assert.assertEquals((String)"Next pixel was unexpected", (Object)RED, (Object)sampleIterator.next());
		Assert.assertTrue((boolean)sampleIterator.hasNext());
		Assert.assertEquals((String)"Next pixel was unexpected", (Object)RED, (Object)sampleIterator.next());
		Assert.assertTrue((boolean)sampleIterator.hasNext());
		Assert.assertEquals((String)"Next pixel was unexpected", (Object)RED, (Object)sampleIterator.next());
		Assert.assertTrue((boolean)sampleIterator.hasNext());
		Assert.assertEquals((String)"Next pixel was unexpected", (Object)RED, (Object)sampleIterator.next());
		Assert.assertTrue((boolean)sampleIterator.hasNext());
		Assert.assertEquals((String)"Next pixel was unexpected", (Object)BLACK, (Object)sampleIterator.next());
		Assert.assertTrue((boolean)sampleIterator.hasNext());
		Assert.assertEquals((String)"Next pixel was unexpected", (Object)BLACK, (Object)sampleIterator.next());
		Assert.assertTrue((boolean)sampleIterator.hasNext());
		Assert.assertEquals((String)"Next pixel was unexpected", (Object)WHITE, (Object)sampleIterator.next());
		Assert.assertTrue((boolean)sampleIterator.hasNext());
		Assert.assertEquals((String)"Next pixel was unexpected", (Object)WHITE, (Object)sampleIterator.next());
		Assert.assertFalse((boolean)sampleIterator.hasNext());   
	}

	@Test
	public void testIteratorTile() {
		Picture source = this.testSource();
		Iterator<SubPicture> tileIterator = source.tile(2, 2);
		
		Assert.assertTrue((boolean)tileIterator.hasNext());
		Picture subSourceOne = tileIterator.next();

        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(A), (Object)subSourceOne.getPixel(A));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(B), (Object)subSourceOne.getPixel(B));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(E), (Object)subSourceOne.getPixel(E));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(F), (Object)subSourceOne.getPixel(F));
        
		Assert.assertTrue((boolean)tileIterator.hasNext());
		Picture subSourceTwo = tileIterator.next();

        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(C), (Object)subSourceTwo.getPixel(A));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(D), (Object)subSourceTwo.getPixel(B));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(G), (Object)subSourceTwo.getPixel(E));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(H), (Object)subSourceTwo.getPixel(F));
        
		Assert.assertTrue((boolean)tileIterator.hasNext());
		Picture subSourceThree = tileIterator.next();
		
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(I), (Object)subSourceThree.getPixel(A));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(J), (Object)subSourceThree.getPixel(B));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(M), (Object)subSourceThree.getPixel(E));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(N), (Object)subSourceThree.getPixel(F));
        
		
		Assert.assertTrue((boolean)tileIterator.hasNext());
		Picture subSourceFour = tileIterator.next();

        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(K), (Object)subSourceFour.getPixel(A));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(L), (Object)subSourceFour.getPixel(B));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(O), (Object)subSourceFour.getPixel(E));
        Assert.assertEquals((String)"Next pixel was unexpected", (Object)source.getPixel(P), (Object)subSourceFour.getPixel(F));
        
        Assert.assertFalse((boolean)tileIterator.hasNext());

	}

}
