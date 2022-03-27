package textviewer;
/**
 * @author CS 442 / CS 542
 */
public class RightModifier implements Modifier {
	private static Modifier singleton; // singleton pattern
	private RightModifier(){}
	public Block[][] modify(Block[][] blocks, int width) {
		int i = 0;
		int[] rowLengths = new int[blocks.length];
		for (i = 0; i < blocks.length; i++) {
			rowLengths[i] = 0;
			int len = blocks[i].length;
			for (int j = 0; j < len; j++) {
				rowLengths[i] += blocks[i][j].getWidth();
			}
			Block[] newRow = new Block[len + 1];
			System.arraycopy(blocks[i],0,newRow,1,len);
			newRow[0] = new Block(newRow[1].getFontMetrics(),"");
			blocks[i] = newRow;
		}
		for (i = 0; i < blocks.length; i++) {
			blocks[i][0].setWidth(width - rowLengths[i]);
		}
		return blocks;
	}
	public static Modifier createModifier() {
		if (singleton == null) 
			synchronized(LazyModifier.class) {
				if (singleton == null)
				singleton = new RightModifier();
			}
		return singleton;
	}
}
