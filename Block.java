import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Block implements Obstacle {
	
	private final int dim = 50;
	private final Rectangle hitbox;
	private int speed;
	
		public Block(int x, int y, int xspeed) {
		hitbox = new Rectangle(x, y, dim, dim);
		speed = xspeed;
		}

		
		public int collidesWith(Dasher d) {
			
			Rectangle intersection = hitbox.intersection(d.getRect());
			if (intersection.width > intersection.height) {
				return 1;
			}
			 if (intersection.width > 0 && intersection.height >= intersection.width) {
//				System.out.println(super.getRect().intersection(d.getRect()).toString());
				return 0;
			}
			return -1;
		}


		@Override
		public void move(int speed) {
			// TODO Auto-generated method stub
			hitbox.translate(speed, 0);
		}
		

		@Override
		public double getDim() {
			// TODO Auto-generated method stub
			return dim;
		}


		@Override
		public int getX() {
			// TODO Auto-generated method stub
			return hitbox.x;
		}


		@Override
		public int getY() {
			// TODO Auto-generated method stub
			return hitbox.y;
		}


		@Override
		public void draw(Graphics g) {
			// TODO Auto-generated method stub
			g.drawRect(getX(), getY(), dim, dim);
			g.fillRect(getX(), getY(), dim, dim);
		}


		public Rectangle getRect() {
			// TODO Auto-generated method stub
			return hitbox;
		}


		@Override
		public double getWidth() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public double getHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
		
}

