package a5.conradc;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "coordinateTest";
	test_names[1] = "coordinatePictureTest";

	return test_names;
    }

    /**
     * JUnit test for Coordinate implementation Input: None Output: Asserts
     * whether Coordinate object was properly implemented
     */

    @Test
    public void coordinateTest() {
	Coordinate test_coor = new Coordinate(1, 2);
	assertEquals(test_coor.getX(), 1);
	assertEquals(test_coor.getY(), 2);

    }

    /**
     * JUnit test for new Picture implementation Input: None Output: Asserts
     * whether PictureImpl's methods produce correct output
     */

    @Test
    public void coordinatePictureTest() {

	PictureImpl test_pic = new PictureImpl(2, 2);

	Pixel red_pix = new ColorPixel(1, 0, 0);
	Pixel blu_pix = new ColorPixel(0, 0, .9);
	Pixel gre_pix = new ColorPixel(0, .1, 0);
	Pixel whi_pix = new ColorPixel(.5, .5, .5);

	Coordinate red_coor = new Coordinate(0, 0);
	Coordinate blu_coor = new Coordinate(0, 1);
	Coordinate gre_coor = new Coordinate(1, 0);
	Coordinate whi_coor = new Coordinate(1, 1);

	test_pic.setPixel(0, 0, red_pix);
	test_pic.setPixel(0, 1, blu_pix);
	test_pic.setPixel(gre_coor, gre_pix);
	test_pic.setPixel(whi_coor, whi_pix);

	// tests set and get methods
	assertEquals(test_pic.getPixel(red_coor), red_pix);
	assertEquals(test_pic.getPixel(blu_coor), blu_pix);
	assertEquals(test_pic.getPixel(1, 0), gre_pix);
	assertEquals(test_pic.getPixel(1, 1), whi_pix);

	Pixel[] row_major_pix = { red_pix, gre_pix, blu_pix, whi_pix };

	Iterator<Pixel> iterator_test = test_pic.iterator();

	// compares row major order to PictureImpl iterator
	int iter_index = 0;
	while (iterator_test.hasNext()) {
	    Pixel n = iterator_test.next();
	    assertEquals(n, row_major_pix[iter_index]);
	    iter_index++;
	}
    }
}
