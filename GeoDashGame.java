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

	Dasher player;
	Obstacle triangle, block;
	//	Block block;

	public GeoDashGame() {
		player = new Dasher(null);

		//Devang: created and added obstacles
		triangle = new Triangle(10, null);
		obstacles.add(triangle);

		block = new Block(10, null);
		obstacles.add(block);
	}

	//	
	public void keyHit(String s) {
		System.out.println("GeoDash (keyHit): "+s);

	}
	

	public void draw(Graphics g) {
		player.draw(g);
		for(Obstacle ob: obstacles) {
			ob.draw(g);
			}
		}

	
	



	public void move() {
		player.move(-10);
		for(Obstacle ob: obstacles) {
			ob.move();
		}
	}

	public void moveObjects() {
		for(Obstacle ob: obstacles) {
			ob.moveObjects();
			//triangle.move();
			
			
		}
	}




}