package textviewer;
/**
 * @author CS 442 / CS 542
 */
import javax.swing.JPanel;
import java.util.ArrayList;

public class RawBlockLayout {
	/**
	 * Distributes as many blocks that fit on the screen. The first index is
	 * used for the rows of blocks. The second index runs though the blocks in
	 * any row. The method distributes the blocks that will fit on the screen
	 * and ignores the remaining blocks.
	 * NOTE that the location parameter is the left-hand end of the BASELINE
	 * of the text field of the first block. The baseline is the line,
	 * on which the letters sit: only the descenders (the tails) of the
	 * letters extend below this line.
	 */
	public Block[][] locateAll(Block[] blocks, JPanel panel) {
		ArrayList<Block[]> rows = new ArrayList<Block[]>();
		ArrayList<Block> row = new ArrayList<Block>();
		int widthLeft = panel.getSize().width;
		int index = 0;
		while (index < blocks.length) {
			while (index < blocks.length && widthLeft >= blocks[index].getWidth()) {
				row.add(blocks[index]);
				widthLeft -= blocks[index].getWidth();
				index++;
			}
			while (row.get(row.size() - 1).getText().equals(" ")) {
				row.remove(row.size() - 1);
			}
			while (((Block)row.get(0)).getText().equals(" ")) {
				row.remove(0);
			}
			Block[] obj2 = new Block[row.size()];
			row.toArray(obj2);
			rows.add(obj2);

			row.clear();
			widthLeft = panel.getSize().width;
		}
		Block[][] obj = new Block[rows.size()][];
		for (int i = 0; i < rows.size(); i++) {
			obj[i] = (Block[])rows.get(i);
		}
		return obj;
	}
}
