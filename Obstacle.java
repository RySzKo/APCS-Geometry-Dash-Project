import java.awt.*;
import java.util.*;
import javax.swing.*;
public abstract class Obstacle {
	//update by Devang
	private Rectangle hitbox;
	int xloc=600, yloc=450, width=50, height=50;
	
	public Obstacle(int xspeed, String str) {
		xspeed = 100;
		hitbox = new Rectangle(xloc, yloc, width, height);
	}

	public void move() {
		hitbox.translate(100, 0);
	}

	public void draw(Graphics g) {
		g.drawRect(xloc, yloc, width, height);
	}

}
