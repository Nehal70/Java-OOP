import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic implementation of a singly linked list.
 *
 * @param <T> the type of elements in this list
 * @author Nehal Singhal
 * @version 1.0
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    /**
     * Creates an empty linked list.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Creates a linked list containing the elements from the given array.
     *
     * @param data the array of elements to add to the list
     * @throws IllegalArgumentException if data is null or contains null elements
     */
    public LinkedList(T[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Data array cannot be null");
        }
        for (T element : data) {
            if (element == null) {
                throw new IllegalArgumentException("Array cannot contain null elements");
            }
            add(element);
        }
    }

    /**
     * Gets the head node of this list.
     *
     * @return Node
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Converts the list to an array.
     *
     * @return T[]
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Iterator<T> iterator = iterator();
        int index = 0;
        while (iterator.hasNext()) {
            array[index++] = iterator.next();
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINKEDLIST %d =====\nisEmpty: %s\nsize: %d\nhead: %s\ndata: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (head == null ? "null" : head.getData())));

        T[] data = toArray();
        if (data == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < data.length - 1; ++i) {
                sb.append(String.format("%s, ", data[i])); // append all but last value
            }
            if (data.length > 0) {
                sb.append(String.format("%s", data[data.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        this.add(this.size(), element);
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        return this.remove(0);
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        T removed;
        if (index == 0) {
            removed = head.getData();
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removed = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removed;
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("Element not found in list");
        }
        if (head.getData().equals(element)) {
            T removed = head.getData();
            head = head.getNext();
            size--;
            return removed;
        }

        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(element)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            throw new NoSuchElementException("Element not found in list");
        }

        T removed = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        size--;
        return removed;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        T temp = current.getData();
        current.setData(element);
        return temp;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        int i = 0;
        Iterator<T> iterator = iterator();
        T current = iterator.next();
        while (i < index && iterator.hasNext()) {
            current = iterator.next();
            i++;
        }
        return current;
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }

        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }
}
