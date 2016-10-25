package a5.vinli;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import a6jedi.*;

public class test {
	public static void main (String[] args){
		Picture aPicture = new PictureImpl(20, 20);
		ColorPixel[] colorPixels = new ColorPixel[aPicture.getWidth()];
		for (int i = 0; i <aPicture.getWidth(); i++) {
			colorPixels[i] = new ColorPixel(Math.random(), Math.random(), Math.random()); 
		}
		
		
		for (int i = 0; i < aPicture.getHeight(); i++) {
			for (int j = 0; j < aPicture.getWidth(); j++) {
				aPicture.setPixel(j, i, colorPixels[(j + i) % aPicture.getHeight()]);
			}
		}
		for (int i = 0; i < colorPixels.length; i++) {
			System.out.print("[" + colorPixels[i].getChar() + "]");
		}
		
		Iterator<Pixel> iterator = aPicture.zigzag();
		for (int i = 0; i < aPicture.getWidth(); i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("[" + iterator.next().getChar() + colorPixels[i].getChar() + "]");
			}
			System.out.println();
		}
		
		System.out.println("__");
		
		for (int i = aPicture.getWidth(); i > 0; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print("[" + iterator.next().getChar() + colorPixels[aPicture.getWidth() - i].getChar() + "]");
			}
		System.out.println();
		}
		
		}
	
	private static boolean comparePixel(Pixel p, Pixel c) {
		double ptotal = p.getBlue() + p.getRed() + p.getGreen() + p.getIntensity();
		double ctotal = c.getBlue() + c.getRed() + c.getGreen() + c.getIntensity();
		if (ctotal == ptotal) {
			return true;
		}
		return false;
	}
	}

