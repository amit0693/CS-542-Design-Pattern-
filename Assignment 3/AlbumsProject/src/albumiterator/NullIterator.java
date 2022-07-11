package albumiterator;
 
import java.util.Iterator;
  
public class NullIterator implements Iterator<AlbumComponent> {
   
    public AlbumComponent next() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

}
