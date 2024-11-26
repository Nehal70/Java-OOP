/**
 * A node that stores data in a linked list.
 *
 * @param <T> type of data stored
 * @author Nehal Singhal
 * @version 1.0
 */
public class Node<T> {
    private T data;
    private Node<T> next;


    /**
     * Constructor.
     *
     * @param data data
     * @param next node
     */
    public Node(T data, Node<T> next) {
        this.setData(data);
        this.setNext(next);
    }
    /**
     * Constructor with one parameter.
     *
     * @param data the data of the node
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Returns the data of the node.
     *
     * @return T data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data of the node.
     *
     * @param data the new data for the node
     */
    public void setData(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data can't be null.");
        }
        this.data = data;
    }

    /**
     * Returns the next node.
     *
     * @return Node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the next node.
     *
     * @param next the new next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}

