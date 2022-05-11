package albumiterator;

import java.util.Iterator;

public class ArrayAlbumIterator implements Iterator<AlbumComponent> {

    AlbumComponent[] items;
    int position = 0;

    public ArrayAlbumIterator(AlbumComponent[] itemsIn) {
        items = itemsIn;
    }

    public AlbumComponent next() {
        return items[position++];
    }

    public boolean hasNext() {
        return items.length > position && items[position] != null;
    }
}
