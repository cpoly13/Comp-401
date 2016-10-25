package a5.hudson15;

import static org.junit.Assert.*;


import a6adept.*;
import org.junit.Test;

import java.util.Iterator;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[5];

		test_names[0] = "sampleVersusNormal";
        test_names[1] = "sampleTest";
        test_names[2] = "windowTest";
        test_names[3] = "tileTest";
        test_names[4] = "illegalArgumentsTest";


		return test_names;
	}

	@Test // tests that a sampleIterator of (0,0,1,1) is equivalent to a normal picture iterator
	public void sampleVersusNormal() {
        Picture testPic = testPic(15,10);
        Iterator<Pixel> sample_iter = testPic.sample(0, 0, 1, 1);
        Iterator<Pixel> normal_iter = testPic.iterator();

        for(int i=0;i<15*10;i++) {
            assertEquals(sample_iter.next(), normal_iter.next());
        }
	}

    @Test // tests that a sampleIterator Iterates properly with higher dx dy values
    public void sampleTest() {
        Picture testPic = testPic(15,10);
        Iterator<Pixel> sample_iter = testPic.sample(2, 3, 3, 3);


        for(int y=3;y<10;y+=3) {
            for(int x=2;x<15;x+=3) {
                Coordinate expected = new Coordinate(x,y);
                assertEquals(testPic.getPixel(expected), sample_iter.next());
            }

        }
    }

    @Test // tests that a window call returns proper subPictures
    public void windowTest() {
        Picture testPic = testPic(5,5);
        int windowWidth = 3;
        int windowHeight = 2;
        Iterator<SubPicture> window_iter = testPic.window(windowWidth,windowHeight);

            for(int y=0;y<=5-windowHeight;y++) {
                for(int x=0;x<=5-windowWidth;x++) {
                assertTrue("Window test extracts Incorrect windows", comparePictures(testPic.extract(x,y,windowWidth,windowHeight), window_iter.next()));
            }

        }
    }

    @Test // tests that a tile call returns propper subPictures
    public void tileTest() {
        Picture testPic = testPic(5,5);
        int tileWidth = 2;
        int tileHeight = 2;
        Iterator<SubPicture> tile_iter = testPic.tile(tileWidth, tileHeight);



        for(int y=0; y < testPic.getHeight()/tileHeight ; y++) {
            for(int x=0; x < testPic.getWidth()/tileWidth ; x++) {
                System.out.println("Extracting " +x*tileWidth +y*tileHeight+tileWidth + tileHeight);
                assertTrue("Tile test extracts Incorrect tiles", comparePictures(testPic.extract(x*tileWidth,y*tileWidth,tileWidth,tileHeight), tile_iter.next()));
            }

        }
    }

    @Test // tests all possible illegal arguments throw proper exception
    public void illegalArgumentsTest() {
        Picture testPic = testPic(5,5);

        try{
          testPic.sample(10,10,5,5);
          fail("initx and inity must be in the sample, expected IllegalArgumentException");
        }catch (IllegalArgumentException e){

        }
        try{
            testPic.sample(2,2,-2,-2);
            fail("dx and dy must be positive, expected IllegalArgumentException");
        }catch (IllegalArgumentException e){

        }
        try{
            testPic.window(-2,-2);
            fail("Window width and window height must be positive, expected IllegalArgumentException");
        }catch (IllegalArgumentException e){

        }
        try{
            testPic.window(6,2);
            fail("Window width and window height must be <= picture width and height, expected IllegalArgumentException");
        }catch (IllegalArgumentException e){

        }
        try{
            testPic.tile(6,2);
            fail("tile width and tile height must be <= picture width and height, expected IllegalArgumentException");
        }catch (IllegalArgumentException e){

        }
        try{
            testPic.tile(-3,2);
            fail("tile width and tile height must be positive, expected IllegalArgumentException");
        }catch (IllegalArgumentException e){

        }


    }
    //returns a picture filled with random Pixels
    private Picture testPic(int width, int height){
        Picture testPic = new PictureImpl(width,height);

        for(int x = 0; x<width;x++){
            for(int y =0; y<height;y++){
                testPic.setPixel(x,y,new ColorPixel(Math.random(),Math.random(),Math.random()));
            }
        }
            return testPic;


    }

    //Compares two pictures and returns boolean
    private boolean comparePictures(Picture firstPic, Picture secondPic){
        //Compare sizes
        if(firstPic.getHeight() != secondPic.getHeight() || firstPic.getWidth() != secondPic.getWidth()){
            System.out.println("size missmatch");
            return false;
        }

        for(int i = 0; i<firstPic.getHeight()*firstPic.getWidth();i++){
            //compare pixels
            if (firstPic.iterator().next() != secondPic.iterator().next()){
                System.out.println("Failed at pixel: "+ i);
                return false;
            }
        }

        return true;

    }
}
