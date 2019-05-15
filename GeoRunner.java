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
	private int ticks, seconds, tempsecs;
	private double gravity;
	private boolean jumping;
	private int time;


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
			
			public void mouseReleased(MouseEvent me) {
				jumping = false;
			}
		});

	}


	protected void updateGame() {
		game.move();
		ticks++;
		int hurts = 1000/REFRESH_RATE;
		seconds = (int)ticks/hurts;
		time = ticks/10;
		if(jumping || game.getPlayer().getRect().getY() < 450) {
			gravity = (-9*(time - tempsecs)) + 3 * (time - tempsecs) * (time - tempsecs);
//			System.out.println(gravity);
			game.movePlayer(gravity);
			if(game.getPlayer().getRect().getY() >= 450) {
				game.getPlayer().getRect().setBounds((int) game.getPlayer().getRect().getX(), 450, 50, 50);
				if(jumping) {
					tempsecs = time;
				}
			}
		}
		if(ticks % hurts == 0) {
			System.out.println(seconds+" seconds");
			System.out.println("diff is " + (ticks - tempsecs));
		}
	}


	protected void clickedAt(MouseEvent me) {
		tempsecs = time;
		jumping = true;
		System.out.println("Click Works");
	}

	protected void drawGame(Graphics g) {
		g.drawLine(0, 500, 2000, 500);
		game.draw(g);
	}
}