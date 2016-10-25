package a5.hudson15;

import static org.junit.Assert.*;

import org.junit.Test;
import a6jedi.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "zigZagStartTest";
        test_names[1] = "zigZagStopTest";
        test_names[2] = "zigzagSquareTest";
        test_names[3] = "zigzagRectangleTest";
        test_names[4] = "zigZagExceptionTest";
		
		return test_names;
	}
		

    @Test // Tests that the first movement translates over one to the right
    public void zigZagStartTest() {
        Picture testPic = testPic(15,10);
        Iterator<Pixel> zigZagIterator = testPic.zigzag();

        assertEquals(testPic.getPixel(0,0),zigZagIterator.next());
        assertEquals(testPic.getPixel(1,0),zigZagIterator.next());

    }
    @Test // Tests that last item iterated is the bottom left corner
    public void zigZagEndTest() {
        Picture testPic = testPic(15,11);
        Iterator<Pixel> zigZagIterator = testPic.zigzag();

        Pixel lastPixel = null;
        for (int y =0; y<testPic.getHeight();y++) {
            for (int x =0; x<testPic.getWidth();x++) {
                lastPixel = zigZagIterator.next();
            }
        }

        assertEquals(testPic.getPixel(testPic.getWidth()-1,testPic.getHeight()-1),lastPixel);


    }

    @Test // Tests the entire iteration on a square
    public void zigZagSquareTest() {
        Picture testPic = testPic(10,10);
        Iterator<Pixel> zigZagIterator = testPic.zigzag();

        int x = 0;
        int y = 0;

        Pixel currentPixel = null;

        while(currentPixel!= testPic.getPixel(testPic.getWidth()-1,testPic.getHeight()-1)) {
            assertEquals("Pixel "+x+","+y+" Not equal to iterator next",testPic.getPixel(x,y),zigZagIterator.next());

                if((x + y) % 2 ==0){ //Determine even or odd
                   //EVEN functions
                    if(y==0){
                        x++;
                    }else if(x==testPic.getWidth()-1){
                        y++;
                    }else{
                        x++;
                        y--;
                    }
                }else{
                    //ODD functions
                    if(y == testPic.getHeight()-1){
                        x++;
                    }else if(x == 0){
                        y++;
                    }else{
                        x--;
                        y++;
                    }
                }

            currentPixel = testPic.getPixel(x,y);
        }

    }

    @Test // Tests the entire iteration on a Rectangle
    public void zigZagRectangleTest() {
        Picture testPic = testPic(20,10);
        Iterator<Pixel> zigZagIterator = testPic.zigzag();

        int x = 0;
        int y = 0;

        Pixel currentPixel = null;

        while(currentPixel!= testPic.getPixel(testPic.getWidth()-1,testPic.getHeight()-1)) {
            assertEquals("Pixel "+x+","+y+" Not equal to iterator next",testPic.getPixel(x,y),zigZagIterator.next());

            if((x + y) % 2 ==0){ //Determine even or odd
                //EVEN functions
                if(y==0){
                    x++;
                }else if(x==testPic.getWidth()-1){
                    y++;
                }else{
                    x++;
                    y--;
                }
            }else{
                //ODD functions
                if(y == testPic.getHeight()-1){
                    x++;
                }else if(x == 0){
                    y++;
                }else{
                    x--;
                    y++;
                }
            }

            currentPixel = testPic.getPixel(x,y);
        }

    }

    @Test // Tests that the iterator terminates when expected
    public void zigZagExceptionTest() {
        Picture testPic = testPic(20,10);
        Iterator<Pixel> zigZagIterator = testPic.zigzag();

        for (Pixel p: testPic) {
            zigZagIterator.next();
        }
        try{
            zigZagIterator.next();
        }catch (NoSuchElementException e){

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

