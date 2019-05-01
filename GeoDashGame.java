import java.awt.Graphics;
import java.util.ArrayList;

public class GeoDashGame {
	
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	private Dasher player;
	
	public GeoDashGame() {
		player = new Dasher();
	}
	

	public void draw(Graphics g) {
		player.draw(g);
		for(Obstacle ob: obstacles) {
			ob.draw(g);
		}
	}
	
	public void move() {
		player.move(-10);
		for(Obstacle ob: obstacles) {
			ob.move();
		}
	}

	
	
	
}
