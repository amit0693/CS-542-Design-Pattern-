package albumiterator;

import java.util.Iterator;

public class Operator {

    AlbumComponent albums;

    public Operator(AlbumComponent albums) {
        this.albums = albums;
    }

    public void printAlbums() {
        albums.clearIterator();
        Iterator<AlbumComponent> iterator = albums.createIterator();
        
        while (iterator.hasNext()) { System.out.println(iterator.next()); }
    }

    public void printAlbumsByYear(String year){
        albums.clearIterator();
        Iterator<AlbumComponent> it = albums.createIterator();
        
        int c = 0; // Items counter
        
        while(it.hasNext()){
            
            AlbumComponent ac = it.next();
            
            if( ac instanceof AlbumItem && ac.containsYear(year) ){
                System.out.println(ac);
                c++;
            }
            
        }
        
        if (c == 0) {
            System.err.println("\n[!] There are no albums of this year");
            Test.sleep();
        }
    }
    
    public void printAlbumsByWord(String word){
        albums.clearIterator();
        Iterator<AlbumComponent> it = albums.createIterator();
        
        int c = 0; // Item counter
        
        while(it.hasNext()){
            
            AlbumComponent ac = it.next();
            
            if( ac instanceof AlbumItem && ac.containsWord(word) ){
                System.out.println(ac);
                c++;
            }
            
        }
        
        if (c == 0) {
            System.err.println("\n[!] There are no photos that contain \'" + word + "'");
            Test.sleep();
        }
    }
}
