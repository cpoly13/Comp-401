package a5.markp;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testSample";

	return test_names;
    }

    @Test
    public void testSample() {
	Picture p = new PictureImpl(5, 5);
	Iterator<Pixel> sampleIter = p.sample(0, 0, 1, 1); // normal iterator
							   // pattern test
	Iterator<Pixel> normalIter = p.iterator();
	while (sampleIter.hasNext()) {
	    assertEquals("Sample iterator constructed as a normal iterator does not match expected outputs",
		    sampleIter.next(), normalIter.next());
	}

	Picture picTest1 = new PictureImpl(10, 10);
	Iterator<Pixel> sampleIter1 = picTest1.sample(2, 2, 3, 3);

	picTest1.setPixel(2, 2, GREEN);
	picTest1.setPixel(5, 2, BLUE);
	picTest1.setPixel(8, 2, BLACK);
	picTest1.setPixel(2, 5, RED);
	picTest1.setPixel(5, 5, GREEN);
	picTest1.setPixel(8, 5, WHITE);
	picTest1.setPixel(2, 8, RED);
	picTest1.setPixel(5, 8, WHITE);
	picTest1.setPixel(8, 8, BLACK);

	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(2, 2));
	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(5, 2));
	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(8, 2));
	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(2, 5));
	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(5, 5));
	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(8, 5));
	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(2, 8));
	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(5, 8));
	assertEquals("Values from iterator do not match expected values", sampleIter1.next(), picTest1.getPixel(8, 8));

	Picture picTest2 = new PictureImpl(3, 9);
	Iterator<Pixel> sampleIter2 = picTest2.sample(1, 2, 1, 3);

	picTest2.setPixel(1, 2, GREEN);
	picTest2.setPixel(2, 2, BLUE);
	picTest2.setPixel(1, 5, BLACK);
	picTest2.setPixel(2, 5, RED);
	picTest2.setPixel(1, 8, GREEN);
	picTest2.setPixel(2, 8, WHITE);

	assertEquals("Values from iterator do not match expected values", sampleIter2.next(), picTest2.getPixel(1, 2));
	assertEquals("Values from iterator do not match expected values", sampleIter2.next(), picTest2.getPixel(2, 2));
	assertEquals("Values from iterator do not match expected values", sampleIter2.next(), picTest2.getPixel(1, 5));
	assertEquals("Values from iterator do not match expected values", sampleIter2.next(), picTest2.getPixel(2, 5));
	assertEquals("Values from iterator do not match expected values", sampleIter2.next(), picTest2.getPixel(1, 8));
	assertEquals("Values from iterator do not match expected values", sampleIter2.next(), picTest2.getPixel(2, 8));

	Picture picTest3 = new PictureImpl(25, 25);
	Iterator<Pixel> sampleIter3 = picTest3.sample(2, 20, 10, 2);

	picTest3.setPixel(2, 20, GREEN);
	picTest3.setPixel(12, 20, BLUE);
	picTest3.setPixel(22, 20, BLACK);
	picTest3.setPixel(2, 22, RED);
	picTest3.setPixel(12, 22, GREEN);
	picTest3.setPixel(22, 22, WHITE);
	picTest3.setPixel(2, 24, GREEN);
	picTest3.setPixel(12, 24, BLUE);
	picTest3.setPixel(22, 24, BLACK);

	assertEquals("Values from iterator do not match expected values", sampleIter3.next(), picTest3.getPixel(2, 20));
	assertEquals("Values from iterator do not match expected values", sampleIter3.next(),
		picTest3.getPixel(12, 20));
	assertEquals("Values from iterator do not match expected values", sampleIter3.next(),
		picTest3.getPixel(22, 20));
	assertEquals("Values from iterator do not match expected values", sampleIter3.next(), picTest3.getPixel(2, 22));
	assertEquals("Values from iterator do not match expected values", sampleIter3.next(),
		picTest3.getPixel(12, 22));
	assertEquals("Values from iterator do not match expected values", sampleIter3.next(),
		picTest3.getPixel(22, 22));
	assertEquals("Values from iterator do not match expected values", sampleIter3.next(), picTest3.getPixel(2, 24));
	assertEquals("Values from iterator do not match expected values", sampleIter3.next(),
		picTest3.getPixel(12, 24));
	assertEquals("Values from iterator do not match expected values", sampleIter3.next(),
		picTest3.getPixel(22, 24));

    }

}
