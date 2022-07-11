package albumiterator;

public interface Visitor {
    
	default void visit(ArrayAlbum a) {}
        
	default void visit(ListAlbum l) {}
        
	default void visit(AlbumItem i) {}
}
