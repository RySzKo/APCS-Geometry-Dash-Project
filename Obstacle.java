import java.awt.*;
import java.util.*;
import javax.swing.*;
public abstract class Obstacle {
	
	private Rectangle hitbox;
	private int xloc;
	private int yloc;
	private int width;
	private int height;
	private int speed;
	private final int dim = 50;
	
	public Obstacle(int x, int y, int xspeed) {
		xloc = x;
		yloc = y;
		speed = xspeed;
		hitbox = new Rectangle(xloc, yloc, getDim(), getDim());
	}

	public void move() {
		hitbox.translate(speed, 0);
	}
	
	public Rectangle getRect() {
		return hitbox;
	}

	public int getDim() {
		return dim;
	}
	
	public int getX() {
		return xloc;
	}
	
	public int getY() {
		return yloc;
	}
	
	public void draw(Graphics g) {
		g.drawRect(xloc, yloc, 50, 50);
		g.fillRect(xloc, yloc, 50, 50);
	}

}
