import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator for LinkedList that implements Iterator.
 *
 * @param <T> type of data being iterated
 * @author Nehal Singhal
 * @version 1.0
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> next;

    /**
     * Creates a new LinkedListIterator.
     * @param list the list to iterate over
     * @throws IllegalArgumentException if list is null
     */
    public LinkedListIterator(LinkedList<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        this.next = list.getHead();
    }

    /**
     * Checks if there are more elements in the list.
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    /**
     * Returns the next element and advances the iterator.
     * @return T
     * @throws NoSuchElementException if no more elements
     */
    @Override
    public T next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        T data = next.getData();
        next = next.getNext();
        return data;
    }
}
