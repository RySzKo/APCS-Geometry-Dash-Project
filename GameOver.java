import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameOver extends JWindow{ 
	private JPanel panel;
	private BufferedImage i;
	private int counter = 1;
	private  JButton button = new JButton("Play Again!");
	private static final int WIDT = 100, HEIGH=50;
	private Image img;
	private int x,y;
	private Rectangle rect;
		



	
	public void end(String life) {
		// Need to create and set up window.
		//System.out.println("ABC");
		JFrame frame = new JFrame("Geometry Dash");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Need to display window.
		try {
			i=ImageIO.read(this.getClass().getResource("gameOver.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw(g);
				//g.drawString("Congratulations! you have lived for " + life + " ms !", 0, 0);

			}
		};
		button.setBounds(0,0,500,500);
		JLabel label = new JLabel("               Congratulations! you have got score:" + life + "!");
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		
		panel.add(label);
		panel.add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					 new GeoRunner(frame).start();
			}
				
		});
		
		panel.setPreferredSize(new Dimension(800, 600));
		frame.add(panel);
		panel.setBackground(Color.BLACK);
		frame.pack();
		frame.setVisible(true);
	
		}
		

	public void draw(Graphics g) {
		

			BufferedImage newImg = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_ARGB);
			
			Graphics2D d = newImg.createGraphics();
			d.drawImage(i, 0, 0, i.getWidth(null), i.getHeight(null), null);

			g.drawImage(newImg, 0, 0, i.getWidth(null), i.getHeight(null), null);
		
	


}
}

