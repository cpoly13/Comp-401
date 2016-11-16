package a8;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PixelInspector {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Picture p=A8Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		PixelInspectorWidget temp =new PixelInspectorWidget(p,"Hope this works...");
		
		JFrame mainFrame=new JFrame();
		mainFrame.setTitle("Assignment 8 Pixel Inspector");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topPanel= new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(temp, BorderLayout.CENTER);
		
		
		mainFrame.setContentPane(topPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
