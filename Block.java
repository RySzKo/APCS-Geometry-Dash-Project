import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block extends Obstacle {
	
	private Point trc, tlc, brc, blc;
	private final int dim = 50;
	
		public Block(int x, int y, int xspeed) {
		super(x, y, xspeed);
		tlc = new Point(x, y);
		trc = new Point(x + dim, y);
		blc = new Point(x, y + dim);
		brc = new Point(x + dim, y + dim);
	}
		
		public boolean isRightBelow(Dasher d) {
			if(super.getY() <= d.getRect().getY() + 50) {
				d.getRect().setLocation((int) d.getRect().getX(), super.getY() - 50);
				if(brc.x >= d.tlc.x) {
					
				}
			}
			return false;
			
		}
}
