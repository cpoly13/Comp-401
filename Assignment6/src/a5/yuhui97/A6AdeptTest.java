package a5.yuhui97;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "testSampleIterator";
	test_names[1] = "testWindowIterator";

	return test_names;
    }

    @Test
    public void testSampleIterator() {
	Picture source = new PictureImpl(3, 3);
	source.setPixel(0, 0, RED);
	source.setPixel(1, 0, GREEN);
	source.setPixel(2, 0, BLUE);
	source.setPixel(0, 1, RED);
	source.setPixel(1, 1, GREEN);
	source.setPixel(2, 1, BLUE);
	source.setPixel(0, 2, RED);
	source.setPixel(1, 2, GREEN);
	source.setPixel(2, 2, BLUE);

	Iterator<Pixel> sourceSampleIterator = source.sample(1, 1, 1, 1);

	assertEquals("Iterator does not retrieve correct sample", GREEN, sourceSampleIterator.next());

	assertEquals("Iterator does not retrieve correct sample", BLUE, sourceSampleIterator.next());

	assertEquals("Iterator does not retrieve correct sample", GREEN, sourceSampleIterator.next());

	assertEquals("Iterator does not retrieve correct sample", BLUE, sourceSampleIterator.next());
    }

    @Test
    public void testWindowIterator() {
	Picture source = new PictureImpl(3, 3);
	source.setPixel(0, 0, RED);
	source.setPixel(1, 0, GREEN);
	source.setPixel(2, 0, BLUE);
	source.setPixel(0, 1, RED);
	source.setPixel(1, 1, GREEN);
	source.setPixel(2, 1, BLUE);
	source.setPixel(0, 2, RED);
	source.setPixel(1, 2, GREEN);
	source.setPixel(2, 2, BLUE);

	Iterator<SubPicture> sourceWindowIterator = source.window(2, 2);

	// (0, 0) (0, 1) (1, 0), (1, 1)
	Picture subpic1 = sourceWindowIterator.next();
	assertEquals("Iterator does not retrieve correct window", source.getPixel(0, 0), subpic1.getPixel(0, 0));
	assertEquals("Iterator does not retrieve correct window", source.getPixel(1, 0), subpic1.getPixel(1, 0));
	assertEquals("Iterator does not retrieve correct window", source.getPixel(0, 1), subpic1.getPixel(0, 1));
	assertEquals("Iterator does not retrieve correct window", source.getPixel(1, 1), subpic1.getPixel(1, 1));
    }
}
