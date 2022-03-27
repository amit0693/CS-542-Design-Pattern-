package textviewer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * class DisplayPanel
 * 
 * @author CS 442 / CS 542
 *
 */
public class DisplayPanel extends JPanel {
	private static final long serialVersionUID = -7546375077499829196L;
	private Block[][] blocks = new Block[0][0];
	public void setContent(Block[][] b) {
		blocks = b;
	}
	public int getDisplayPanelWidth () {
		return this.getWidth();
	}
	public void paintComponent(Graphics g) {
	   	super.paintComponent(g);
	   	Dimension d = getSize();
	   	g.setColor(DataStore.getHandle().getBackgroundColor());
	   	g.fillRect(0, 0, d.width, d.height);    
	   	Point p = new Point(0,0);
	   	int x = p.x;
	   	int y = p.y;
	   	for (int i = 0; i < blocks.length; i++) {
		  	Block[] b = blocks[i];
			y += b[0].getAscent() + b[0].getDescent() + b[0].getLeading();
		  	for (int j = 0; j < b.length; j++) {
			 	g.setColor(DataStore.getHandle().getTextColor());
			 	g.drawString(b[j].getText(),x,y);
				x += b[j].getWidth();
		  	}
		  	x = p.x;
	   	}
	}   
}
