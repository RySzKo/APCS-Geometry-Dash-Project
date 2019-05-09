import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block extends Obstacle {
	// UPDATE BY MIKE
	private int dx, dy, xloc, yloc;
	private Rectangle hit;
	
	//Devang: Updated image
		public Block(int xSpeed, Image i) {
		super(xSpeed, "block.png");
		image = getImage("block.png");
		}
}

