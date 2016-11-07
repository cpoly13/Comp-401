package a7;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ObservablePictureImpl implements ObservablePicture {

	private Picture pic;
	private List<RegionWithObservers> regionsObserved;
	private boolean suspendObservers;
	private List<Region> pixelsChanged;

	public ObservablePictureImpl(Picture p) {
		if (p == null) {
			throw new IllegalArgumentException("Picture object is null");
		}

		pic = p;
		regionsObserved = new ArrayList<RegionWithObservers>();
		suspendObservers = false;
		pixelsChanged = new ArrayList<Region>();

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
		if(p==null){
			throw new IllegalArgumentException();
		}
		this.pic.setPixel(x, y, p);

		Region tiny = new RegionImpl(new Coordinate(x, y), new Coordinate(x, y));
		if (suspendObservers == false) {
			for (RegionWithObservers r : regionsObserved) {
				try {
					Region intersectTest = r.intersect(tiny);
					Iterator<ROIObserver> observerIterator = r.getObservers().iterator();

					if (observerIterator.hasNext()) {
						observerIterator.next().notify(this, intersectTest);
					}

				} catch (NoIntersectionException e) {
					// normal, indicates pixel not in region
				}
			}
		}

		else {
			pixelsChanged.add(tiny);
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

		if (observer == null || r == null) {
			throw new IllegalArgumentException("Region or observer object/s were null");
		}
		RegionWithObserversImpl a = new RegionWithObserversImpl(r);
		a.addObservers(observer);
		regionsObserved.add(a);

	}

	@Override
	public void unregisterROIObservers(Region r) {
		// TODO Auto-generated method stub
		if (r == null) {
			throw new IllegalArgumentException("Region can't be null");
		}
		for (RegionWithObservers i : regionsObserved) {
			try {
				i.intersect(r);
				i.removeAllObservers();

			} catch (NoIntersectionException e) {
				// normal behavior, indicates no intersection

			}
		}

	}

	@Override
	public void unregisterROIObserver(ROIObserver observer) {

		if (observer == null) {
			throw new IllegalArgumentException("Observer can't be null");
		}

		for (RegionWithObservers r : regionsObserved) {
			r.subtractObservers(observer);
		}
	}

	@Override
	public ROIObserver[] findROIObservers(Region r) {
		// TODO Auto-generated method stub
		if (r == null) {
			throw new IllegalArgumentException("Region can't be null");
		}
		int countObservers = 0;
		for (RegionWithObservers o : regionsObserved) {
			countObservers += o.getObservers().size();
		}
		int count = 0;
		ROIObserver[] observers = new ROIObserver[countObservers];
		for (RegionWithObservers i : regionsObserved) {
			try {
				i.intersect(r);

				for (ROIObserver o : i.getObservers()) {
					observers[count] = o;
					count++;
				}
			} catch (NoIntersectionException e) {
				// normal behavior, indicates no intersection

			}

		}
		return observers;
	}

	@Override
	public void suspendObservable() {

		suspendObservers = true;

	}

	@Override
	public void resumeObservable() {
		// TODO Auto-generated method stub
		suspendObservers = false;
		if (!pixelsChanged.isEmpty()) {
			Region toUpdate = pixelsChanged.get(0);
			for (int count = 1; count < pixelsChanged.size(); count++) {

				toUpdate.union(pixelsChanged.get(count));

			}

			for (RegionWithObservers r : regionsObserved) {
				try {
					Region intersectTest = r.intersect(toUpdate);
					Iterator<ROIObserver> observerIterator = r.getObservers().iterator();

					if (observerIterator.hasNext()) {
						observerIterator.next().notify(this, intersectTest);
					}

				} catch (NoIntersectionException e) {
					// normal, indicates pixel not in region
				}
			}
		}
	}

}
