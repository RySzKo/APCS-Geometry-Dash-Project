import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

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
			
			
			panel.requestFocusInWindow();
			
			// this timer controls the actions in the game and then repaints after each update to data
			timer = new Timer(REFRESH_RATE, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					updateGame();
					panel.repaint();
				}
			});
			timer.start();
		}

		// this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
		protected void updateGame() {
			ticks++;// keeps track of the number of times the timer has gone off
			game.moveObjects();
			int hurts = 1000/REFRESH_RATE;
			if(ticks %hurts == 0) {
				System.out.println(ticks/hurts+" seconds");
			}
		}

		};
	}
	
	
	
}
