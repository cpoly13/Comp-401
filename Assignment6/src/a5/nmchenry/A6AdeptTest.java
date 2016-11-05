package a5.nmchenry;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "windowTest";
	test_names[1] = "sampleTest";

	return test_names;
    }

    @Test
    public void windowTest() {
	Picture p = new PictureImpl(5, 5);

	p.setPixel(0, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(0, 2, GREEN);
	p.setPixel(0, 3, GREEN);
	p.setPixel(0, 4, GREEN);
	p.setPixel(1, 0, BLUE);
	p.setPixel(2, 0, BLUE);
	p.setPixel(3, 0, BLUE);
	p.setPixel(4, 0, BLUE);

	Iterator<SubPicture> Itr = p.window(3, 2);
	Coordinate c = new Coordinate(0, 0);

	assertEquals("Window Iterator not functioning", p.extract(0, 0, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(1, 0, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(2, 0, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(0, 1, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(1, 1, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(2, 1, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(0, 2, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(1, 2, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(2, 2, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(0, 3, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(1, 3, 3, 2).getPixel(c), Itr.next().getPixel(c));
	assertEquals("Window Iterator not functioning", p.extract(2, 3, 3, 2).getPixel(c), Itr.next().getPixel(c));

    }

    @Test
    public void sampleTest() {
	Picture test = new PictureImpl(15, 10);
	test.setPixel(0, 0, RED);
	test.setPixel(1, 0, RED);
	test.setPixel(4, 0, RED);
	test.setPixel(8, 0, RED);
	test.setPixel(12, 0, RED);
	test.setPixel(0, 4, RED);
	test.setPixel(4, 4, RED);
	test.setPixel(8, 4, RED);
	test.setPixel(12, 4, RED);
	test.setPixel(0, 8, RED);
	test.setPixel(4, 8, RED);
	test.setPixel(8, 8, RED);
	test.setPixel(12, 8, RED);

	Iterator<Pixel> Itr = test.sample(0, 0, 4, 4);
	Iterator<Pixel> Itr2 = test.sample(0, 0, 1, 1);

	assertEquals("Sample iterator isn't working the same as the novice iterator", RED, Itr2.next());
	assertEquals("Sample iterator isn't working the same as the novice iterator", RED, Itr2.next());

	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());
	assertEquals("Iterator returned the wrong pixel", RED, Itr.next());

    }
}
