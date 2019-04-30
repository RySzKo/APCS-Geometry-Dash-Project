import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GeoRunner {
	private JPanel panel;
	private GeoDashGame game = new GeoDashGame();
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	private static final int REFRESH_RATE = 10;

	public GeoRunner(){
		
		
	}
}
