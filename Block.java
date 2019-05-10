import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block extends Obstacle {
	// UPDATE BY MIKE
	private Rectangle hit;
		public Block(int x, int y, int xspeed) {
		super(x, y, xspeed);
		hit = super.getRect();
	}
		
}
