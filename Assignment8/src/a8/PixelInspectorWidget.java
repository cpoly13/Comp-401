package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorWidget extends JPanel implements MouseListener {
	private PictureView picture_view;
	private Pixel pixelHolder;
	private JPanel panel;
	private JLabel xValue;
	private JLabel yValue;
	private JLabel redValue;
	private JLabel greenValue;
	private JLabel blueValue;
	private JLabel brightness;

	public PixelInspectorWidget(Picture picture) {
		setLayout(new BorderLayout());

		picture_view = new PictureView(picture.createObservable());
		picture_view.addMouseListener(this);
		add(picture_view, BorderLayout.CENTER);

		pixelHolder = new ColorPixel(0.5, 0.5, 0.5);
		xValue = new JLabel("X:                             ");
		yValue = new JLabel("Y:           ");
		redValue = new JLabel("Red: ");
		greenValue = new JLabel("Green:  ");
		blueValue = new JLabel("Blue:  ");
		brightness = new JLabel("Brightness:   ");
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 1));
		setPanel();

		add(panel, BorderLayout.WEST);
	}

	public void setPanel() {
		panel.removeAll();
		panel.add(xValue);
		panel.add(yValue);
		panel.add(redValue);
		panel.add(greenValue);
		panel.add(blueValue);
		panel.add(brightness);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pixelHolder = picture_view.getPicture().getPixel(e.getX(), e.getY());
		xValue.setText("X: " + e.getX() + "                    ");
		yValue.setText("Y: " + e.getY());
		redValue.setText("Red: " + Math.round(pixelHolder.getRed() * 100.0) / 100.0);
		greenValue.setText("Green: " + Math.round(pixelHolder.getGreen() * 100.0) / 100.0);
		blueValue.setText("Blue: " + Math.round(pixelHolder.getBlue() * 100.0) / 100.0);
		brightness.setText("Brightness: " + Math.round(pixelHolder.getIntensity() * 100.0) / 100.0 + "  ");
		setPanel();
		add(panel, BorderLayout.WEST);

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
