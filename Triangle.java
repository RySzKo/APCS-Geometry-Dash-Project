import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class Triangle extends Obstacle{
	
	private Rectangle hitbox;
	private int xloc =400, yloc = 450, width=50, height=50;

	public Triangle(int xSpeed, Image i) {
		super(xSpeed, "triangle.png");
		image = getImage("triangle.png");
		//Devang: added image for obstacles
		xSpeed = 100;
		hitbox = new Rectangle(xloc, yloc, 50, 50);
		

	}

	
	
	
}

	
	
	
	/*protected Image getImage(String str) {
		Image img = null;
		str = PATH_PREFIX+str;
		try {
			
			img = ImageIO.read(this.getClass().getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	*/
	
	
		