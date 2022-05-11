package albumiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAlbum extends AlbumComponent{

    Iterator<AlbumComponent> iterator = null;
    List<AlbumComponent> albumComponents = new ArrayList<AlbumComponent>();
    String header;
    
    public ListAlbum(String header){
        this.header = header;
    }
    
    public void add(AlbumComponent menuComponent) {
        albumComponents.add(menuComponent);
    }

    public void remove(AlbumComponent menuComponent) {
        albumComponents.remove(menuComponent);
    }

    public AlbumComponent getChild(int i) {
        return albumComponents.get(i);
    }
    
    public String getHeader(){
        return header;
    }
    
    @Override
    public Iterator<AlbumComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(albumComponents.iterator());
	}
        
	return iterator;
    }
    
    @Override
    public void clearIterator(){
        iterator = null;
	for(var ac : albumComponents) ac.clearIterator();
    }
    
    @Override
    public String toString(){
        return "\n" + this.getHeader() + "\n" + "-----------------------";
    }
}
