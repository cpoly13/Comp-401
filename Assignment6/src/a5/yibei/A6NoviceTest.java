package a5.yibei;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "extractTest";
	test_names[1] = "getPixelTest";

	return test_names;
    }

    @Test
    public void extractTest() {
	Picture p = new PictureImpl(10, 10);
	Coordinate coor1 = new Coordinate(0, 0);
	Coordinate coor2 = new Coordinate(4, 4);

	Picture expected = p.extract(coor1, coor2);

	assertEquals("wrong height", 5, expected.getHeight());
	assertEquals("wrong width", 5, expected.getWidth());
    }

    @Test
    public void getPixelTest() {
	Coordinate coor = new Coordinate(1, 1);
	Picture p = new PictureImpl(5, 5);
	p.setPixel(coor, new ColorPixel(0.7, 0.4, 0.9));

	assertEquals(p.getPixel(1, 1).getRed(), p.getPixel(coor).getRed(), 0.00001);
	assertEquals(p.getPixel(1, 1).getGreen(), p.getPixel(coor).getGreen(), 0.00001);
	assertEquals(p.getPixel(1, 1).getBlue(), p.getPixel(coor).getBlue(), 0.00001);
    }

}
