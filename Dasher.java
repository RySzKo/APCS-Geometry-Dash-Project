import java.awt.Graphics;
import java.awt.Rectangle;

public class Dasher {

	private Rectangle rect;
	private final int xval = 100, dasherdim = 50;
	private int yval;

	public Dasher() {
		yval = 100;
		Rectangle rect = new Rectangle(xval, yval, dasherdim, dasherdim);
	}
	
	public void draw(Graphics g) {
		g.drawRect(xval, yval, dasherdim, dasherdim);
		g.fillRect(xval, yval, dasherdim, dasherdim);
	}
}
