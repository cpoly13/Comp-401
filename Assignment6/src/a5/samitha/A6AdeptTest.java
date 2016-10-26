package a5.samitha;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);
    private static Picture PIC = new PictureImpl(4, 4);

    private Picture PictureMaker() {
	PIC.setPixel(0, 0, RED);
	PIC.setPixel(1, 0, GREEN);
	PIC.setPixel(2, 0, BLUE);
	PIC.setPixel(3, 0, RED);
	PIC.setPixel(0, 1, GREEN);
	PIC.setPixel(1, 1, BLUE);
	PIC.setPixel(2, 1, RED);
	PIC.setPixel(3, 1, GREEN);
	PIC.setPixel(0, 2, BLUE);
	PIC.setPixel(1, 2, RED);
	PIC.setPixel(2, 2, GREEN);
	PIC.setPixel(3, 2, BLUE);
	PIC.setPixel(0, 3, WHITE);
	PIC.setPixel(1, 3, WHITE);
	PIC.setPixel(2, 3, BLACK);
	PIC.setPixel(3, 3, BLACK);
	return PIC;
    }

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testSample";
	test_names[1] = "testWindow";
	test_names[2] = "testTile";

	return test_names;
    }

    @Test
    public void testSample() {
	Picture p = this.PictureMaker();
	Iterator<Pixel> testSampleIterator = p.sample(0, 0, 2, 1);

	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testSampleIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testSampleIterator.next(), RED);
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testSampleIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testSampleIterator.next(), BLUE);
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testSampleIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testSampleIterator.next(), GREEN);
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testSampleIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testSampleIterator.next(), RED);

	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testSampleIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testSampleIterator.next(), BLUE);
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testSampleIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testSampleIterator.next(), GREEN);
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testSampleIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testSampleIterator.next(), WHITE);
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testSampleIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testSampleIterator.next(), BLACK);

	assertEquals("Pixel retrieved from iterator does exist, which is supposed to not exist",
		testSampleIterator.hasNext(), false);

    }

    @Test
    public void testWindow() {
	Picture p = this.PictureMaker();
	Iterator<SubPicture> testWindowIterator = p.window(3, 2);

	SubPicture a = p.extract(0, 0, 3, 2);
	SubPicture b = p.extract(1, 0, 3, 2);
	SubPicture c = p.extract(0, 1, 3, 2);
	SubPicture d = p.extract(1, 1, 3, 2);
	SubPicture e = p.extract(0, 2, 3, 2);
	SubPicture f = p.extract(1, 2, 3, 2);

	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testWindowIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testWindowIterator.next().getPixel(0, 0), a.getPixel(0, 0));
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testWindowIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testWindowIterator.next().getPixel(1, 0), b.getPixel(1, 0));
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testWindowIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testWindowIterator.next().getPixel(2, 0), c.getPixel(2, 0));
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testWindowIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testWindowIterator.next().getPixel(0, 1), d.getPixel(0, 1));
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testWindowIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testWindowIterator.next().getPixel(1, 1), e.getPixel(1, 1));
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testWindowIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testWindowIterator.next().getPixel(2, 1), f.getPixel(2, 1));
	assertEquals("Pixel retrieved from iterator does exist, which is supposed to not exist",
		testWindowIterator.hasNext(), false);
    }

    @Test
    public void testTile() {
	Picture p = this.PictureMaker();
	Iterator<SubPicture> testTileIterator = p.tile(2, 2);

	SubPicture a = p.extract(0, 0, 2, 2);
	SubPicture b = p.extract(2, 0, 2, 2);
	SubPicture c = p.extract(0, 2, 2, 2);
	SubPicture d = p.extract(2, 2, 2, 2);

	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testTileIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testTileIterator.next().getPixel(0, 0), a.getPixel(0, 0));
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testTileIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testTileIterator.next().getPixel(1, 0), b.getPixel(1, 0));
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testTileIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testTileIterator.next().getPixel(0, 1), c.getPixel(0, 1));
	assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist",
		testTileIterator.hasNext(), true);
	assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
		testTileIterator.next().getPixel(1, 1), d.getPixel(1, 1));
	assertEquals("Pixel retrieved from iterator does exist, which is supposed to not exist",
		testTileIterator.hasNext(), false);

    }

}
