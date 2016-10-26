package a5.chasejf;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.Coordinate;
import a6jedi.GrayPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);
    private static final Coordinate CZERO = new Coordinate(0, 0);
    private static final Coordinate C01 = new Coordinate(0, 1);
    private static final Coordinate C10 = new Coordinate(1, 0);
    private static final Coordinate C11 = new Coordinate(1, 1);
    private static final Coordinate C20 = new Coordinate(0, 2);
    private static final Coordinate C02 = new Coordinate(2, 0);
    private static final Coordinate C12 = new Coordinate(1, 2);
    private static final Coordinate C21 = new Coordinate(2, 1);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTest";

	return test_names;
    }

    /*
     * creates an 8x8 picture with some varied pixels
     * 
     */
    public Picture get8x8() {
	Picture p = new PictureImpl(8, 8);
	p.setPixel(CZERO, RED);
	p.setPixel(C10, RED);
	p.setPixel(C20, RED);
	p.setPixel(C01, GREEN);
	p.setPixel(C11, BLUE);
	p.setPixel(C21, WHITE);
	p.setPixel(C02, BLACK);
	p.setPixel(C12, BLACK);
	return p;
    }

    /*
     * zigzagTest is a version of the iterator test in a6novice, tests expected
     * char from intensity of a pixel in picture. this version will know whether
     * iterator zigzags correctly
     */
    @Test
    public void zigzagTest() {
	Picture p = get8x8();
	Iterator<Pixel> zZTopPicIt = p.zigzag();
	char[] char8x8 = new char[64];
	char8x8[0] = 'X';
	char8x8[1] = 'X';
	char8x8[2] = '>';
	char8x8[3] = 'X';
	char8x8[4] = 'M';
	char8x8[5] = '#';
	char8x8[6] = '>';
	char8x8[7] = ' ';
	char8x8[8] = '#';
	char8x8[9] = '>';
	char8x8[10] = '>';
	for (int ii = 11; ii < 64; ii++) {
	    char8x8[ii] = '>';
	}
	int i = 0;
	assertEquals("iterator has no next", zZTopPicIt.hasNext(), true);
	while (zZTopPicIt.hasNext()) {
	    char temp = char8x8[i];
	    char ittemp = zZTopPicIt.next().getChar();
	    assertEquals("iterator does not iterate correctly, failed at" + " " + i + " st/nd/th iteration", ittemp,
		    temp);
	    i++;
	}

    }
}
