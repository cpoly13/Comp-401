package a5.rarora9;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "setPixelTest";
	test_names[1] = "getPixelTest";
	test_names[2] = "extractTest";
	test_names[3] = "hasNextTest";
	test_names[4] = "nextTest";

	return test_names;
    }

    @Test
    public void setPixelTest() {
	Picture picture = new PictureImpl(5, 5);
	Coordinate coordinate = new Coordinate(2, 3);
	Pixel pixel = new ColorPixel(0.1, 0.2, 0.3);
	picture.setPixel(coordinate, pixel);
	assertTrue(pixel.equals(picture.getPixel(2, 3)));
    }

    @Test
    public void getPixelTest() {
	Picture picture = new PictureImpl(4, 7);
	Pixel pixel = new GrayPixel(0.2);
	picture.setPixel(1, 4, pixel);
	Coordinate coordinate = new Coordinate(1, 4);
	assertTrue(picture.getPixel(1, 4).equals(picture.getPixel(coordinate)));
    }

    @Test
    public void extractTest() {
	Picture picture = new PictureImpl(25, 30);
	picture.setPixel(4, 7, new GrayPixel(0.7));
	Coordinate topLeft = new Coordinate(3, 4);
	Coordinate bottomRight = new Coordinate(12, 18);
	assertEquals(picture.extract(3, 4, 10, 15).getWidth(), picture.extract(topLeft, bottomRight).getWidth());
	assertEquals(picture.extract(3, 4, 10, 15).getHeight(), picture.extract(topLeft, bottomRight).getHeight());
	assertTrue(picture.getPixel(4, 7).equals(picture.extract(topLeft, bottomRight).getPixel(1, 3)));
    }

    @Test
    public void hasNextTest() {
	Picture picture = new PictureImpl(5, 6);
	Iterator<Pixel> iterator = picture.iterator();

	for (int i = 0; i < 29; i++) {
	    iterator.next();
	}

	assertTrue(iterator.hasNext());
	iterator.next();
	assertTrue(!iterator.hasNext());
    }

    @Test
    public void nextTest() {
	Picture picture = new PictureImpl(3, 4);
	Pixel pixel = new GrayPixel(0.6);
	picture.setPixel(1, 0, pixel);
	Iterator<Pixel> iterator = picture.iterator();
	assertTrue(!iterator.next().equals(pixel));
	assertTrue(iterator.next().equals(pixel));
    }
}