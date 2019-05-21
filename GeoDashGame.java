import java.awt.Graphics;
import java.util.ArrayList;

public class GeoDashGame {
	
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	private Dasher player;
	private Obstacle ob1, ob2;
	private int floorY;
	
	public GeoDashGame() {
		player = new Dasher();
		Obstacle ob1 = new Block(450, 450, -3);
		obstacles.add(ob1);
		player = new Dasher();
		Obstacle ob2 = new Block(600, 450, -3);
		obstacles.add(ob2);
		
	}
	

	public void draw(Graphics g) {
		player.draw(g);
		for(Obstacle ob: obstacles) {
			ob.draw(g);
		}
	}
	
	public void move() {
		for(Obstacle ob: obstacles) {
			ob.move();
		}
	}
	public void movePlayer(double gravity) {
		player.move(gravity);
	}
	
//	public int checkForCollision() {
//		
//	}
//	
	public int setFloor(Obstacle f) {
		return f.getY();
	}
	
	public int resetFloor() {
		return 450;
	}
	
	public Dasher getPlayer() {
		return player;
	}


	public void checkCollisions() {
		for(Obstacle ob: obstacles) {
//			System.out.println("Checking");
			if (ob.collidesWith(player) == 1) {
//				System.out.println("Staytop");
				player.getRect().setLocation(100, setFloor(ob) - 50);
			}
			else if (ob.collidesWith(player) == -1) {
				System.out.println("I died");
			}
		}
	}
	
}
