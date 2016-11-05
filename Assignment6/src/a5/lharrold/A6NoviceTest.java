package a5.lharrold;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.SubPictureImpl;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testCoordinateConstructor";
	test_names[1] = "testIterator";
	test_names[2] = "testExtract";

	return test_names;
    }

    @Test
    public void testCoordinateConstructor() {
	Coordinate a = new Coordinate(2, 3);
	Coordinate b = new Coordinate(a.getX(), a.getY());

	assertEquals(a.getX(), b.getX());
	assertEquals(a.getY(), b.getY());
    }

    @Test
    public void testIterator() {
	Picture source = new PictureImpl(7, 7);
	List<SubPictureImpl> p = new ArrayList<SubPictureImpl>();

	p.add(new SubPictureImpl(source, 1, 2, 5, 4));
	p.add(new SubPictureImpl(source, 1, 1, 3, 6));
	p.add(new SubPictureImpl(source, 2, 2, 3, 4));
	p.add(new SubPictureImpl(source, 2, 2, 4, 3));

	Iterator<SubPictureImpl> iter = p.iterator();

	assertEquals("should match 1st subpicture", p.get(0), iter.next());
	assertEquals("should match 2nd subpicture", p.get(1), iter.next());
	assertEquals("should match 3rd subpicture", p.get(2), iter.next());
	assertEquals("should match 4th subpicture", p.get(3), iter.next());
    }

    @Test
    public void testExtract() {
	Picture source = new PictureImpl(20, 20);
	Coordinate a = new Coordinate(5, 5);
	Coordinate b = new Coordinate(9, 9);
	Picture newPic = source.extract(a, b);

	assertEquals(5, newPic.getWidth());

    }
}
