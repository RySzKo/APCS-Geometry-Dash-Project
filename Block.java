import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block extends Obstacle {

	Block b;
	// NEXT FOUR LINES WILL BE DELETED EVENTUALLY
	int xval = 500;
	int yval = 450;
	int bx = 50;
	int by = 50;

	public void draw(Graphics g) {
		g.drawRect(xval, yval, bx, by);
		g.fillRect(xval, yval, bx, by);

	}

	public Block(int xval, int yval, int bx, int by) {
		this.xval = xval;
		this.yval = yval;
		this.bx = bx;
		this.by = by;
	}
}
