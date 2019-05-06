import java.awt.*;
import java.util.*;
import javax.swing.*;
public abstract class Obstacle {
	
	private Rectangle hitbox;
	int xloc=500, yloc=500, width=50, height=50;
	
	public Obstacle(int xspeed, String str) {
		xspeed = 100;
		hitbox = new Rectangle(xloc, xloc, width, height);
	}

	public void move() {
		hitbox.translate(100, 0);
	}

	public void draw(Graphics g) {
		g.drawRect(xloc, xloc, width, height);
	}

}
