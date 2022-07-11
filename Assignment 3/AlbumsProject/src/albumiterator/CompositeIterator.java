package albumiterator;

import java.util.*;
  
public class CompositeIterator implements Iterator<AlbumComponent> {
    Stack<Iterator<AlbumComponent>> stack = new Stack<Iterator<AlbumComponent>>();

    public CompositeIterator(Iterator<AlbumComponent> iterator) {
        stack.push(iterator);
    }

    public AlbumComponent next() {
        if (hasNext()) {
            Iterator<AlbumComponent> iterator = stack.peek();
            AlbumComponent component = iterator.next();
            stack.push(component.createIterator());
            return component;
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<AlbumComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }
}


