import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Triangle extends Obstacle {

	private Rectangle hitbox;
	private int xloc = 400, yloc = 450, width = 50, height = 50;

	public Triangle(int xSpeed, Image i) {
		super();
		image = getImage("triangle.png");
		xSpeed = 100;
		hitbox = new Rectangle(xloc, yloc, 50, 50);
	}

	private int x1;
	private int y1;

	private int x2;
	private int y2;

	private int x3;
	private int y3;

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	public void draw(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x3, y3, x1, y1);
		g.drawLine(x2, y2, x3, y3);

	}
}
