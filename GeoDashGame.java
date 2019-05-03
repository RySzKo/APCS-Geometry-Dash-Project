import java.awt.Graphics;
import java.util.ArrayList;

public class GeoDashGame {
	
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	Triangle triangle;
	
	
	private Dasher player;
	
	public GeoDashGame() {
		player = new Dasher();
		triangle = new Triangle(20, null);
		obstacles.add(triangle);
	}

	public void draw(Graphics g) {
		player.draw(g);

		for(Obstacle obs:obstacles) {
			obs.draw(g);
		}
	}

	
	
	
}
