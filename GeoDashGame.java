import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GeoDashGame {
	private Graphics g;
	private JPanel panel = new JPanel() ;

	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	private ArrayList<Obstacle> triangles = new ArrayList<>();
	private ArrayList<Obstacle> blocks = new ArrayList<>();

	private Dasher player;
	Obstacle triangle, block;
//	Block block;
	
	public GeoDashGame() {
		player = new Dasher();
		
		//Devang: created and added obstacles
		triangle = new Triangle(10, null);
		obstacles.add(triangle);
		
		block = new Block(10, null);
		obstacles.add(block);
	}
	
//	public void draw() {
//		player.draw(g);
//		// create the panel
//		panel = new JPanel();
//		JFrame frame = new JFrame("Geometry Dash");
//		
//		// set panel properties, e.g., color, size, etc.
//		panel.setBackground(Color.BLUE);
//		panel.setPreferredSize(new Dimension(800, 600));
//		frame.add(panel);
//		frame.pack();
//		frame.setVisible(true);
//		panel.requestFocusInWindow();
//		
//		this.graphics = panel.getGraphics();
//
//		// add various components of the game:
//		//    - player
//		//    - 1st obstacle
////		Dasher dasher = new Dasher();
////		Triangle traingle = new Triangle(10, null);
//		panel.add(player);
//		panel.add(triangle);
//		
//		
//		// draw various components
//		
//		// line
//		graphics.drawLine(0, 500, 2000, 500);
//
//		// player & other obstacles
		
	//}
		
		
	public void draw(Graphics g) {
		player.draw(g);
		for(Obstacle ob: obstacles) {
			ob.draw(g);
		}


//		int x = 600;
//		for(int i = 0; i<5; i++) {
//		a.draw(g, x, 450);
//		x-=200;
//		TimeUnit.SECONDS.sleep(1);
//
//		b.draw(g, x, 450);
		//triangle.move(g, x, 450);

//		g.clearRect(x+100, 450, 51, 50);
//		g.setColor(Color.BLUE);
//		g.fillRect(x+100, 450, 51, 50);
	//	Thread.sleep(1000);

		//triangle.draw(g, 400, 450);
		//g.clearRect(500, 450, 51, 50);
		//g.setColor(Color.BLUE);
		//g.fillRect(500, 450, 51, 50);
		
		}
		
		//triangle.draw(g, 400, 450);

	
	
	public void move() {
		player.move(-10);
		for(Obstacle ob: obstacles) {
			ob.move();
		}
	}


	
	
}