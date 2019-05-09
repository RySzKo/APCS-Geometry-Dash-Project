import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class GeoRunner {
	private static final int REFRESH_RATE = 10;
	private JPanel panel;
	private GeoDashGame game = new GeoDashGame();
	private Timer timer;
	private int ticks;

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
				panel.repaint();
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
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateGame();
				panel.repaint();
			}
			
		});
		timer.start();
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				clickedAt(me);
				panel.repaint();
			}
		});

	}


	protected void updateGame() {
		ticks++;
		game.move();
	}

	private void mapKeyStrokesToActions(JPanel panel) {

		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();

		
		inMap.put(KeyStroke.getKeyStroke("UP"), "up");
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
				game.player.moveDown(0);
			}
		});

	}

	protected void clickedAt(MouseEvent me) {
		game.movePlayer(-10);
		System.out.println("Click Works");
	}

	public  void hit(String s) {
		game.keyHit(s);
		panel.repaint();
	}

	protected void drawGame(Graphics g) {
		g.drawLine(0, 500, 2000, 500);
		
		game.draw(g);
	}
}