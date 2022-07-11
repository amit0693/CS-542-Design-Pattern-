package albumiterator;

import java.util.Iterator;

public class ArrayAlbum extends AlbumComponent {
    
	private final int MAX_ITEMS;
	private int numberOfItems = 0;
	private AlbumComponent[] albumComponents;

	private Iterator<AlbumComponent> iterator = null;
	private String header;

	   public ArrayAlbum(int max, String header) {
        MAX_ITEMS = max;
        albumComponents = new AlbumComponent[MAX_ITEMS];
        this.header = header;
    }

    public void add(AlbumComponent menuComponent) {
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, the album is full!");
        } else {
            albumComponents[numberOfItems] = menuComponent;
            numberOfItems = numberOfItems + 1;
        }
    }

    public AlbumComponent getChild(int i) {
        return albumComponents[i];
    }

    public String getHeader() {
        return header;
    }
    
    public Iterator<AlbumComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(new ArrayAlbumIterator(albumComponents));
        }
        return iterator;
    }

    @Override
    public void clearIterator() {
        iterator = null;
        for (var ac : albumComponents) {
            if (ac != null) {
                ac.clearIterator();
            }
        }
    }

    public String toString() {
        return "\n" + this.getHeader() + "\n" + "-----------------------";
    }

    @Override
    public void accept(Visitor t) {
        t.visit(this);
    }
}
