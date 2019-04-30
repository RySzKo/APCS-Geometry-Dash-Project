import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GeoRunner {
	private JPanel panel;
	private GeoDashGame game = new GeoDashGame();

	// public static Dimension screenSize =
	// Toolkit.getDefaultToolkit().getScreenSize();
	// public static final int WIDTH = (int)
	// (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	// private static final int REFRESH_RATE = 10;

	public static void main(String[] args) {
		new GeoRunner();
	}
//asdfasdlkfjal;sdfjlfs;dkhello
	//test 2
	
	
	private void start() {
		JFrame frame = new JFrame("Geometry Dash");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawGame(g);
			}

			private void drawGame(Graphics g) {

			}

		};
	}
}
