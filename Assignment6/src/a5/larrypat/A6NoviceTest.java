package a5.larrypat;

import static org.junit.Assert.*;
//import java.util.Iterator;
import org.junit.Test;
import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_id = { "exampleTest", "coordinateConstructorTest", "coordinateGetPixelTest" };

	return test_id;
    }

    @Test
    public void exampleTest() {
    }

    @Test // Tests to confirm that coordinates are set at correct inputs
    public void coordinateConstructorTest() {
	Coordinate c = new Coordinate(1, 1);

	assertEquals("X-Value does not match value given to constructor", 1, c.getX());
	assertEquals("Y-Value does not match value given to constructor", 1, c.getY());
    }

    @Test // Tests overloaded getPixel with coordinate as parameter
    public void coordinateGetPixelTest() {
	Coordinate c = new Coordinate(1, 1);
	Pixel pixel = new ColorPixel(1, 0, 0);
	Picture p = new PictureImpl(3, 3);
	p.setPixel(c, pixel);
	assertEquals("Pixel not set at correct coordinate", pixel, p.getPixel(c));
    }
}

// collaborators Jack Fischer John Moore Basil Williams
