package textviewer;
/**
 * class BlockDecomposer
 * 
 * @author CS 442 / CS 542
 *
 */
import java.awt.FontMetrics;
//import java.awt.Font;
//import java.awt.Toolkit;
import java.util.ArrayList;

public class BlockDecomposer {
	/**
	 * Uses split("[ \n\t]") to break up the String.
	 * A Block instance is made for each token and each separator. 
	 * 
	 * @param s String to be decomposed
	 * @param fm the FontMetric used as a Block parameter
	 * @return an array of Blocks containing words and spaces 
	 */
	public static Block [] decompose(String s, FontMetrics fm) {
		String[] strings = s.split("[ \n\t]");
		Block[] block = new Block[2*strings.length - 1];
		for(int i = 0; i < strings.length; i++) {
			block[2*i] = new Block(fm,strings[i]);
			if (i > 0) block[2*i - 1] = new Block(fm, " ");
		}
		return block;
	}

	/** 
	 * fragment will return an array of blocks that each contain one letter
	 * or one space
	 * 
	 * @param inBlocks array of Blocks to be decomposed
	 * @param fm the FontMetric used as a Block parameter
	 * @return an array of Blocks containing individual letters and spaces 
	 */
	public static Block [] fragment(Block [] inBlocks, FontMetrics fm) {
		ArrayList<Block> blocks = new ArrayList<>();
		for (int i = 0; i < inBlocks.length; i++) {
			String s = inBlocks[i].getText();
			for (char ch : s.toCharArray()) {
				blocks.add(new Block(fm, "" + ch));            
			}
		}	
		Block[] block = {};
		block = blocks.toArray(block);
		return block;
	}
}
