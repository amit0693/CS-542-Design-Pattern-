package albumiterator;

import java.util.Iterator;
import java.util.function.Consumer;

public abstract class AlbumComponent implements Consumer<Visitor>{
    
    public void add(AlbumComponent albumComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(AlbumComponent albumComponent) {
        throw new UnsupportedOperationException();
    }

    public AlbumComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getHeader(){
        throw new UnsupportedOperationException();
    }
    
    public boolean containsYear(String year){
        throw new UnsupportedOperationException();
    }
    
    public boolean containsWord(String word){
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<AlbumComponent> createIterator();

    public void clearIterator(){}
    
}
