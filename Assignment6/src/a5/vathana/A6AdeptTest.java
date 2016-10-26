package a5.vathana;

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

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";
	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture p1 = new PictureImpl(3, 3);
	p1.setPixel(0, 0, GREEN);
	p1.setPixel(0, 2, RED);
	p1.setPixel(2, 0, BLUE);
	p1.setPixel(2, 2, BLACK);
	Iterator<Pixel> iT = p1.sample(0, 0, 2, 2);
	assertEquals("Pixels don't match pixel setters ", iT.next(), GREEN);
	assertEquals("Pixels don't match pixel setters", iT.next(), BLUE);
	assertEquals("Pixels don't match pixel setters", iT.next(), RED);
	assertEquals("Pixels don't match pixel setters", iT.next(), BLACK);

    }

    @Test
    public void windowTest() {
	Picture p1 = new PictureImpl(2, 2);
	p1.setPixel(0, 0, BLUE);
	p1.setPixel(1, 0, RED);
	p1.setPixel(0, 1, WHITE);
	p1.setPixel(1, 1, BLACK);
	Iterator<SubPicture> iT = p1.tile(1, 1);
	assertEquals("Tile method not returning expected output", iT.next().getPixel(0, 0), BLUE);
	assertEquals("Tile method not returning expected output", iT.next().getPixel(0, 0), RED);
	assertEquals("Tile method not returning expected output", iT.next().getPixel(0, 0), WHITE);
	assertEquals("Tile method not returning expected output", iT.next().getPixel(0, 0), BLACK);

    }

}
