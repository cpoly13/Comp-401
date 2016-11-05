package a5.cahemmer;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[6];

	test_names[0] = "exampleTest";
	test_names[1] = "getPixelTest";
	test_names[2] = "setPixelTest";
	test_names[3] = "extractTest";
	test_names[4] = "hasNextTest";
	test_names[5] = "nextTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void getPixelTest() {
	PictureImpl test = new PictureImpl(5, 5);

	ColorPixel colored = new ColorPixel(.5, .2, .5);
	Coordinate location = new Coordinate(3, 3);

	test.setPixel(location, colored);

	assertEquals("Pixel does not get", test.getPixel(location), colored);
    }

    @Test
    public void setPixelTest() {
	PictureImpl test = new PictureImpl(3, 3);

	ColorPixel colored = new ColorPixel(.1, .4, .8);
	Coordinate location = new Coordinate(1, 1);

	test.setPixel(location, colored);

	assertEquals("Pixel does not set", test.getPixel(location), colored);
    }

    @Test
    public void extractTest() {

	Picture test = new PictureImpl(3, 3);

	Coordinate topLeft = new Coordinate(1, 1);
	Coordinate bottomRight = new Coordinate(2, 2);

	test.setPixel(0, 0, new ColorPixel(.1, .5, .5));
	test.setPixel(0, 1, new ColorPixel(.2, .5, .5));
	test.setPixel(0, 2, new ColorPixel(.3, .5, .5));
	test.setPixel(1, 0, new ColorPixel(.4, .5, .5));
	test.setPixel(1, 1, new ColorPixel(.5, .5, .5));
	test.setPixel(1, 2, new ColorPixel(.6, .5, .5));
	test.setPixel(2, 0, new ColorPixel(.7, .5, .5));
	test.setPixel(2, 1, new ColorPixel(.8, .5, .5));
	test.setPixel(2, 2, new ColorPixel(.9, .5, .5));

	SubPicture subPic = test.extract(topLeft, bottomRight);

	assertEquals("Should be equal", test.getPixel(1, 1), subPic.getPixel(0, 0));
	assertEquals("Should be equal", test.getPixel(2, 1), subPic.getPixel(1, 0));
	assertEquals("Should be equal", test.getPixel(1, 2), subPic.getPixel(0, 1));
	assertEquals("Should be equal", test.getPixel(2, 2), subPic.getPixel(1, 1));

    }

    @Test
    public void hasNextTest() {
	Picture test = new PictureImpl(3, 3);

	Iterator<Pixel> iterator = test.iterator();

	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be true", iterator.hasNext(), true);
	iterator.next();
	assertEquals("Should be false", iterator.hasNext(), false);
    }

    @Test
    public void nextTest() {
	Picture test = new PictureImpl(3, 3);
	Iterator<Pixel> iterator = test.iterator();

	test.setPixel(0, 2, new ColorPixel(.2, .5, .7));

	for (int y = 0; y < test.getHeight(); y++) {
	    for (int x = 0; x < test.getWidth(); x++) {
		assertEquals("Next does not give next pixel", iterator.next(), test.getPixel(x, y));
	    }
	}
    }

}
