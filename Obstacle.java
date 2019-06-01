import java.awt.*;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public interface Obstacle {
	
	public int defaultDim = 50;
	/**
	 * Move left at speed speed.
	 */
	public void move(int speed);
		
	/**
	 * Return Width.
	 */
	public double getWidth();
	
	/**
	 * Return Height.
	 */
	public double getHeight();
	
	/**
	 * 
	 * @return X location of bounds box
	 */
	public int getX();
	
	/**
	 * 
	 * @return Y location of bounds box
	 */
	public int getY();
	
	/**
	 * draw.
	 * @param g
	 */
	public void draw(Graphics g);
	
	/** 
	 * If returns 0, dasher dies.
	 *  If returns 1, dasher lives and sets floor to block top.
	 *  If returns -1, dasher is not colliding with the block.
	 */ 
	public int collidesWith(Dasher d);

	double getDim();

}


