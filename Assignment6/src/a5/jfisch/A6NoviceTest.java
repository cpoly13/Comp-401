package a5.jfisch;

import static org.junit.Assert.*;
//import java.util.Iterator;
import org.junit.Test;
import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_Names = { "exampleTest", "coordinateConstructorTest", "coordinateGetPixelTest" };

	return test_Names;
    }

    @Test
    public void exampleTest() {
    }

    @Test // Coordinate locations are accurate with parameters
    public void constructorTest() {
	Coordinate a = new Coordinate(1, 1);

	assertEquals("X-Value does not match value given to constructor", 1, a.getX());
	assertEquals("Y-Value does not match value given to constructor", 1, a.getY());
    }

    @Test // Testing for the overload of getPixel to coordinate as a parameter
    public void getPixelTest() {
	Coordinate a = new Coordinate(1, 1);
	Pixel pixel = new ColorPixel(1, 0, 0);
	Picture p = new PictureImpl(3, 3);
	p.setPixel(a, pixel);
	assertEquals("Pixel not set at correct coordinate", pixel, p.getPixel(a));
    }
}
