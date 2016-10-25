package a5.iamboo;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
        String[] test_names = new String[3];

        test_names[0] = "exampleTest";
        test_names[1] = "testSample";
        test_names[2] = "testWindow";

        return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void testSample() {
        Picture p1 = new PictureImpl(10, 10);
        try {
            Iterator<Pixel> iter = p1.sample(1, 1, -1, 11);
            fail("Failed to through exception for illegal arguments");
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testWindow(){
        Picture p1 = new PictureImpl(10, 10);
            try{
                p1.window(-1, 1);
                fail("Failed to through Exception");
            }
            catch (RuntimeException e){
            }

    }
}

