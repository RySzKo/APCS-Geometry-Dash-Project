import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class GeoRunner {
	private static final int REFRESH_RATE = 15;
	private JPanel panel;
	private GeoDashGame game = null;
	private Timer timer;
	private int ticks, seconds, tempsecs, floor, jumping;
	private double gravity;
	// private boolean jumping;
	private int time;
	private String dist;
	public String getDist() {
		return dist;
	}

	JFrame ownframe = null;
	JFrame fatherFrame = null;

	public JFrame getOwnFrame() {
		return ownframe;
	}

	public GeoRunner(JFrame fatherFrame) {
		this.fatherFrame = fatherFrame;
	}

	public static void main(String[] args) {
		SplashScreen screen = new SplashScreen();
		screen.createWindow();
		GeoRunner runner = new GeoRunner(screen.getFrame());
		runner.start();
	}

	void start() {
		game = new GeoDashGame(this);
		floor = game.resetFloor();
		dist = "";
		ownframe = new JFrame("Geometry Dash");
		ownframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initPanel();
		ownframe.add(panel);
		ownframe.pack();
		ownframe.setVisible(true);
		this.fatherFrame.dispose();

	}

	private void initPanel() {
		panel = new JPanel() {
			@Override

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawGame(g);
				panel.repaint();
			}

		};

		panel.setPreferredSize(new Dimension(800, 600));
	panel.setBackground(Color.YELLOW);
		panel.setFocusable(true);
		
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
				// System.out.println("Mouse Event : " + me.getButton());
				clickedAt(me);
				panel.repaint();
			}

			public void mouseReleased(MouseEvent me) {
				jumping = 0;
			}
		});

		panel.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 38) {
					clickedAt(e);
					panel.repaint();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 38) {
					jumping = 0;
				}

			}

		});
	}

	protected void updateGame() {
		game.move();
		ticks++;
		int hurts = 1000 / REFRESH_RATE;
		seconds = (int) ticks / hurts;
		time = ticks / 10;
		dist = "" + ticks;
		floor = game.getFloor();
		if (jumping == 1 || game.getPlayer().getRect().getY() < floor) {
			gravity = (-9 * (time - tempsecs)) + 2.5 * (time - tempsecs) * (time - tempsecs);
			// System.out.println(gravity);
			game.movePlayer(gravity);
			// System.out.println(jumping);
			if (game.getPlayer().getRect().getY() >= floor) {
				game.getPlayer().getRect().setBounds((int) game.getPlayer().getRect().getX(), floor, 50, 50);
				if (jumping == 1) {
					tempsecs = time;
				}
			}
		}
		checkCollisions();
		if (ticks % hurts == 0) {
			// System.out.println(seconds + " seconds");
			// System.out.println("diff is " + (ticks - tempsecs));
		}
	}

	private void checkCollisions() {
		game.checkCollisions();
	}

	protected void clickedAt(InputEvent me) {
		if (game.getPlayer().getRect().getY() == floor) {
			tempsecs = time;
		}
		jumping++;
		System.out.println("Click Works");
	}

	protected void drawGame(Graphics g) {
		g.drawLine(0, 500, 2000, 500);
		g.drawString(dist, 650, 20);
		game.draw(g);
	}
}
