/**
 * Exception thrown when an invalid ticket is encountered.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class InvalidTicketException extends Exception {

    /**
     * Constructs a new InvalidTicketException.
     *
     * @param message the message
     */
    public InvalidTicketException(String message) {
        super(message);
    }

    /**
     * Constructs a new default InvalidTicketException.
     */
    public InvalidTicketException() {
        super("Invalid ticket");
    }
}