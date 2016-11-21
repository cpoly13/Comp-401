package a8;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageAdjuster {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  
		Picture p=A8Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		ImageAdjusterWidget imageWidget=new ImageAdjusterWidget(p);
		
		JFrame mainFrame=new JFrame();
		mainFrame.setTitle("Assignment 8 Image Adjuster");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topPanel= new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(imageWidget, BorderLayout.CENTER);
		
		mainFrame.setContentPane(topPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}

}
