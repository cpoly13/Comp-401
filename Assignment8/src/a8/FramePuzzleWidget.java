package a8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FramePuzzleWidget extends JPanel implements ChangeListener, MouseListener, KeyListener {
	private PictureView[][] pictureViews;
	private PictureView redPicture;
	private JPanel[][] panels;
	private final Picture originalPic;
	private final Picture redTile;
	private Iterator<SubPicture> iter;
	private PictureView inFocus;

	public FramePuzzleWidget(Picture p) {
		
		setLayout(new GridLayout(5, 5));
		this.setPreferredSize(new Dimension(655, 495));
		
		this.setFocusable(true);
		this.addKeyListener(this);
		
		requestFocus();
		originalPic = p;
		redTile = new PictureImpl(originalPic.getWidth() / 5, originalPic.getHeight() / 5);

		for (int i = 0; i < redTile.getWidth(); i++)
			for (int n = 0; n < redTile.getHeight(); n++) {
				redTile.setPixel(i, n, new ColorPixel(1, 0, 0));
			}
		redPicture = new PictureView(redTile.createObservable());
		redPicture.addMouseListener(this);
		redPicture.addKeyListener(this);
		redPicture.setFocusable(true);
		redPicture.requestFocus();
		inFocus=redPicture;
		

		pictureViews = new PictureView[5][5];
		panels = new JPanel[5][5];
		iter = new TileIterator(originalPic, originalPic.getWidth() / 5, originalPic.getHeight() / 5);

		for (int i = 0; i < pictureViews.length; i++) {
			for (int n = 0; n < pictureViews[0].length; n++) {
				if (iter.hasNext()) {
					pictureViews[i][n] = new PictureView(iter.next().createObservable());
					pictureViews[i][n].addMouseListener(this);
					pictureViews[i][n].addKeyListener(this);
					pictureViews[i][n].setFocusable(true);
					
				}
			}
		}
		pictureViews[4][4] = redPicture;
		for (int i = 0; i < panels.length; i++) {
			for (int n = 0; n < panels[0].length; n++) {
				panels[i][n] = new JPanel();
				panels[i][n].setLayout(new BorderLayout());
				panels[i][n].add(pictureViews[i][n]);
				add(panels[i][n]);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		PictureView pictureClicked = (PictureView) e.getComponent();
		pictureClicked.requestFocus();
		
		Coordinate picCoord = getArrayCoordinates(pictureClicked);
		Coordinate redCoord = getArrayCoordinates(redPicture);

		for (int i = 0; i < panels.length; i++) {
			for (int n = 0; n < panels[0].length; n++) {
				PictureView holder = (PictureView) panels[i][n].getComponent(0);
				if (checkForRed(holder.getPicture())) {
					redCoord = getArrayCoordinates(holder);
					break;
				}
			}

		}

		System.out.println("PictureView clicked: " + picCoord.getX() + " " + picCoord.getY());
		System.out.println("RedTile: " + redCoord.getX() + " " + redCoord.getY());

		if (picCoord.getX() == redCoord.getX() && picCoord.getY() < redCoord.getY()) {
			inFocus=pictureClicked;
			int length = Math.abs(redCoord.getY() - picCoord.getY());
			System.out.println("Matching Row");
			System.out.println("Distance: " + length + " Tiles");
			PictureView holder = new PictureView(redTile.createObservable());
			Picture tempo = pictureClicked.getPicture();

			while (length > 0) {

				PictureView toChange = (PictureView) panels[picCoord.getX()][picCoord.getY() + length].getComponent(0);
				holder = (PictureView) panels[picCoord.getX()][picCoord.getY() + length - 1].getComponent(0);
				tempo = holder.getPicture();
				toChange.setPicture(tempo.createObservable());

				length--;
			}
			pictureClicked.setPicture(redTile.createObservable());

		}
		
		else if (picCoord.getX() == redCoord.getX() && picCoord.getY() > redCoord.getY()) {
			inFocus=pictureClicked;
			int length = Math.abs(redCoord.getY() - picCoord.getY());
			System.out.println("Matching Row");
			System.out.println("Distance: " + length + " Tiles");
			PictureView holder = new PictureView(redTile.createObservable());
			Picture tempo = pictureClicked.getPicture();

			while (length > 0) {

				PictureView toChange = (PictureView) panels[picCoord.getX()][picCoord.getY() - length].getComponent(0);
				holder = (PictureView) panels[picCoord.getX()][picCoord.getY() - length + 1].getComponent(0);
				tempo = holder.getPicture();
				toChange.setPicture(tempo.createObservable());

				length--;
			}
			pictureClicked.setPicture(redTile.createObservable());

		}
		
		else if (picCoord.getY() == redCoord.getY() && picCoord.getX() < redCoord.getX()) {
			inFocus=pictureClicked;
			int length = Math.abs(redCoord.getX() - picCoord.getX());
			System.out.println("Matching Row");
			System.out.println("Distance: " + length + " Tiles");
			
			PictureView holder = new PictureView(redTile.createObservable());
			Picture tempo = pictureClicked.getPicture();

			while (length > 0) {

				PictureView toChange = (PictureView) panels[picCoord.getX()+ length][picCoord.getY()].getComponent(0);
				holder = (PictureView) panels[picCoord.getX()+length-1][picCoord.getY()].getComponent(0);
				tempo = holder.getPicture();
				toChange.setPicture(tempo.createObservable());

				length--;
			}
			pictureClicked.setPicture(redTile.createObservable());

		}
		
		else if (picCoord.getY() == redCoord.getY() && picCoord.getX() > redCoord.getX()) {
			inFocus=pictureClicked;
			int length = Math.abs(redCoord.getX() - picCoord.getX());
			System.out.println("Matching Row");
			System.out.println("Distance: " + length + " Tiles");
			
			PictureView holder = new PictureView(redTile.createObservable());
			Picture tempo = pictureClicked.getPicture();

			while (length > 0) {

				PictureView toChange = (PictureView) panels[picCoord.getX()- length][picCoord.getY()].getComponent(0);
				holder = (PictureView) panels[picCoord.getX()-length+1][picCoord.getY()].getComponent(0);
				tempo = holder.getPicture();
				toChange.setPicture(tempo.createObservable());

				length--;
			}
			pictureClicked.setPicture(redTile.createObservable());

		}

	}

	public Coordinate getArrayCoordinates(PictureView p) {

		for (int i = 0; i < panels.length; i++) {
			for (int n = 0; n < panels[0].length; n++) {

				if (p == panels[i][n].getComponent(0)) {
					return new Coordinate(i, n);
				}

			}
		}
		throw new RuntimeException("Logic error in getArrayCoordinates");
	}

	public boolean checkForRed(Picture p) {
		boolean red = true;
		for (int i = 0; i < p.getWidth(); i++) {
			for (int n = 0; n < p.getHeight(); n++)
				if (p.getPixel(i, n).getRed() != 1) {
					red = false;
					break;
				}

		}
		return red;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Success!");
		PictureView pictureClicked = inFocus;
		
		for (int i = 0; i < pictureViews.length; i++) {
			for (int n = 0; n < pictureViews[0].length; n++) {
				if(pictureViews[i][n]==inFocus){
					try{
						if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
							pictureClicked=pictureViews[i][n-1];
						}
						
						else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
							pictureClicked=pictureViews[i][n+1];
						}
						
						else if(arg0.getKeyCode()==KeyEvent.VK_UP){
							pictureClicked=pictureViews[i-1][n];
						}
						
						else if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
							pictureClicked=pictureViews[i+1][n];
						}
					}
					catch (Exception e){
						
					}
				}
			}
		}
		
		
		pictureClicked.requestFocus();
		inFocus=pictureClicked;
		Coordinate picCoord = getArrayCoordinates(pictureClicked);
		Coordinate redCoord = getArrayCoordinates(redPicture);

		for (int i = 0; i < panels.length; i++) {
			for (int n = 0; n < panels[0].length; n++) {
				PictureView holder = (PictureView) panels[i][n].getComponent(0);
				if (checkForRed(holder.getPicture())) {
					redCoord = getArrayCoordinates(holder);
					break;
				}
			}

		}

		System.out.println("PictureView clicked: " + picCoord.getX() + " " + picCoord.getY());
		System.out.println("RedTile: " + redCoord.getX() + " " + redCoord.getY());

		if (picCoord.getX() == redCoord.getX() && picCoord.getY() < redCoord.getY()) {
			int length = Math.abs(redCoord.getY() - picCoord.getY());
			System.out.println("Matching Row");
			System.out.println("Distance: " + length + " Tiles");

			PictureView holder = new PictureView(redTile.createObservable());
			Picture tempo = pictureClicked.getPicture();

			while (length > 0) {

				PictureView toChange = (PictureView) panels[picCoord.getX()][picCoord.getY() + length].getComponent(0);
				holder = (PictureView) panels[picCoord.getX()][picCoord.getY() + length - 1].getComponent(0);
				tempo = holder.getPicture();
				toChange.setPicture(tempo.createObservable());

				length--;
			}
			pictureClicked.setPicture(redTile.createObservable());

		}
		
		else if (picCoord.getX() == redCoord.getX() && picCoord.getY() > redCoord.getY()) {
			int length = Math.abs(redCoord.getY() - picCoord.getY());
			System.out.println("Matching Row");
			System.out.println("Distance: " + length + " Tiles");
			
			PictureView holder = new PictureView(redTile.createObservable());
			Picture tempo = pictureClicked.getPicture();

			while (length > 0) {

				PictureView toChange = (PictureView) panels[picCoord.getX()][picCoord.getY() - length].getComponent(0);
				holder = (PictureView) panels[picCoord.getX()][picCoord.getY() - length + 1].getComponent(0);
				tempo = holder.getPicture();
				toChange.setPicture(tempo.createObservable());

				length--;
			}
			pictureClicked.setPicture(redTile.createObservable());

		}
		
		else if (picCoord.getY() == redCoord.getY() && picCoord.getX() < redCoord.getX()) {
			int length = Math.abs(redCoord.getX() - picCoord.getX());
			System.out.println("Matching Row");
			System.out.println("Distance: " + length + " Tiles");
			
			PictureView holder = new PictureView(redTile.createObservable());
			Picture tempo = pictureClicked.getPicture();

			while (length > 0) {

				PictureView toChange = (PictureView) panels[picCoord.getX()+ length][picCoord.getY()].getComponent(0);
				holder = (PictureView) panels[picCoord.getX()+length-1][picCoord.getY()].getComponent(0);
				tempo = holder.getPicture();
				toChange.setPicture(tempo.createObservable());

				length--;
			}
			pictureClicked.setPicture(redTile.createObservable());

		}
		
		else if (picCoord.getY() == redCoord.getY() && picCoord.getX() > redCoord.getX()) {
			int length = Math.abs(redCoord.getX() - picCoord.getX());
			System.out.println("Matching Row");
			System.out.println("Distance: " + length + " Tiles");
			
			PictureView holder = new PictureView(redTile.createObservable());
			Picture tempo = pictureClicked.getPicture();

			while (length > 0) {

				PictureView toChange = (PictureView) panels[picCoord.getX()- length][picCoord.getY()].getComponent(0);
				holder = (PictureView) panels[picCoord.getX()-length+1][picCoord.getY()].getComponent(0);
				tempo = holder.getPicture();
				toChange.setPicture(tempo.createObservable());

				length--;
			}
			pictureClicked.setPicture(redTile.createObservable());

		}

	}
		
	
		
		
		
		
		
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
