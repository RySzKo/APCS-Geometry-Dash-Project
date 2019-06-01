import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SplashScreen extends JWindow{ 
	private JPanel panel;
	private BufferedImage i;
	private int counter = 1;
	private boolean clear = false;
	JFrame frame = null;
//	private  JButton button = new JButton("button");
	
	public JFrame getFrame() {
		return frame;
	}


	public void createWindow() {
		// Need to create and set up window.
		frame = new JFrame("Geometry Dash");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Need to display window.
		try {
			i=ImageIO.read(this.getClass().getResource("geoDashScreen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw(g);
			}
		};
		panel.setPreferredSize(new Dimension(i.getWidth(), i.getHeight()));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}
		}
		

	public void draw(Graphics g) {
		if (!clear) {
			BufferedImage newImg = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_ARGB);

			Graphics2D d = newImg.createGraphics();
			d.drawImage(i, 0, 0, i.getWidth(null), i.getHeight(null), null);
			g.drawImage(newImg, 0, 0, i.getWidth(null), i.getHeight(null), null);
		}
	


}
}

