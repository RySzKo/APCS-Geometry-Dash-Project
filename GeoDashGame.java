import java.awt.Graphics;
import java.util.ArrayList;

public class GeoDashGame {
	
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	private Dasher player;
	private Obstacle ob1;
	
	public GeoDashGame() {
		player = new Dasher();
		ob1 = new Block(-10);
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

	public void movePlayer(int y) {
		player.move(y);
	}
	
	
}
