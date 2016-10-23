package a5.cpoly13;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

/*
 * Tests A6 Adept Iterator class methods and exception handling
 * @author Chris Polychronides
 */
public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[5];

		test_names[0] = "exampleTest";
		test_names[1] = "testIteratorSample";
		test_names[2] = "testIteratorWindow";
		test_names[3] = "testIteratorTile";
		test_names[4] = "testExceptions";

		return test_names;
	}
	/*
	 * Placeholder test
	 */
	@Test
	public void exampleTest() {
	}
	/*
	 * Multiple tests for various parameters that should throw IllegalArgument or Runtime
	 * exceptions
	 */
	@Test
	public void testExceptions(){
		Picture testPic=new PictureImpl(1920,1080);
		try {
			Iterator <Pixel> pixels = testPic.sample(2000, -3, 4, 5);
			fail("Expected IllegalArgument Exception for init x,y out of bounds");
		}
		catch(IllegalArgumentException e){
		}
		catch (RuntimeException e){
			fail("Expected IllegalArgument Exception but was RuntimeException");
		}
		
		try{
			Iterator <Pixel> pixels=testPic.sample(0, 0, -2, -500);
			fail("Expected IllegalArgument Exception for negative dx/dy");
		}
		catch(IllegalArgumentException e){
		}
		catch (RuntimeException e){
			fail("Expected IllegalArgument Exception but was RuntimeException");
		}
		
		try{
			Iterator <SubPicture> windows= testPic.window(-7, -400);
			fail("Expected IllegalArgument Exception for negative window width/heigh");
		}
		catch(IllegalArgumentException e){
		}
		
		catch (RuntimeException e){
			fail("Expected IllegalArgument Exception but was RuntimeException");
		}
		
		try{
			Iterator <SubPicture> windows= testPic.window(1922, 5000);
			fail("Expected IllegalArgument Exception for being over limit of window width/heigh");
		}
		catch(IllegalArgumentException e){
		}
		
		catch (RuntimeException e){
			fail("Expected IllegalArgument Exception but was RuntimeException");
		}
		
		try{
			Iterator <SubPicture> tiles= testPic.tile(-7, -400);
			fail("Expected IllegalArgument Exception for negative tile width/heigh");
		}
		catch(IllegalArgumentException e){
		}
		
		catch (RuntimeException e){
			fail("Expected IllegalArgument Exception but was RuntimeException");
		}
		
		try{
			Iterator <SubPicture> tiles= testPic.tile(1922, 5000);
			fail("Expected IllegalArgument Exception for being over limit of tile width/heigh");
		}
		catch(IllegalArgumentException e){
		}
		
		catch (RuntimeException e){
			fail("Expected IllegalArgument Exception but was RuntimeException");
		}
	}
	/*
	 * Tests iterator sample method
	 */
	@Test
	public void testIteratorSample() {
		Picture testPic = new PictureImpl(1920, 1080);
		Iterator<Pixel> pixels = testPic.sample(100, 300, 2, 3);
		int x = 100;
		int y = 300;

		for (int i = 0; i < testPic.getWidth(); i++) {
			for (int n = 0; n < testPic.getHeight(); n++) {
				Pixel random = new GrayPixel(Math.random());
				Coordinate xy = new Coordinate(i, n);
				testPic.setPixel(xy, random);
			}

		}

		while (pixels.hasNext()) {
			assertEquals("Sample Iterator method not working", testPic.getPixel(x, y).getChar(),
					pixels.next().getChar());

			if (x + 2 < testPic.getWidth() - 1) {
				x += 2;
			} else {
				x = 100;
				y += 3;
			}

		}

	}
	/*
	 * Tests iterator window method
	 */
	@Test
	public void testIteratorWindow() {
		Picture testPic = new PictureImpl(1920, 1080);
		Iterator<SubPicture> windows = testPic.window(3, 2);
		int x = 0;
		int y = 0;

		for (int i = 0; i < testPic.getWidth(); i++) {

			for (int n = 0; n < testPic.getHeight(); n++) {
				Pixel random = new GrayPixel(Math.random());
				Coordinate xy = new Coordinate(i, n);
				testPic.setPixel(xy, random);
			}

		}
		
		while (windows.hasNext()){
			assertEquals("SubPictures don't match iterator windows",testPic.extract(x, y, 3, 2).getPixel(1, 1).getChar(),
					windows.next().getPixel(1,1).getChar());
			
			if(x+3<testPic.getWidth()){
				x++;
			}
			
			else{
				x=0;
				y++;
			}
		}

	}
	/*
	 * Tests iterator tile method
	 */
	@Test
	public void testIteratorTile() {
		Picture testPic = new PictureImpl(1920, 1080);
		Iterator<SubPicture> tiles = testPic.tile(2,2);
		int x = 0;
		int y = 0;

		for (int i = 0; i < testPic.getWidth(); i++) {

			for (int n = 0; n < testPic.getHeight(); n++) {
				Pixel random = new GrayPixel(Math.random());
				Coordinate xy = new Coordinate(i, n);
				testPic.setPixel(xy, random);
			}

		}
		
		while (tiles.hasNext()){
			assertEquals("SubPictures don't match iterator tiles",testPic.extract(x, y, 2, 2).getPixel(1, 1).getChar(),
					tiles.next().getPixel(1,1).getChar());
			
			if(x+2<testPic.getWidth()){
				x+=2;
			}
			
			else{
				x=0;
				y+=2;
			}
		}

	}
	
	/*
	 * Test general picture dimensions
	 */
	@Test
	public void testPictureDimensions() {
		Picture testPic = new PictureImpl(1080, 1920);
		int width = 1080;
		int height = 1920;
		assertEquals("Width doesn't match", width, testPic.getWidth());
		assertEquals("Height doesn't match", height, testPic.getHeight());
	}
	
	/*
	 * Tests whether expected values return RuntimeException
	 */
	@Test
	public void testBadValues() {
		try {
			Picture nullTest = new PictureImpl(-2, 99);
			fail("Expected runtime exception");
		}

		catch (RuntimeException c) {
		}
	}
	
	/*
	 * Tests whether Coordinate class works correctly
	 */
    @Test
	public void testCoordinate() {
		Coordinate test = new Coordinate(2, 3);
		int x = 2;
		int y = 3;

		assertEquals("X component doesn't match", test.getX(), x);
		assertEquals("Y component doesn't match", test.getY(), y);

		test = new Coordinate(499, 0);
		x = 499;
		y = 0;

		assertEquals("X component doesn't match", test.getX(), x);
		assertEquals("Y component doesn't match", test.getY(), y);

		test = new Coordinate(23, 333);
		x = 23;
		y = 333;

		assertEquals("X component doesn't match", test.getX(), x);
		assertEquals("Y component doesn't match", test.getY(), y);

		test = new Coordinate(-9999, 9999);
		x = -9999;
		y = 9999;

		assertEquals("X component doesn't match", test.getX(), x);
		assertEquals("Y component doesn't match", test.getY(), y);
	}
    
    /*
     * Tests the getters and setters methods of picture classes using Coordinate object parameters
     */
    @Test
	public void testPixelCoordinateGettersAndSetters() {
		Picture pTest = new PictureImpl(1920, 1080);
		Coordinate cTest = new Coordinate(13, 25);
		Pixel toInsert = new GrayPixel(0.5);

		pTest.setPixel(cTest, toInsert);

		assertEquals("Get Pixel doesn't match set pixel", toInsert, pTest.getPixel(cTest));

		pTest = new PictureImpl(1, 1);
		cTest = new Coordinate(0, 0);
		toInsert = new GrayPixel(0.8);

		pTest.setPixel(cTest, toInsert);

		assertEquals("Get Pixel doesn't match set pixel", toInsert, pTest.getPixel(cTest));

		try {
			pTest = new PictureImpl(1, 1);
			cTest = new Coordinate(0, 1);
			toInsert = new GrayPixel(1.0);

			pTest.setPixel(cTest, toInsert);

			assertEquals("Get Pixel doesn't match set pixel", toInsert, pTest.getPixel(cTest));
			fail("Should be out of bounds");
		} catch (RuntimeException e) {

		}

		pTest = new PictureImpl(888, 57);
		cTest = new Coordinate(887, 56);
		toInsert = new GrayPixel(0.0);

		pTest.setPixel(cTest, toInsert);

		assertEquals("Get Pixel doesn't match set pixel", toInsert, pTest.getPixel(cTest));
	}
    /*
     * Tests whether sub-picture extractor extracts properly with given co-ordinates  
     */
	@Test
	public void subPictureExtractTest() {
		Picture toTest = new PictureImpl(1920, 1080);

		for (int i = 0; i < toTest.getWidth(); i++) {
			for (int n = 0; n < toTest.getHeight(); n++) {
				Pixel random = new GrayPixel(Math.random());
				Coordinate xy = new Coordinate(i, n);
				toTest.setPixel(xy, random);
			}
		}
		SubPicture sub = toTest.extract(12, 100, 500, 900);
		Coordinate a = new Coordinate(12, 100);
		Coordinate b = new Coordinate(512, 1000);
		SubPicture subToTest = toTest.extract(a, b);

		for (int i = 0; i < sub.getWidth(); i++) {
			for (int n = 0; n < sub.getHeight(); n++) {
				assertEquals("SubPictures don't match", +sub.getPixel(i, n).getChar(),
						+subToTest.getPixel(i, n).getChar());
			}
		}
		
		Picture toTest2 = new PictureImpl(2, 2);

		for (int i = 0; i < toTest2.getWidth(); i++) {
			for (int n = 0; n < toTest2.getHeight(); n++) {
				Pixel random = new GrayPixel(Math.random());
				Coordinate xy = new Coordinate(i, n);
				toTest2.setPixel(xy, random);
			}
		}
		SubPicture sub2 = toTest2.extract(0, 0, 1, 1);
		Coordinate x = new Coordinate(12, 100);
		Coordinate y = new Coordinate(512, 1000);
		try{
		SubPicture subToTest2 = toTest2.extract(x, y);
		for (int i = 0; i < sub2.getWidth(); i++) {
			for (int n = 0; n < sub2.getHeight(); n++) {
				assertEquals("SubPictures don't match", +sub2.getPixel(i, n).getChar(),
						+subToTest2.getPixel(i, n).getChar());
			}
		}
		fail("Expected IllegalArgumentExcpetion");}
		catch(IllegalArgumentException e){
			
		}

		

	}
	/*
	 * Creates iterator for pixel objects and tests proper iteration through elements
	 */
	@Test
	public void pixelIteratorTest() {
		Picture toTest = new PictureImpl(1920, 1080);
		Iterator<Pixel> pixels = toTest.iterator();
		int x = 0;
		int y = 0;
		

		for (int i = 0; i < toTest.getWidth(); i++) {
			for (int n = 0; n < toTest.getHeight(); n++) {
				Pixel random = new GrayPixel(Math.random());
				Coordinate xy = new Coordinate(i, n);
				toTest.setPixel(xy, random);
			}
		}

		if(!pixels.hasNext()){
			fail("Can't perform test, faulty iterator");
		}
		while (pixels.hasNext()) {

			assertEquals("Iterator is not iterating correctly", pixels.next().getChar(),
					toTest.getPixel(x, y).getChar());

			if (x < toTest.getWidth() - 1) {
				x++;
			}

			else {
				x = 0;
				y++;
			}

		}
		
		try{
			pixels.next();
			fail("Error, should throw UnsupportedOperationException");
		}
		catch (UnsupportedOperationException e){
			}
		catch (RuntimeException e){
			fail("Error, should throw UnsupportedOperationException");
		}

	}

}


