import java.awt.Graphics;
import java.awt.Rectangle;

public class Dasher {

	private Rectangle rect;
	private final int xval = 100, dasherdim = 50;
	private int yval, seconds;

	public Dasher() {
		yval = 450;
		rect = new Rectangle(xval, yval, dasherdim, dasherdim);
	}
	
	public void draw(Graphics g) {
		g.drawRect(rect.x, rect.y, dasherdim, dasherdim);
		g.fillRect(rect.x, rect.y, dasherdim, dasherdim);
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public void move(double gravity) {
		rect.translate(0, (int) gravity);
		System.out.println("Moved " + gravity);
	}
	
	
}
