package a5.mkodali;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "coordinatesTest";
	test_names[1] = "coordinatesExtractTest";

	return test_names;
    }

    @Test
    public void coordinatesTest() {
	Coordinate a1 = new Coordinate(2, 3);
	Picture p1 = new PictureImpl(5, 6);
	p1.setPixel(a1, WHITE);
	assertEquals("The setters for coordinates did not work", p1.getPixel(a1), WHITE);
	a1 = new Coordinate(0, 0);
	p1.setPixel(a1, GREEN);
	assertEquals("The setters for coordinates did not work", p1.getPixel(a1), GREEN);
    }

    @Test
    public void coordinatesExtractTest() {
	Coordinate a1 = new Coordinate(1, 1);
	Coordinate a2 = new Coordinate(3, 3);
	Picture p1 = new PictureImpl(5, 6);
	p1.setPixel(a1, GREEN);
	p1.setPixel(a2, RED);
	p1.setPixel(2, 3, BLUE);
	p1.setPixel(3, 2, WHITE);
	SubPicture s1 = p1.extract(a1, a2);
	assertEquals("The SubPicture and the pixel don't match the source", s1.getPixel(0, 0), GREEN);
	assertEquals("The SubPicture and the pixel don't match the source", s1.getPixel(2, 2), RED);
	assertEquals("The SubPicture and the pixel don't match the source", s1.getPixel(1, 2), BLUE);
	assertEquals("The SubPicture and the pixel don't match the source", s1.getPixel(2, 1), WHITE);

    }

}
