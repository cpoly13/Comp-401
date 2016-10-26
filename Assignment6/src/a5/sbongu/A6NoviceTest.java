package a5.sbongu;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    // initialize Pixel variables for test
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "overloadSetPixelTest";
	test_names[1] = "overloadGetPixelTest";
	test_names[2] = "nextTest";
	test_names[3] = "hasNextTest";

	return test_names;
    }

    @Test
    public void overloadSetPixelTest() {
	Coordinate corToSet = new Coordinate(2, 4);
	Picture picToSet = new PictureImpl(5, 5);
	picToSet.setPixel(corToSet, GREEN); // overload method
	assertTrue(picToSet.getPixel(2, 4).equals(GREEN)); // test with Pixel
							   // method
    }

    @Test
    public void overloadGetPixelTest() {
	Coordinate corToSet = new Coordinate(5, 3);
	Picture picToSet = new PictureImpl(6, 6);
	picToSet.setPixel(5, 3, RED); // overload method
	assertTrue(picToSet.getPixel(corToSet).equals(RED)); // test with Pixel
							     // method
    }

    /*
     * @Test public void overloadSubExtractTest() { Picture pic = new
     * PictureImpl(10,10); SubPicture sub = pic.extract(1, 1, 2, 2); Coordinate
     * cor1 = new Coordinate(1,1); Coordinate cor2 = new Coordinate(3,3);
     * SubPicture clone = pic.extract(cor1, cor2);
     * assertTrue(clone.equals(sub)); }
     */

    @Test
    public void nextTest() {
	Picture pic = new PictureImpl(5, 5);
	pic.setPixel(2, 2, RED);
	Iterator<Pixel> findIt = pic.iterator();
	for (int i = 0; i < 12; i++) {
	    findIt.next(); // iterate next to before Pixel
	}
	assertTrue(findIt.next().equals(RED)); // test Pixel condition
    }

    @Test
    public void hasNextTest() {
	Picture pic = new PictureImpl(5, 5);
	Iterator<Pixel> findIt = pic.iterator();
	for (int i = 0; i < 25; i++) {
	    findIt.next(); // iterate next to end of 2d array
	}
	assertFalse(findIt.hasNext()); // test for hasNext
    }
}
