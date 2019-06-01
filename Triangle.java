
	
		import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

public class Triangle implements Obstacle {

	private Polygon hitbox;
	
	public Triangle(int x, int y, int speed){
		int[] xList = {x, x + defaultDim, x + (defaultDim/2)};
		int[] yList = {y + defaultDim, y + defaultDim, y};
		hitbox = new Polygon(xList, yList, 3);
	}
	@Override
	public void move(int speed) {
		hitbox.translate(speed, 0);
	}

	@Override
	public double getDim() {
		return defaultDim;
	}

	@Override
	public int getX() {
		return hitbox.getBounds().x;
	}

	@Override
	public int getY() {
		return hitbox.getBounds().x;
	}

	@Override
	public void draw(Graphics g) {
		g.drawPolygon(hitbox);
		g.fillPolygon(hitbox);
	}

	@Override
	public int collidesWith(Dasher d) {
		if(hitbox.intersects(d.getRect())) {
			return 0;
		}
		return -1;
	}
	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}



