package a5.richyle;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture p1 = new PictureImpl(3, 3);
	p1.setPixel(0, 0, WHITE);
	p1.setPixel(2, 0, BLUE);
	p1.setPixel(0, 2, RED);
	p1.setPixel(2, 2, GREEN);
	Iterator<Pixel> it = p1.sample(0, 0, 2, 2);
	assertEquals("sample method not returning expected output", it.next(), WHITE);
	assertEquals("sample method not returning expected output", it.next(), BLUE);
	assertEquals("sample method not returning expected output", it.next(), RED);
	assertEquals("sample method not returning expected output", it.next(), GREEN);
    }

    @Test
    public void windowTest() {
	Picture p1 = new PictureImpl(2, 2);
	p1.setPixel(0, 0, WHITE);
	p1.setPixel(1, 0, BLUE);
	p1.setPixel(0, 1, RED);
	p1.setPixel(1, 1, GREEN);
	Iterator<SubPicture> it = p1.tile(1, 1);
	assertEquals("tile method not returning expected output", it.next().getPixel(0, 0), WHITE);
	assertEquals("tile method not returning expected output", it.next().getPixel(0, 0), BLUE);
	assertEquals("tile method not returning expected output", it.next().getPixel(0, 0), RED);
	assertEquals("tile method not returning expected output", it.next().getPixel(0, 0), GREEN);
    }
}
