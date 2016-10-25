package a5.zlennane;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	static public String[] getTestNames() {
		String[] test_names = new String[6];

		test_names[0] = "exampleTest";
		test_names[1] = "coordinateTest";
		test_names[2] = "extractTest";
		test_names[3] = "gettersAndSettersTest";
		test_names[4] = "exceptionTest";
		test_names[5] = "constructorTest";

		return test_names;
	}

	@Test
	public void constructorTest() {
		Picture p = new PictureImpl(3, 2);
		SubPicture sp = new SubPictureImpl(p, 1, 0, 2, 1);

		assertEquals(p, sp.getSource());
		assertEquals(1, sp.getXOffset());
		assertEquals(0, sp.getYOffset());
		assertEquals(2, sp.getWidth());
		assertEquals(1, sp.getHeight());
	}

	@Test
	public void exceptionTest() {
		Picture p = new PictureImpl(3, 2);
		try {
			p.setPixel(0, 0, null);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {

		} catch (RuntimeException e) {
		}
	}

	@Test
	public void gettersAndSettersTest() {
		Picture p = new PictureImpl(3, 2);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(0, 1, BLUE);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 0, BLACK);
		p.setPixel(2, 1, RED);
		assertEquals(p.getWidth(), 3);
		assertEquals(p.getHeight(), 2);
		assertEquals(p.getPixel(0, 0), RED);
		assertEquals(p.getPixel(1, 0), GREEN);
		assertEquals(p.getPixel(0, 1), BLUE);
		assertEquals(p.getPixel(1, 1), WHITE);
		assertEquals(p.getPixel(2, 0), BLACK);
		assertEquals(p.getPixel(2, 1), RED);

	}

	@Test
	public void coordinateTest() {
		Picture p = new PictureImpl(2, 2);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getHeight(); j++) {
				Coordinate c = new Coordinate(i, j);
				assertEquals(p.getPixel(i, j), p.getPixel(c));
			}
		}

	}

	@Test
	public void extractTest() {
		Picture p = new PictureImpl(3, 2);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(0, 1, BLUE);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 0, BLACK);
		p.setPixel(2, 1, RED);
		SubPicture sp = p.extract(1, 0, 2, 1);
		assertEquals(p.getPixel(1, 0), sp.getPixel(0, 0));
		assertEquals(p.getPixel(2, 0), sp.getPixel(1, 0));
		assertEquals(p.getPixel(1, 1), sp.getPixel(0, 1));
		assertEquals(p.getPixel(2, 1), sp.getPixel(1, 1));

	}

	@Test
	public void exampleTest() {
	}
}
