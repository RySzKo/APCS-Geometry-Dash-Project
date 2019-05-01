import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
				panel.repaint();
			}
			
		};
		
		panel.setBackground(Color.BLUE);
		panel.setPreferredSize(new Dimension(800, 600));
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		panel.requestFocusInWindow();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				clickedAt(me);
				panel.repaint();
			}
		});

	}


	protected void clickedAt(MouseEvent me) {
		game.move();
		System.out.println("Click Works");
	}


	protected void drawGame(Graphics g) {
		game.draw(g);
	}
}