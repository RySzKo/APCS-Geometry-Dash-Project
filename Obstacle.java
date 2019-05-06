import java.awt.*;
import java.util.*;
import javax.swing.*;
public abstract class Obstacle {
	//update by Devang
	private Rectangle hitbox;
	private Image image;
	int xloc=600, yloc=450, width=50, height=50;
	
	public Obstacle(int xSpeed, String str) {
		xSpeed = 100;
		hitbox = new Rectangle(xloc, yloc, width, height);
	}

	public void move() {
		hitbox.translate(100, 0);
	}

	public void draw(Graphics g) {
		g.drawRect(xloc, yloc, width, height);
	}

	public void moveObjects() {
		this.hitbox.translate(xloc, yloc);
	}


}
