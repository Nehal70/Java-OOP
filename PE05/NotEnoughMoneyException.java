/**
 * This is the NotEnoughMoneyException for the Vending Machine.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class NotEnoughMoneyException extends RuntimeException {

    /**
     * Constructor for the exception class.
     *
     */
    public NotEnoughMoneyException() {
        super("Item not vended. Insufficient funds.");
    }
}
