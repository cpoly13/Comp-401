package a5.ghstein;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "sampleMethodExceptions";
		test_names[1] = "windowMethodExceptions";

		return test_names;
	}

	@Test
	public void sampleMethodExceptions() {
		try {
			Picture p = new PictureImpl(15, 10);
			Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
			for (int z = 0; z == 20; z++) {
				Pixel next_Pixel = sample_iter.next();
				System.out.println("The next pixel color is: " + next_Pixel.getIntensity());
			}
		} catch (NoSuchElementException e) {
		} catch (RuntimeException e) {
			fail("expected no such element exception but got generic runtime exception");
		}
	}

	@Test
	public void windowMethodExceptions() {
		try {
			Picture p = new PictureImpl(2, 2);
			p.window(-3, 1);
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException E) {
			fail("expected illegal argument exception but got generic runtime exception");
		}
		try {
			Picture p = new PictureImpl(2, 2);
			p.window(1, -3);
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException E) {
			fail("expected illegal argument exception but got generic runtime exception");
		}

	}
}
