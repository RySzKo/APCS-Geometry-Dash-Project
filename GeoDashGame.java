import java.awt.Graphics;
import java.util.ArrayList;

public class GeoDashGame {
	
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	private Dasher player;
	private Obstacle ob1;
	private int floorY;
	
	public GeoDashGame() {
		player = new Dasher();
		Obstacle ob1 = new Block(450, 450, -3);
		obstacles.add(ob1);
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
//			System.out.println("Moved " + ob);
		}
	}

	public void movePlayer(double gravity) {
		player.move(gravity);
		
	}
	
	public int setFloor(Obstacle f) {
		return f.getY();
	}
	
	public int resetFloor() {
		return 450;
	}
	
	public Dasher getPlayer() {
		return player;
	}
	
}
