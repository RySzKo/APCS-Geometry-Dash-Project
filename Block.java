import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block extends Obstacle {

	Block b;
	// NEXT FOUR LINES WILL BE DELETED EVENTUALLY
	int xval = 10;
	int yval = 450;
	int bx = 10;
	int by = 10;

	public void draw(Graphics g) {
		g.drawRect(xval, yval, bx, by);
	}

	// UPDATE BY MIKE
	private int dx, dy, xloc, yloc;
	private Rectangle hit;

	// Devang: Updated image
	public Block(int xSpeed, Image i) {
		super(xSpeed, "block.png");
		image = getImage("block.png");
	}
}
