import java.awt.*;
import java.util.*;
import javax.swing.*;
public abstract class Obstacle {
	
	private Rectangle hitbox;
	int xloc, yloc, width, height, speed;
	
	public Obstacle(int xspeed) {
		speed = xspeed;
		hitbox = new Rectangle(500, 500, 50, 50);
	}

	public void move() {
		hitbox.translate(speed, 0);
	}

	public void draw(Graphics g) {
		g.drawRect(500, 500, 50, 50);
	}

}
