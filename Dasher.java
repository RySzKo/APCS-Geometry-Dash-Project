import java.awt.Component;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;

public class Dasher extends Component {

	private Rectangle rect;
	private final int xval = 100, dasherdim = 50;
	private int yval;

	public Dasher(ActionMap am) {
		super();
		yval = 450;
		rect = new Rectangle(xval, yval, dasherdim, dasherdim);
		System.out.println("dasher is made");
	}
	
	public void draw(Graphics g) {
		g.drawRect(rect.x, rect.y, dasherdim, dasherdim);
		g.fillRect(rect.x, rect.y, dasherdim, dasherdim);
	}
	
	
	
	public void move(int y) {
		rect.translate(0, y-50);
		System.out.println("Move Works");
		moveDown(y);
		//rect.translate(0, -(y-50));
		//Thread.sleep(1000);

		//rect.translate(0, -(y-50));
	}
	
	public void moveUp(){
	rect.translate(0,(int) (-rect.getWidth()));
	System.out.println("MoveUp Works");
}



public void moveDown(int y){
	

	//rect.translate(0, -(y-50));
	//rect.translate(0, (int) (rect.getWidth()+1));
	System.out.println("MoveDown Works");

	//rect.translate(0, -(y-50));
}

public void moveRight() {
	rect.translate((int) (rect.getHeight()+1), 0);
	System.out.println("MoveRight Works");
}

public void moveLeft() {
	rect.translate((int) (-rect.getHeight()), 0);
	System.out.println("MoveLeft Works");
}
}