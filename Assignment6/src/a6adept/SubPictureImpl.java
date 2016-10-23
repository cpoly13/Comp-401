package a6adept;

public class SubPictureImpl extends AnyPicture implements SubPicture {
	
	private Picture source;
	private int xOffset;
	private int yOffset;
	
	
	public SubPictureImpl(Picture source, int xOffset,int yOffset,int width, int height)
	{
		super(width, height);
		if (source==null)
		{
			throw new IllegalArgumentException ("No source to create sub picture");
		}
		
		if (xOffset+width> source.getWidth() || yOffset+height>source.getHeight() ||xOffset<0 || yOffset<0)
		{
			throw new IllegalArgumentException ("Parameters for sub picture out of bounds of original picture");
		}
		
		this.source=source;
		this.xOffset=xOffset;
		this.yOffset=yOffset;
		
	}
	
	public Picture getSource(){
		return source;
	}
	
	public int getXOffset(){
		return xOffset;
	}
	
	public int getYOffset(){
		return yOffset;
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		// TODO Auto-generated method stub
		
		source.setPixel(x+xOffset, y+yOffset, p);
		
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		return source.getPixel(x+xOffset, y+yOffset);
	}
	



}
