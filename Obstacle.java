  
import java.awt.*;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public abstract class Obstacle {
	public final static String PATH_PREFIX = "obstacleImages";
	private Image image;
	
	private Rectangle hitbox;
	int xloc, yloc, width, height;
	
	
	protected Image getImage(String str) {
		Image img = null;
		str = PATH_PREFIX+str;
		try {
			
			img = ImageIO.read(this.getClass().getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public Obstacle(int xSpeed, String str) {
		
		xSpeed = 100;
		hitbox = new Rectangle(500, 500, 50, 50);
		
	}

	

	public void move() {
		hitbox.translate(100, 0);
	}

	public void draw(Graphics g) {
		g.drawRect(500, 500, 50, 50);
		g.drawImage(image, xloc, yloc, width, height, null);
	}

}
