package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorWidget extends JPanel implements MouseListener {
private PictureView picture_view;
	
	public PixelInspectorWidget(Picture picture, String title) {
		setLayout(new BorderLayout());
		
		picture_view = new PictureView(picture.createObservable());
		picture_view.addMouseListener(this);
		add(picture_view, BorderLayout.CENTER);
		
		JLabel xValue = new JLabel("X:           ");
		JLabel yValue=new JLabel("Y:           ");
		JLabel redValue=new JLabel("Red: ");
		JLabel blueValue=new JLabel("Blue:  ");
		JLabel greenValue=new JLabel("Green:  ");
		JLabel brightness=new JLabel("Brightness: ");
		JPanel please=new JPanel();
		please.setLayout(new GridLayout(6,1));
		please.add(xValue);
		please.add(yValue);
		please.add(redValue);
		please.add(greenValue);
		please.add(blueValue);
		please.add(brightness);
		add(please, BorderLayout.WEST);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("You clicked on the frame at: " + e.getX() + "," + e.getY());
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

}


