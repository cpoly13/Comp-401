package a5.nishanth;

import static org.junit.Assert.*;

import java.util.Iterator;

import a6adept.*;

//import lec13.ex1.Song;
import org.junit.Before;
import org.junit.Test;
//import a6adept.Picture;

public class A6AdeptTest {

    private Picture pic;

    @Before
    public void setUp() {

    }

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "exampleTest";
	test_names[1] = "sampleTest";
	test_names[2] = "windowTest";
	test_names[3] = "tileTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void sampleTest() {

	// List <Picture> pixelList = new ArrayList<Picture>();
	// Iterator<Picture> iterator = new Iterator<Picture>;

	pic = new PictureImpl(10, 12);
	pic.iterator();

	// Iterator<Pixel> sample_iter = pic.sample(2, 3, 3, 4);

    }

    @Test
    public void windowTest() {
	pic = new PictureImpl(10, 12);
	Iterator<SubPicture> windowIter = pic.window(4, 5);
	// creates iterator object that will go through the pic
	// The pic has called the window method, so lots of
	// extracts of pic will be created. What should I test?
	// I think I should test if the iterator actually matches
	// those extracts in width,height, and other factors,
	// as it iterates through.
	SubPicture expected[] = { pic.extract(0, 0, 4, 5), pic.extract(1, 0, 4, 5), pic.extract(2, 0, 4, 5),
		pic.extract(3, 0, 4, 5), pic.extract(4, 0, 4, 5), pic.extract(5, 0, 4, 5), pic.extract(6, 0, 4, 5) };

	int i = 0;
	while (windowIter.hasNext()) {

	    // assertSame(expected[i].getWidth(),windowIter.next().getWidth());
	    assertEquals(expected[i].getWidth(), windowIter.next().getWidth());
	    // assertEquals(expected[i].getXOffset(),windowIter.next().getXOffset());
	    i++;
	    if (i < 7) {
		continue;
	    } else {
		break;
	    }

	}
    }

    @Test
    public void tileTest() {

    }
}
