import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestClass {

	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(900, 700));
		panel.setVisible(true);

		MyComponent myComp = new MyComponent();
//		myComp.setVisible(true);
		panel.add(myComp);

		JFrame frame = new JFrame("Test frame");
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.requestFocus();

		Graphics g = panel.getGraphics();
		if (g!=null) {
			panel.invalidate();
			g.drawRect(myComp.r.x, myComp.r.y, myComp.r.width, myComp.r.height);
			panel.revalidate();
//			myComp.draw(g);
		} else {
			System.out.println("graphics not available");
		}

		panel.revalidate();
		panel.paintAll(g);
		
//		Timer timer = new Timer(1000, new ActionListener() {
//			int counter = 1;
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(counter++ + " action ...");
////				myComp.shift();
//				panel.repaint();
//				Component c = panel.getComponent(0);
//				if (c != null) {
//					System.out.println("frame: "+ frame.isVisible() + ", panel:" + panel.isVisible() + ", compo:" + c.isVisible());
//				}
//			}
//		});
//		timer.setInitialDelay(5000);
//		timer.start();
	}
}


@SuppressWarnings("serial")
class MyComponent extends JComponent {
	Rectangle r = new Rectangle(600, 400, 50, 50);
	
	public void draw(Graphics g) {
		System.out.println("drawing rectangle");
		g.drawRect(r.x, r.y, r.width, r.height);
	}

//	public void shift() {
//		this.r.translate(r.x - 50, r.y);
////		r.setLocation(r.x + 50, r.y + 50);
//		this.repaint();
//	}
}