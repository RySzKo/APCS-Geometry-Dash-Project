import java.awt.*;
import java.util.*;
import javax.swing.*;
public abstract class Obstacle {
	
	private Rectangle hitbox;
	int xloc, yloc, width, height;
	
	public Obstacle(int xspeed) {
		xspeed = 100;
		hitbox = new Rectangle(500, 500, 50, 50);
	}

	public void move() {
		hitbox.translate(100, 0);
	}

	public void draw(Graphics g) {
		g.drawRect(500, 500, 50, 50);
	}

}
