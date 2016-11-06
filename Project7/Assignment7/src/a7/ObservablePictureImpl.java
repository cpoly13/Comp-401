package a7;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ObservablePictureImpl implements ObservablePicture {
	
	private Picture pic;
	private List <RegionWithObservers> regionsObserved;
	
	
	public ObservablePictureImpl(Picture p){
		if(p==null){
			throw new IllegalArgumentException("Picture object is null");
		}
		
		pic=p;
		regionsObserved= new ArrayList<RegionWithObservers>();
	}

	@Override
	public int getWidth() {
		
		return pic.getWidth();
	}

	@Override
	public int getHeight() {
		
		return pic.getHeight();
	}

	@Override
	public Pixel getPixel(int x, int y) {
		
		return pic.getPixel(x, y);
	}

	@Override
	public Pixel getPixel(Coordinate c) {
		
		return pic.getPixel(c);
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		
		
		this.pic.setPixel(x, y, p);
		Region tiny= new RegionImpl(new Coordinate (x,y), new Coordinate(x,y));
		
		for(RegionWithObservers r : regionsObserved){
			if(r.getLeft()<=x && r.getRight()>=x && r.getTop()<=y && r.getBottom()>=y){
				Iterator <ROIObserver> it =  r.getObservers().iterator();
				while(it.hasNext()){
					Region toUpdate;
					try {
						toUpdate=r.intersect(tiny);
					} catch (NoIntersectionException e) {
						
						throw new RuntimeException("Logic flaw in setPixel method");
					}
					
					it.next().notify(this, toUpdate);
				}
			}
		}
		
	}

	@Override
	public void setPixel(Coordinate c, Pixel p) {
		
		this.setPixel(c.getX(), c.getY(), p);
		
	}

	@Override
	public SubPicture extract(int xoff, int yoff, int width, int height) {
		
		return pic.extract(xoff, yoff, width, height);
	}

	@Override
	public SubPicture extract(Coordinate a, Coordinate b) {
		
		return pic.extract(a, b);
	}

	@Override
	public void registerROIObserver(ROIObserver observer, Region r) {
		
		if(observer==null || r==null){
			throw new IllegalArgumentException("Region or observer object/s were null");
		}
		RegionWithObserversImpl a= new RegionWithObserversImpl(r);
		a.addObservers(observer);
		regionsObserved.add(a);
		
	}

	@Override
	public void unregisterROIObservers(Region r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterROIObserver(ROIObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ROIObserver[] findROIObservers(Region r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void suspendObservable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resumeObservable() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

