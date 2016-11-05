package a5.yuting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "CoordinateTest_Getters";
	test_names[1] = "CoordinateTest_Setters";
	test_names[2] = "IteratorTest";
	test_names[3] = "ExtractByCoordinatesTest";
	test_names[4] = "IteratorTest_RemoveExepctionTest";

	return test_names;
    }

    @Test
    public void CoordinateTest_Getters() {

	Picture source1 = createSource1();
	Coordinate cordinate1 = new Coordinate(0, 0);
	Coordinate cordinate2 = new Coordinate(1, 0);
	Coordinate cordinate3 = new Coordinate(2, 0);

	assertEquals("Pixel got from Coordinate is different from the one got from x,y values ",
		source1.getPixel(cordinate1), source1.getPixel(0, 0));
	assertEquals("Pixel got from Coordinate is different from the one got from x,y values ",
		source1.getPixel(cordinate2), source1.getPixel(1, 0));
	assertEquals("Pixel got from Coordinate is different from the one got from x,y values ",
		source1.getPixel(cordinate3), source1.getPixel(2, 0));

    }

    @Test
    public void CoordinateTest_Setters() {
	Picture source2 = createSource1();

	Coordinate cordinate4 = new Coordinate(0, 1);
	Coordinate cordinate5 = new Coordinate(1, 1);
	Coordinate cordinate6 = new Coordinate(2, 1);

	source2.setPixel(cordinate4, BLACK);
	source2.setPixel(cordinate5, RED);
	source2.setPixel(cordinate6, BLUE);

	assertEquals("Pixel set from Coordinate is different from the expected value ", BLACK,
		source2.getPixel(cordinate4));
	assertEquals("Pixel set from Coordinate is different from the expected value ", RED,
		source2.getPixel(cordinate5));
	assertEquals("Pixel set from Coordinate is different from the expected value ", BLUE,
		source2.getPixel(cordinate6));

    }

    @Test
    public void IteratorTest() {

	Picture source1 = createSource1();
	Iterator<Pixel> iter = source1.iterator();

	// Test First Pixel
	assertTrue("The iterator cannot find the Pixel(0,0) ", iter.hasNext());
	assertEquals("Pixel gott from iterator is different from the expected value ", WHITE, source1.getPixel(0, 0));

	// Test Second Pixel
	assertTrue("The iterator cannot find the Pixel(1,0) ", iter.hasNext());
	assertEquals("Pixel gott from iterator is different from the expected value ", BLACK, source1.getPixel(1, 0));

	// Test Third Pixel
	assertTrue("The iterator cannot find the Pixel(2,0) ", iter.hasNext());
	assertEquals("Pixel gott from iterator is different from the expected value ", RED, source1.getPixel(2, 0));

	// Test Fourth Pixel
	assertTrue("The iterator cannot find the Pixel(0,1) ", iter.hasNext());
	assertEquals("Pixel gott from iterator is different from the expected value ", GREEN, source1.getPixel(0, 1));

	// Test Fifth Pixel
	assertTrue("The iterator cannot find the Pixel(1,1) ", iter.hasNext());
	assertEquals("Pixel gott from iterator is different from the expected value ", BLUE, source1.getPixel(1, 1));

	// Test Sixth Pixel
	assertTrue("The iterator cannot find the Pixel(2,1) ", iter.hasNext());
	assertEquals("Pixel gott from iterator is different from the expected value ", WHITE, source1.getPixel(2, 1));

    }

    @Test
    public void ExtractByCoordinatesTest() {

	Picture source4 = createSource1();

	Coordinate cordinate4 = new Coordinate(0, 1);
	Coordinate cordinate5 = new Coordinate(1, 1);
	Coordinate cordinate6 = new Coordinate(2, 1);

	SubPicture subPicture1 = source4.extract(cordinate4, cordinate6);

	Coordinate subCordinate1 = new Coordinate(0, 0);
	Coordinate subCordinate2 = new Coordinate(1, 0);
	Coordinate SubCordinate3 = new Coordinate(2, 0);

	// To test if the first row of the subPicture1 matches the second row of
	// the source4

	assertEquals("Pixel got from subpicture does not match expected pixel value from Source4",
		source4.getPixel(cordinate4), subPicture1.getPixel(subCordinate1));
	assertEquals("Pixel got from subpicture does not match expected pixel value from Source4",
		source4.getPixel(cordinate5), subPicture1.getPixel(subCordinate2));
	assertEquals("Pixel got from subpicture does not match expected pixel value from Source4",
		source4.getPixel(cordinate6), subPicture1.getPixel(SubCordinate3));
    }

    @Test
    public void IteratorTest_RemoveExepctionTest() {
	Picture source1 = createSource1();
	Iterator<Pixel> iter = source1.iterator();
	try {
	    iter.remove();
	    fail("No UnsupportedOperationException is detected");
	} catch (UnsupportedOperationException a) {
	} catch (Exception a) {
	    fail("Expected UnsupportedOperationException but got generic Excpetion");
	}
    }

    // Generate a sample picture for test-use
    public Picture createSource1() {
	Picture source1 = new PictureImpl(3, 2);
	source1.setPixel(0, 0, WHITE);
	source1.setPixel(1, 0, BLACK);
	source1.setPixel(2, 0, RED);
	source1.setPixel(0, 1, GREEN);
	source1.setPixel(1, 1, BLUE);
	source1.setPixel(2, 1, WHITE);
	return source1;
    }

}
