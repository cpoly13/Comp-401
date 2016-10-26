package a5.jglas314;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTest";

	return test_names;
    }

    public static Coordinate[] coordList(int width, int height) {
	Coordinate[] result = new Coordinate[width * height];
	for (int j = 0; j < height; j++) {
	    for (int i = 0; i < width; i++) {
		result[j * width + i] = new Coordinate(i, j);
	    }
	}
	return result;
    }

    public static Picture genPicture(int width, int height) {
	Picture p1 = new PictureImpl(width, height);
	Coordinate[] coords = coordList(width, height);
	for (int j = 0; j < height; j++) {
	    for (int i = 0; i < width; i++) {
		p1.setPixel(coords[j * width + i], new ColorPixel(Math.random(), Math.random(), Math.random()));
	    }
	}
	return p1;
    }
}
