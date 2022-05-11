package albumiterator;

import java.util.Iterator;

public class AlbumItem extends AlbumComponent {

    private String date;
    private String description;

    public AlbumItem(String date, String description){
        this.date = date;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
    
    public boolean containsYear(String year){
        return this.date.contains(year);
    }
    
    public boolean containsWord(String word){
        return this.description.contains(word);
    }

    public Iterator<AlbumComponent> createIterator() {
        return new NullIterator();
    }

    public String toString() {
        return "\n    > " + getDate() + " - " + getDescription();
    }

}
