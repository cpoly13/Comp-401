package a5.isharma;

import static org.junit.Assert.*;
//collaborated with Ashish Khanchandani 
import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "exampleTest";
	test_names[1] = "sampleTest";
	test_names[1] = "windowTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> sampleIteration = p.sample(2, 3, 3, 4);
	assertEquals("Iteration is not same", true, sampleIteration.hasNext());
    }

    @Test
    public void windowTest() {
	Picture p = new PictureImpl(5, 5);
	Iterator<SubPicture> windowIteration = p.window(3, 2);
	assertEquals("Iteration not the same", true, windowIteration.hasNext());

    }
}