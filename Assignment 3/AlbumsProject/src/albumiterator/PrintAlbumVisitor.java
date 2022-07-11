package albumiterator;

public class PrintAlbumVisitor implements Visitor {
    
        @Override
	public void visit(ArrayAlbum a) {
		System.out.println(a);
	}
        
	public void visit(ListAlbum la) {
		System.out.println(la);
	}
        
	public void visit(AlbumItem ai) {
		System.out.println(ai);
	}
}
