package textviewer;
/**
 * @author CS 442 / CS 542
 */
public class LazyModifier implements Modifier {
	private static Modifier singleton; // singleton pattern
	private LazyModifier(){}
	public Block[][] modify(Block[][] blocks, int width) {
		return blocks;
	}
	public static Modifier createModifier() {
		if (singleton == null) 
			synchronized(LazyModifier.class) {
				if (singleton == null)
				singleton = new LazyModifier();
			}
		return singleton;
	}
}
