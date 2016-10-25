package a5.juwanp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

	static public String[] getTestNames() {
		String[] test_names = new String[3];

		test_names[0] = "booleanIteratorTest";
		test_names[1] = "coordinateXYGetterTest";
		test_names[2] = "badParametersTest";

		return test_names;
	}

	@Test
	public void booleanIteratorTest() {
		Picture p = new PictureImpl(3, 3);
		Iterator<Pixel> i = p.iterator();
		assertEquals("It needs to be true", i.hasNext(), true);
	}

	@Test
	public void coordinateXYGetterTest() {
		Coordinate c = new Coordinate(3, 9);
		assertEquals(3, c.getX());
		assertEquals(9, c.getY());

	}

	@Test
	public void badParamtetersTest() {

		Picture p1 = new PictureImpl(2, 4);

		Coordinate c1 = new Coordinate(2, 2);
		Coordinate c2 = new Coordinate(3, 3);

		try {
			p1.extract(null, null);
			fail("Both coordinates are null in extract method");
		} catch (RuntimeException e) {
		}

		try {
			p1.extract(null, c2);
			fail("First coordinate returned a null in extract method");
		} catch (RuntimeException e) {

		}

		try {
			p1.extract(c1, null);
			fail("Second coordinate returned a null in extract method");
		} catch (RuntimeException e) {

		}
	}

}
