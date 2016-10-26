package a5.jzacj;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Coordinate TEST_COORDS = new Coordinate(4, 3);
    private static final Pixel TEST_PIXEL = new ColorPixel(.5, .6, .7);
    private static final PictureImpl TEST_PICTURE = new PictureImpl(5, 8);
    private static final Coordinate STD_COORDS_1 = new Coordinate(1, 1);
    private static final Coordinate STD_COORDS_2 = new Coordinate(2, 2);

    private static final Coordinate CORNER_A = new Coordinate(1, 1);
    private static final Coordinate CORNER_B = new Coordinate(4, 4);

    private static final PictureImpl P_1 = new PictureImpl(5, 5);
    private static final PictureImpl P_2 = new PictureImpl(5, 5);

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "testSetGetPixel";
	test_names[1] = "testCoordBasedExtract";
	test_names[2] = "testCoordSetPixel";
	test_names[3] = "testCoordGetPixel";

	return test_names;
    }

    @Test
    public void testSetGetPixel() {
	TEST_PICTURE.setPixel(TEST_COORDS, TEST_PIXEL);
	assertTrue("getPixel does not match setPixel in Picture",
		TEST_PIXEL.getIntensity() == TEST_PICTURE.getPixel(TEST_COORDS).getIntensity());
	assertTrue("setPixel set incorrect Pixel(s)", TEST_PICTURE.getPixel(STD_COORDS_1).getIntensity() == TEST_PICTURE
		.getPixel(STD_COORDS_2).getIntensity());
    }

    @Test
    public void testCoordBasedExtract() {
	Coordinate testCoord = new Coordinate(2, 2);
	TEST_PICTURE.setPixel(testCoord, TEST_PIXEL);
	SubPicture p = TEST_PICTURE.extract(CORNER_A, CORNER_B);
	assertEquals("extract does not produce appropriate SubPicture based on Coords", p.getPixel(1, 1),
		TEST_PICTURE.getPixel(testCoord));

    }

    @Test
    public void testCoordSetPixel() {
	P_1.setPixel(4, 3, TEST_PIXEL);
	P_2.setPixel(TEST_COORDS, TEST_PIXEL);

	assertEquals("setPixel does not produce same result as integer version", P_1.getPixel(TEST_COORDS),
		P_2.getPixel(TEST_COORDS));

    }

    @Test
    public void testCoordGetPixel() {
	P_1.setPixel(TEST_COORDS, TEST_PIXEL);

	assertEquals("getPixel does not produce same result as integer version", P_1.getPixel(TEST_COORDS),
		P_1.getPixel(4, 3));
    }

}
