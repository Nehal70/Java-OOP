/**
 * This Class represents an Out Of Stock Exception for the vending machine.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class OutOfStockException extends Exception {

    /**
     * Message constructor for the Out Of Stock Constructor.
     *
     * @param item String appended onto the exception's message.
     */
    public OutOfStockException(String item) {
        super(item + " is not in stock.");
    }
}
