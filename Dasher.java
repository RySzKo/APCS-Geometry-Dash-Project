import java.awt.Component;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;

public class Dasher {

	private boolean jumping;
	private Rectangle rect;
	private final int xval = 100, dasherdim = 50;
	private int yval, grav;
	public Point tlc, trc, blc, brc;

	public Dasher() {
		yval = 450;
		rect = new Rectangle(xval, yval, dasherdim, dasherdim);
//		timer = new Timer(10, new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				timeassist++;
//				jump();
//			}
//		});
//		timer.start();
		tlc = new Point(xval, yval);
		trc = new Point(xval + dasherdim, yval);
		blc = new Point(xval, yval + dasherdim);
		brc = new Point(xval + dasherdim, yval + dasherdim);
	}
	public void draw(Graphics g) {
		g.drawRect(rect.x, rect.y, dasherdim, dasherdim);
		g.fillRect(rect.x, rect.y, dasherdim, dasherdim);
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public void move(double gravity) {
		rect.translate(0, (int) gravity);
		System.out.println("Moved " + gravity);
	}

}