import java.awt.*;
import java.util.*;
import javax.swing.*;


public class GeoRunner {
	private JPanel panel;
	private GeoDashGame game = new GeoDashGame();

	public static void main(String[] args) {
		new GeoRunner().start();
		
	}


	private void start() {
		JFrame frame = new JFrame("Geometry Dash");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawGame(g);
			}
			
		};
		
		panel.setBackground(Color.BLUE);
		panel.setPreferredSize(new Dimension(800, 600));
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		panel.requestFocusInWindow();
		
	}


	protected void drawGame(Graphics g) {
		
	}
}