package a5.jupchoo;

import static org.junit.Assert.*;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "CoorGetYTest";
	test_names[1] = "CoorGetXTest";

	return test_names;
    }

    @Test
    public void CoorGetYTest() {
	Coordinate c = new Coordinate(0, 0);
	assertEquals("The y value does not match what is returned in its getter method", 0, c.getY());
    }

    @Test
    public void CoorGetXTest() {
	Coordinate c = new Coordinate(0, 0);
	assertEquals("The x value does not match what is returned in its getter method", 0, c.getX());
    }
}
