package textviewer;

import java.awt.Color;
import java.awt.Font;

/**
 * class DataStore
 * 
 * @author CS 442 / CS 542
 *
 */
public class DataStore {
	private static DataStore singleton = new DataStore();
	private DataStore(){}
	private Color backgroundColor = Color.WHITE;
	private Color textColor = Color.BLUE;
	private Font font = new Font("SansSerif", Font.BOLD, 24);
	public static DataStore getHandle(){
		return singleton;
	}
	public Color getBackgroundColor() {
		return backgroundColor;	
	}
	public Color getTextColor() {
		return textColor;	
	}
	public void setBackgroundColor(Color color) {
		backgroundColor = color;
	}
	public void setTextColor(Color color) {
		textColor = color;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public void setFontSize(int n) {
		font = new Font("SansSerif", Font.BOLD, n); 
	}
}
