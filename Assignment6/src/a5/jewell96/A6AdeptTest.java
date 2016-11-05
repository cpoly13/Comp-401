package a5.jewell96;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;
import a6adept.SubPictureImpl;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "sampleIteratorTest";
	test_names[1] = "windowIteratorTest";
	test_names[2] = "tileIteratorTest";

	return test_names;
    }

    @Test
    public void sampleIteratorTest() {
	Picture source = new PictureImpl(15, 10);
	Iterator<Pixel> testPixelIterator = source.sample(2, 3, 3, 4);
	assertEquals("Iterator values incorrect for sample method", testPixelIterator.next(), source.getPixel(2, 3));
    }

    @Test
    public void windowIteratorTest() {
	Picture source = new PictureImpl(5, 5);
	SubPicture sourceSub = new SubPictureImpl(source, 1, 1, 3, 2);
	Iterator<SubPicture> windowIterator = source.window(3, 2);
	assertTrue(windowIterator.next().getXOffset() == sourceSub.extract(0, 0, 3, 2).getXOffset());
    }

    @Test
    public void tileIteratorTest() {
	Picture source = new PictureImpl(5, 5);
	SubPicture tileSub = new SubPictureImpl(source, 1, 1, 3, 2);
	Iterator<SubPicture> tileIterator = source.tile(2, 2);
	assertTrue(tileIterator.next().getYOffset() == tileSub.extract(0, 0, 2, 2).getYOffset());
    }
}
