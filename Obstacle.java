import java.awt.*;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public abstract class Obstacle {
	private Rectangle hitbox;

	private int xloc;
	private int yloc;
	private int speed;
	private final int dim = 50;
	protected Image image;

	public Obstacle(int x, int y, int xspeed) {
		xloc = x;
		yloc = y;
		speed = xspeed;
		hitbox = new Rectangle(xloc, yloc, getDim(), getDim());
	}
	public void move() {
		hitbox.translate(speed, 0);
//		System.out.println("Moved " + speed);
	}
	
	public Rectangle getRect() {
		return hitbox;
	}

	public int getDim() {
		return dim;
	}
	
	public int getX() {
		return hitbox.x;
	}
	
	public int getY() {
		return hitbox.y;
	}
	
	public void draw(Graphics g) {
		g.drawRect(hitbox.x, hitbox.y, 50, 50);
		g.fillRect(hitbox.x, hitbox.y, 50, 50);
	//	g.drawRect(xloc, yloc, width, height);
	}
	
	public int collidesWith(Dasher d) {
		return 1000;
	}

}
