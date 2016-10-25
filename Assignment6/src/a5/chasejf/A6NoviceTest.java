package a5.chasejf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;

public class A6NoviceTest {
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
	private static final Coordinate C22 = new Coordinate(2, 2);
	private static final Coordinate C12 = new Coordinate(1, 2);
	private static final Coordinate C21 = new Coordinate(2, 1);

	static public String[] getTestNames() {
		String[] test_names = new String[4];

		test_names[0] = "constructorCoordTest";
		test_names[1] = "iteratorTest";
		test_names[2] = "extractTest";
		test_names[3] = "exceptionsTest";
		return test_names;
	}

	/*
	 * creates a 3x3 picture using pictureimpl
	 */
	public Picture get3x3() {
		Picture p = new PictureImpl(3, 3);
		p.setPixel(CZERO, RED);
		p.setPixel(C10, RED);
		p.setPixel(C20, RED);
		p.setPixel(C01, GREEN);
		p.setPixel(C11, BLUE);
		p.setPixel(C21, WHITE);
		p.setPixel(C02, BLACK);
		p.setPixel(C12, BLACK);
		p.setPixel(C22, RED);
		return p;
	}

	/*
	 * tests coordinate class, and get/set for new pixel methods
	 */
	@Test
	public void constructorCoordTest() {
		Picture p = get3x3();

		SubPicture sp = new SubPictureImpl(p, 1, 1, 2, 2);
		assertEquals("Pixel do not match", p.getPixel(C11), sp.getPixel(CZERO));
		assertEquals("Pixel do not match", p.getPixel(C21), sp.getPixel(C10));
		assertEquals("Pixel do not match", p.getPixel(C12), sp.getPixel(C01));
		assertEquals("Pixel do not match", p.getPixel(C22), sp.getPixel(C11));

		sp.setPixel(CZERO, RED);
		assertEquals("Pixel retrieved after setting does not match expected value", RED, sp.getPixel(CZERO));
		assertEquals("Pixel in source not changed after setting through subpicture", RED, p.getPixel(CZERO));
	}

	/*
	 * iterator test, tests expected characters can be adapted to work with
	 * other iterators all you have to do is change the char list to what you
	 * expect your pixel to read.
	 */
	@Test
	public void iteratorTest() {
		char[] char3x3 = new char[9];
		char3x3[0] = 'X';
		char3x3[1] = 'X';
		char3x3[2] = '#';
		char3x3[3] = '>';
		char3x3[4] = 'M';
		char3x3[5] = ' ';
		char3x3[6] = 'X';
		char3x3[7] = '#';
		char3x3[8] = 'X';
		Picture p = get3x3();
		Iterator<Pixel> pictureit = p.iterator();
		int i = 0;
		assertEquals("iterator has no next", pictureit.hasNext(), true);
		while (pictureit.hasNext()) {
			char temp = char3x3[i];
			char ittemp = pictureit.next().getChar();
			assertEquals("iterator does not iterate correctly", ittemp, temp);
			i++;
		}
	}

	/*
	 * extract test, tests the extract method with coordinate values
	 */
	@Test
	public void extractTest() {
		Picture p = get3x3();
		SubPicture sp = p.extract(C11, C22);
		assertEquals("Pixel do not match", p.getPixel(C11), sp.getPixel(CZERO));
		assertEquals("Pixel do not match", p.getPixel(C21), sp.getPixel(C10));
		assertEquals("Pixel do not match", p.getPixel(C12), sp.getPixel(C01));
		assertEquals("Pixel do not match", p.getPixel(C22), sp.getPixel(C11));
	}

	@Test
	public void exceptionsTest() {
		try {
			Coordinate neg11 = new Coordinate((Integer) null, (Integer) null);
			fail("Expected RuntimeException for null");
		} catch (RuntimeException e) {
		} catch (Exception e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		Picture p = new PictureImpl(6, 4);
		// segment below here is from A4novice test set up
		try {
			SubPicture sp = new SubPictureImpl(p, 7, 2, 1, 1);
			fail("Expected IllegalArgumentException for x offset >= source width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		try {
			p.setPixel(-1, -2, (Pixel) null);
			fail("Expected RuntimeException with pixel is null");
		} catch (RuntimeException e) {
		}
		try {
			p.setPixel(-1, -2, RED);
			fail("Expected RuntimeException with x, or y is negative");
		} catch (RuntimeException e) {
		}
	}
}
