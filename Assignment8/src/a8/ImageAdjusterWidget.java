package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageAdjusterWidget extends JPanel implements ChangeListener {

	private PictureView picture_view;
	private final Picture originalPic;
	private Picture editedPic;
	private JPanel blurPanel;
	private JPanel satPanel;
	private JPanel gridPanel;
	private JSlider blurSlider;
	private JSlider satSlider;
	private final JLabel blur;
	private final JLabel sat;
	

	public ImageAdjusterWidget(Picture picture) {
		setLayout(new BorderLayout());

		picture_view = new PictureView(picture.createObservable());
		originalPic = picture;
		editedPic = new PictureImpl(picture.getWidth(), picture.getHeight());

		add(picture_view, BorderLayout.CENTER);
		gridPanel=new JPanel();
		blurPanel = new JPanel();
		satPanel=new JPanel();
		blur = new JLabel("Blur:    ");
		sat=new JLabel("Saturation:    ");

		blurSlider = new JSlider(0, 5, 0);
		blurSlider.setPaintTicks(true);
		blurSlider.setMajorTickSpacing(1);
		blurSlider.setLabelTable(blurSlider.createStandardLabels(1));
		blurSlider.setPaintLabels(true);
		blurSlider.addChangeListener(this);
		
		satSlider=new JSlider(-100,100,0);
		satSlider.setPaintTicks(true);
		satSlider.setMajorTickSpacing(25);
		satSlider.setLabelTable(satSlider.createStandardLabels(25));
		satSlider.setSnapToTicks(true);
		satSlider.setPaintLabels(true);
		satSlider.addChangeListener(this);

		gridPanel.setLayout(new GridLayout(3,1));
		
		blurPanel.setLayout(new BoxLayout(blurPanel, 0));
		blurPanel.add(blur);
		blurPanel.add(blurSlider);
		
		satPanel.setLayout(new BoxLayout(satPanel,0));
		satPanel.add(sat);
		satPanel.add(satSlider);
		
		gridPanel.add(blurPanel);
		gridPanel.add(satPanel);
		
		add(gridPanel, BorderLayout.SOUTH);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int blurValue = blurSlider.getValue();
		if (blurValue != 0) {
			blurPicture(blurValue);
			picture_view.setPicture(editedPic.createObservable());
		}

		else {
			picture_view.setPicture(originalPic.createObservable());
		}

	}

	public void blurPicture(int value) {

		for (int i = 0; i < editedPic.getWidth(); i++) {
			for (int n = 0; n < editedPic.getHeight(); n++) {

				double averageRed = 0;
				double averageGreen = 0;
				double averageBlue = 0;
				double divisor = 0;

				for (int count = value; count > 0; count--) {
					try {
						averageRed += originalPic.getPixel(i - count, n).getRed();
						divisor++;
					} catch (Exception e) {

					}
					try {
						averageRed += originalPic.getPixel(i + count, n).getRed();
						divisor++;
					} catch (Exception e) {

					}
					try {
						averageRed += originalPic.getPixel(i, n + count).getRed();
						divisor++;
					} catch (Exception e) {
						
					}
					try {
						averageRed += originalPic.getPixel(i, n - count).getRed();
						divisor++;
					}

					catch (Exception e) {
						
					}
					
					try {
						averageRed += originalPic.getPixel(i+count, n + count).getRed();
						divisor++;
					}

					catch (Exception e) {
						
					}
					
					try {
						averageRed += originalPic.getPixel(i-count, n - count).getRed();
						divisor++;
					}

					catch (Exception e) {
						
					}
					
					try {
						averageRed += originalPic.getPixel(i+count, n - count).getRed();
						divisor++;
					}

					catch (Exception e) {
						
					}
					
					try {
						averageRed += originalPic.getPixel(i-count, n + count).getRed();
						divisor++;
					}

					catch (Exception e) {
						
					}
					try {
						averageGreen += originalPic.getPixel(i - count, n).getGreen();
					} catch (Exception e) {
						
					}
					try {
						averageGreen += originalPic.getPixel(i + count, n).getGreen();
					} catch (Exception e) {
						
					}
					try {
						averageGreen += originalPic.getPixel(i, n + count).getGreen();
					} catch (Exception e) {
						
					}
					try {
						averageGreen += originalPic.getPixel(i, n - count).getGreen();
					} catch (Exception e) {
						
					}
					
					try {
						averageGreen += originalPic.getPixel(i+count, n + count).getGreen();
					} catch (Exception e) {
						
					}
					
					try {
						averageGreen += originalPic.getPixel(i-count, n - count).getGreen();
					} catch (Exception e) {
						
					}
					
					try {
						averageGreen += originalPic.getPixel(i+count, n - count).getGreen();
					} catch (Exception e) {
						
					}
					
					try {
						averageGreen += originalPic.getPixel(i-count, n + count).getGreen();
					} catch (Exception e) {
						
					}
					
					
					try {
						averageBlue += originalPic.getPixel(i - count, n).getBlue();
					} catch (Exception e) {
						
					}
					try {
						averageBlue += originalPic.getPixel(i + count, n).getBlue();
					} catch (Exception e) {
						
					}
					try {
						averageBlue += originalPic.getPixel(i, n + count).getBlue();
					} catch (Exception e) {
						
					}
					try {
						averageBlue += originalPic.getPixel(i, n - count).getBlue();
					} catch (Exception e) {
						
					}
					
					try {
						averageBlue += originalPic.getPixel(i + count, n + count).getBlue();
					} catch (Exception e) {
						
					}
					
					try {
						averageBlue += originalPic.getPixel(i - count, n - count).getBlue();
					} catch (Exception e) {
						
					}
					
					try {
						averageBlue += originalPic.getPixel(i + count, n - count).getBlue();
					} catch (Exception e) {
						
					}
					
					try {
						averageBlue += originalPic.getPixel(i - count, n + count).getBlue();
					} catch (Exception e) {
						
					}
					

				}

				averageRed = averageRed / divisor;
				averageGreen = averageGreen / divisor;
				averageBlue = averageBlue / divisor;
				editedPic.setPixel(i, n, new ColorPixel(averageRed, averageGreen, averageBlue));

			}
		}
	}

}
