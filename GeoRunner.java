import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

//UPDATE BY MIKE - NEW LINE & CHANGE OF HEIGHT
public class GeoRunner {
	private JPanel panel;
	private GeoDashGame game = new GeoDashGame();
	private Timer timer;
	private int ticks;
	private static final int REFRESH_RATE = 10;
	

	public static void main(String[] args) {
		new GeoRunner().start();

	}

	private void start() {
		JFrame frame = new JFrame("Geometry Dash");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawGame(g);
			}

		};

		panel.setBackground(Color.BLUE);
		panel.setPreferredSize(new Dimension(800, 600));

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

		panel.requestFocusInWindow();
		
		
		
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
				panel.repaint();
				
			}
		});
		timer.start();
	}

	
protected void updateGame() {
	ticks++;// keeps track of the number of times the timer has gone off
	game.moveObjects();
	int hurts = 1000/REFRESH_RATE;
	if(ticks %hurts == 0) {
		//System.out.println(ticks/hurts+" seconds");
	}
}

private void mapKeyStrokesToActions(JPanel panel) {

	
	ActionMap map = panel.getActionMap();
	InputMap inMap = panel.getInputMap();

	
	inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
	inMap.put(KeyStroke.getKeyStroke("pressed W"), "up");
	System.out.println("i hit up");
	
	map.put("up", new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			hit("up");
			game.player.moveUp();
		}


		
	});
	panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
	panel.getActionMap().put("left",new AbstractAction(){

		@Override
		public void actionPerformed(ActionEvent e) {
			hit("left");
			game.player.moveLeft();

		}
	});
	
	panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
	panel.getActionMap().put("right",new AbstractAction(){

		@Override
		public void actionPerformed(ActionEvent e) {
			hit("right");
			game.player.moveRight();
		}
	});
	
	panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
	panel.getActionMap().put("down",new AbstractAction(){

		@Override
		public void actionPerformed(ActionEvent e) {
			hit("down");
			game.player.moveDown();
		}
	});

}

public void hit(String str) {
	game.keyHit(str);
	panel.repaint();	
}

	protected void drawGame(Graphics g) {
		g.drawLine(0, 500, 2000, 500);

		game.draw(g);
	}
}