package a5.jewell96;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import a6novice.Coordinate;

public class A6NoviceTest {

    // test names list
    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "checkCoordinateValuesTest";

	return test_names;
    }

    @Test
    public void checkCoordinateValuesTest() {
	Coordinate p = new Coordinate(5, 4);
	Coordinate newP = new Coordinate(p.getX(), p.getY());
	assertTrue(p.getX() == newP.getX());
	assertTrue(p.getY() == newP.getY());
    }

}
