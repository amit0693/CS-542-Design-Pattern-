package textviewer;
/**
 * @author CS 442 / CS 542
 */
public class FullModifier implements Modifier {
	private int rowLength(Block[] row) {
		int rowLength = 0;
		for(Block b : row) rowLength += b.getWidth();
		return rowLength;
	}
	private static Modifier singleton; // singleton pattern
	private FullModifier(){}
	public Block[][] modify(Block[][] blocks, int width) {
		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = BlockDecomposer.fragment(blocks[i], blocks[0][0].getFontMetrics());
		}
		for (int i = 0; i < blocks.length - 1; i++) {
			int numPoints = width - rowLength(blocks[i]);
			int count = 1;
			while(numPoints > 0) {
				for(int j = 0; j < blocks[i].length; j += 2) {
					if(count % 3 != 0 && blocks[i][j].isWhiteSpace() && numPoints > 0) {
						blocks[i][j].setWidth(blocks[i][j].getWidth() + 1);
						numPoints--;
					}
				}
				for(int j = 1; j < blocks[i].length; j += 2) {
					if(count % 3 != 0 && blocks[i][j].isWhiteSpace() && numPoints > 0) {
						blocks[i][j].setWidth(blocks[i][j].getWidth() + 1);
						numPoints--;
					}
				}
				for(int j = 0; j < blocks[i].length; j ++) {
					if(numPoints > 0) {
						blocks[i][j].setWidth(blocks[i][j].getWidth() + 1);
						numPoints--;
					}	
				}
				count++;
			}
		}
		return blocks;
	}
	public static Modifier createModifier() {
		if (singleton == null) 
			synchronized(LazyModifier.class) {
				if (singleton == null)
				singleton = new FullModifier();
			}
		return singleton;
	}
}
