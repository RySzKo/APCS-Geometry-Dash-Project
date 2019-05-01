import java.awt.Graphics;
import java.awt.Rectangle;

public class Dasher {

	private Rectangle rect;
	private final int xval = 100, dasherdim = 50;
	private int yval;

	public Dasher() {
		yval = 500;
		rect = new Rectangle(xval, yval, dasherdim, dasherdim);
	}
	
	public void draw(Graphics g) {
		g.drawRect(rect.x, rect.y, dasherdim, dasherdim);
		g.fillRect(rect.x, rect.y, dasherdim, dasherdim);
	}
	
	public void move(int y) {
		rect.translate(0, y);
		System.out.println("Move Works");
	}
}
