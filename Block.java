import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block extends Obstacle {
	private int dx, dy, xloc, yloc;
	private Rectangle hit;

	public Block(int xspeed) {
		super(xspeed);
	}

}
