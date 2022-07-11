package albumiterator;

import java.util.Iterator;

public class Operator {

    AlbumComponent albums;

    public Operator(AlbumComponent albums) {
        this.albums = albums;
    }

    public void processVisitor(Visitor vis) {
        albums.clearIterator();
        Iterator<AlbumComponent> iterator = albums.createIterator();
        while (iterator.hasNext()) {
            AlbumComponent ac = iterator.next();
            ac.accept(vis);
        }
    }
    
    public void processVisitorByYear(Visitor vis, String year){
        albums.clearIterator();
        Iterator<AlbumComponent> iterator = albums.createIterator();
        
        int c = 0; // Items counter
        
        while (iterator.hasNext()) {
            AlbumComponent ac = iterator.next();
            
            if( ac instanceof AlbumItem && ac.containsYear(year) ){
                ac.accept(vis);
                c++;
            }
        }
        
        if (c == 0) {
            System.err.println("\n[!] There are no albums of this year");
            Test.sleep();
        }
    }
    
    public void processVisitorByWord(Visitor vis, String word){
        albums.clearIterator();
        Iterator<AlbumComponent> iterator = albums.createIterator();
        
        int c = 0; // Items counter
        
        while (iterator.hasNext()) {
            AlbumComponent ac = iterator.next();
            
            if( ac instanceof AlbumItem && ac.containsWord(word) ){
                ac.accept(vis);
                c++;
            }
        }
        
        if (c == 0) {
            System.err.println("\n[!] There are no photos that contain \'" + word + "'");
            Test.sleep();
        }
    }

    public void printAlbums() {
        processVisitor(new PrintAlbumVisitor());
    }
    
    public void printAlbumsByYear(String year){
        processVisitorByYear(new PrintAlbumVisitor(), year);
    }
    
    public void printAlbumsByWord(String word){
        processVisitorByWord(new PrintAlbumVisitor(), word);
    }
}
