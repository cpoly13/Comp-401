package a7;
import java.util.List;
import java.util.ArrayList;
/*
 * Decorated region implementation that can keep track of observers
 */
public class RegionWithObserversImpl implements RegionWithObservers {
	
	private Region r;
	private List<ROIObserver> observers;
	
	public RegionWithObserversImpl(Region r){
		if(r==null){
			throw new IllegalArgumentException("Region was null");
		}
		
		this.r=r;
		observers=new ArrayList <ROIObserver>();
	}
	
	@Override
	public Coordinate getUpperLeft() {
		
		return r.getUpperLeft();
	}

	@Override
	public Coordinate getLowerRight() {
		
		return r.getLowerRight();
	}

	@Override
	public int getTop() {
		
		return r.getTop();
	}

	@Override
	public int getBottom() {
		
		return r.getBottom();
	}

	@Override
	public int getLeft() {
		
		return r.getLeft();
	}

	@Override
	public int getRight() {
		
		return r.getRight();
	}

	@Override
	public Region intersect(Region other) throws NoIntersectionException {
		
		return r.intersect(other);
	}

	@Override
	public Region union(Region other) {
		
		return r.union(other);
	}

	@Override
	public void addObservers(ROIObserver a) {
		
		if(a==null){
			throw new IllegalArgumentException("Observer was null");
		}
		observers.add(a);
		
	}

	@Override
	public void subtractObservers(ROIObserver a) {
		
		observers.remove(a);
	}
	@Override
	public List<ROIObserver> getObservers() {
		
		return observers;
	}
	@Override
	public void removeAllObservers() {
		
		observers.removeAll(observers);
		
	}
	
	

}
