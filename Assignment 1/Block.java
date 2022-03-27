package textviewer;
/**
 * @author CS 442 / CS 542
 */
import java.awt.FontMetrics;
/**
 * A Block class with all the properties of a character on the page
 */
public class Block {
	private FontMetrics fontMetrics;
	private int width;
	private int ascent;
	private int descent;
	private int leading;
	private String text;
	public Block (FontMetrics fm, String s) {
		fontMetrics = fm;
		width = fm.stringWidth(s);
		ascent = fm.getMaxAscent();
		descent = fm.getMaxDescent();
		leading = fm.getLeading();
		text = s;
	}
	public boolean isSpace () {
		return text.equals(" "); 
	}
	public boolean isTab () {
		return text.equals("\t"); 
	}
	public boolean isNewLine () {
		return text.equals("\n"); 
	}
	public boolean isWhiteSpace () {
		return (text.length() == 1 && Character.isWhitespace(text.charAt(0)));
	}
	public FontMetrics getFontMetrics() {
		return fontMetrics;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int w) {
		width = w;
	}
	public int getAscent() {
		return ascent;
	}
	public int getDescent() {
		return descent;
	}
	public int getLeading() {
		return leading;
	}
	public String getText() {
		return text;
	}
	public static int lineLength (Block[][] blocks, int i) {
	   int lineLength = 0;
	   for (int j = 0; j < blocks[i].length; j++) {
		  lineLength += blocks[i][j].getWidth();
	   }
	   return lineLength;
	}
}
