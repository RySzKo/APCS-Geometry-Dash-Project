import java.awt.Graphics;
import java.util.ArrayList;

public class GeoDashGame {
	
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	Dasher player;
	Triangle triangle = new Triangle(0, null);
	Block block = new Block(0, null);
	public GeoDashGame() {
		player = new Dasher(null);
		block = new Block(-10, null);
		obstacles.add(block);
		triangle = new Triangle(-10, null);
		obstacles.add(triangle);
	}
	

	public void draw(Graphics g) {
		player.draw(g);
		for(Obstacle ob: obstacles) {
			ob.draw(g);
		}
	}
	
	public void move() {
		for(Obstacle ob: obstacles) {
			ob.moveObjects();
		}
	}

	public void movePlayer(int y)  {
		player.move(y);
		
	}


	public void keyHit(String s) {
System.out.println("key was hit");		
	}
	
	
}
