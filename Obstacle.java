import java.awt.*;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public abstract class Obstacle {
	
	private Rectangle hitbox;
	private Image image;
	public final static String PATH_PREFIX = "res/images/";

	
	protected  Image getImage(String fn) {
		Image img = null;
		fn = PATH_PREFIX+fn;
		try {
			
			//img = ImageIO.read(this.getClass().getResource(fn));
			img = ImageIO.read(this.getClass().getResource("res/images/triangle.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	
	public Obstacle(int xspeed, String str) {
		
	}

	public void draw(Graphics g) {
	}

}
