import java.awt.Image;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block extends Obstacle {
	// UPDATE BY MIKE
	private int dx, dy, xloc, yloc;
	private Rectangle hit;
	//UPDATE BY DEVANG
		public Block(int xspeed, Image i) {
		super(xspeed, "block.png");
	}

}
