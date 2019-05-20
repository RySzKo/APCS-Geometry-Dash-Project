import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block extends Obstacle {
	
	private final int dim = 50;
	
		public Block(int x, int y, int xspeed) {
		super(x, y, xspeed);
		}
		
		@Override
		/** If returns 0, dasher dies.
		 *  If returns 1, dasher lives and sets floor to block top.
		 *  If returns -1, dasher is not colliding with the block.
		 */ 
		public int collidesWith(Dasher d) {
//			double dashleft = d.getRect().getX(),
//					dashright = d.getRect().getMaxX(),
//					dashtop = d.getRect().getY(),
//					dashbot = d.getRect().getMaxY();
//			double blocktop = super.getY(),
//					blockbot = super.getRect().getMaxY(),
//					blockleft = super.getX(),
//					blockright = super.getRect().getMaxX();
//			if(dashright >= blockleft && dashleft <= blockleft) {
//				if(dashbot <= blocktop) {
//					return 1;
//				}
//				else {
//					return 0;
//				}
//			}
//			if(dashleft <= blockright && dashright >= blockright) {
//				if(dashbot < blocktop) {
//					return 1;
//				}
//				else {
//					return 0;
//				}
//			}
			Rectangle intersection = super.getRect().intersection(d.getRect());
			if (intersection.width > intersection.height) {
				return 1;
			}
			if (intersection.height >= intersection.width) {
				return 0;
			}
			return -1;
		}
		
}
