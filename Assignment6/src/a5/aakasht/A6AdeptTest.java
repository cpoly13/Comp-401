package a5.aakasht;

import static org.junit.Assert.*;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "getXTest";
	test_names[1] = "getAndSetPixelTest";
	test_names[2] = "extractSourceTest";
	test_names[3] = "extractSubPictureTest";
	test_names[4] = "iteratorHasNextTest";

	return test_names;
    }

    @Test
    public void getXTest() {
	Coordinate coord = new Coordinate(1, 2);

	assertEquals(coord.getX(), 1);
    }

    @Test
    public void getAndSetPixelTest() {
	Coordinate coord = new Coordinate(1, 2);

	ColorPixel pix = new ColorPixel(0.5, 0.5, 0.5);

	PictureImpl pic = new PictureImpl(5, 5);
	pic.setPixel(coord, pix);

	assertEquals(pic.getPixel(coord), pix);
    }

    @Test
    public void extractSourceTest() {
	Coordinate coord = new Coordinate(0, 0);
	Coordinate coordOne = new Coordinate(1, 1);
	PictureImpl pic = new PictureImpl(5, 5);
	SubPictureImpl subP = new SubPictureImpl(pic, 0, 0, 2, 2);
	assertEquals(pic.extract(coord, coordOne).getSource(), subP.getSource());
    }

    @Test
    public void extractSubPictureTest() {
	Coordinate coord = new Coordinate(0, 0);
	Coordinate coordOne = new Coordinate(1, 1);
	PictureImpl pic = new PictureImpl(5, 5);
	SubPictureImpl subP = new SubPictureImpl(pic, 0, 0, 2, 2);
	assertEquals(pic.extract(coord, coordOne).getHeight(), subP.getHeight());
    }

    @Test
    public void iteratorHasNextTest() {
	PictureImpl pic = new PictureImpl(5, 5);
	assertEquals(pic.iterator().hasNext(), true);

    }
}
