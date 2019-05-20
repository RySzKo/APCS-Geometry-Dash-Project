import java.awt.Graphics;
import java.util.ArrayList;

public class GeoDashGame {

	ArrayList<Obstacle> obstacles = new ArrayList<>();

	Dasher player;
	// Triangle triangle = new Triangle(0, null);
	Block block;

	public GeoDashGame() {
		player = new Dasher(null);
		int maxHeight = 40;
		int maxLength = 40;
		int maxDistance = 100;
		int lastBlockEndX = 200;
		for (int i = 0; i < 10; i++) {
			boolean isBlock = (((int) (Math.random() * 10)) % 2) == 0;
			Obstacle obstacle = null;
			if (isBlock) {
				int xval = (int) (Math.random() * maxDistance) + 10 + lastBlockEndX;
				int bx = maxLength;
				int by = maxHeight;
				int yval = 500 - maxHeight;
				obstacle = new Block(xval, yval, bx, by);
				lastBlockEndX = xval + bx;
			} else {
				int x1 = (int) (Math.random() * maxDistance) + 10 + lastBlockEndX;
				int x2 = x1 + 20;
				int y2 = 500 - maxHeight;
				int y1 = 500;
				int x3 = x2 + 20;
				int y3 = 500;
				obstacle = new Triangle(x1, y1, x2, y2, x3, y3);
				lastBlockEndX = x3;
			}
			obstacles.add(obstacle);
		}
	}

	public void draw(Graphics g) {
		player.draw(g);
		for (Obstacle ob : obstacles) {
			ob.draw(g);
		}
	}

	public void move() {
		for (Obstacle ob : obstacles) {
			ob.moveObjects();
		}
	}

	public void movePlayer(int y) {
		player.move(y);

	}

	public void keyHit(String s) {
		System.out.println("key was hit");
	}

}
