/**
 * This interface  is a functional interface that applies to trick or treaters that can be robbed.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
@FunctionalInterface
public interface Robbable {
    /**
     * Declares a beRobbed method to be implemented by other classes.
     *
     * @return int
     */
    int beRobbed();
}