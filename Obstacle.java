import java.awt.*;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public abstract class Obstacle {
	//update by Devang
	
	public final static String PATH_PREFIX = "obstacleImages/";
	private Rectangle hitbox;
	protected Image image;
	private int speed;
	private int xloc=600, yloc=450, width=50, height=50;

	public Obstacle() {
		// TODO Auto-generated constructor stub
	}



	protected  Image getImage(String fn) {
		Image img = null;
		fn = PATH_PREFIX+fn;
		try {
			
			img = ImageIO.read(this.getClass().getResource(fn));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	
	
/*	public Obstacle(int xspeed) {
		speed = xspeed;
		hitbox = new Rectangle(xloc, yloc, width, height);
	}
	
	

	public Obstacle(int xSpeed, String str) {
		xSpeed = 100;
		hitbox = new Rectangle(xloc, yloc, width, height);
	}
*/	
	
	public void move() {
		hitbox.translate(speed, 0);
	}
	

	public void moveObjects() {
		this.hitbox.translate(0, -50);
	}



	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
