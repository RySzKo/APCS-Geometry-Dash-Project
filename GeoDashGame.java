import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GeoDashGame {
	
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	private ArrayList<Obstacle> triangles = new ArrayList<>();
	private ArrayList<Obstacle> blocks = new ArrayList<>();

	
	private Dasher player;
	
	Triangle triangle;
	Block block;
	
	public GeoDashGame() {
		player = new Dasher();
		//Devang: created and added obstacles
		triangle = new Triangle(10, null);
		obstacles.add(triangle);
		
		block = new Block(10, null);
		obstacles.add(block);
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