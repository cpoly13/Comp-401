package a5.yanbing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.Coordinate;

public class A6NoviceTest {

	static public String[] getTestNames() {
		String[] test_names = new String[1];

		test_names[0] = "testCoordinateBasic";

		return test_names;
	}

	@Test
	public void testCoordinateBasic() {
		Coordinate a = new Coordinate(1, 2);
		assertEquals("Result from getX() does not match source coordinate", 1, a.getX());
		assertEquals("Result from getY() does not match source coordinate", 2, a.getY());

	}

}
