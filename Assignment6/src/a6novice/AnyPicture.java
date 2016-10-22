package a6novice;

abstract public class AnyPicture implements Picture {

	int width;
	int height;

	public AnyPicture(int width, int height) {
		if (width < 0 || height < 0) {
			throw new RuntimeException("Error, negative parameters");
		}

		this.width = width;
		this.height = height;

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	abstract public void setPixel(int x, int y, Pixel p);

	abstract public Pixel getPixel(int x, int y);

	public int countRange(double low, double high) {
		if (low < 0 || low > 1 || high < 0 || high > 1) {
			throw new RuntimeException("Error, range out of bounds");
		}

		int count = 0;

		for (int i = 0; i < width; i++) {

			for (int n = 0; n < height; n++) {
				if (getPixel(i, n).getIntensity() >= low && getPixel(i, n).getIntensity() <= high) {
					count++;
				}
			}

		}
		return count;

	}
	
	public void print() {

		for (int i = 0; i < height; i++) {

			for (int n = 0; n < width; n++) {
				System.out.print(getPixel(n,i).getChar());

			}

			System.out.println();

		}
		
		
	}
	
	public SubPicture extract(int xOffset, int yOffset, int width, int height){
		SubPicture newSub=new SubPictureImpl(this,xOffset,yOffset, width, height);
		
		return newSub;
	}

}
