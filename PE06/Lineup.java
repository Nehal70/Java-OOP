import java.util.ArrayList;
import java.util.Collections;

/**
 * A generic lineup class that can store comparable elements.
 *
 * @author Nehal Singhal
 * @version 1.0
 * @param <T> must extend comparable
 */
public class Lineup<T extends Comparable<T>> {

    private ArrayList<T> lineup;

    private boolean isAscending;

    /**
     * Constructor that initializes a lineup.
     *
     * @param first first element
     * @param second second element
     * @param third third element
     * @param fourth fourth element
     */
    public Lineup(T first, T second, T third, T fourth) {
        lineup = new ArrayList<>(4);
        if (first != null && second != null && third != null && fourth != null) {
            lineup.add(first);
            lineup.add(second);
            lineup.add(third);
            lineup.add(fourth);
        }
        isAscending = true;
    }

    /**
     * Creates a string representation of the lineup.
     *
     * @return string
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            if (i < lineup.size()) {
                result += lineup.get(i);
            } else {
                result += "null";
            }
            if (i < 3) {
                result += " -> ";
            }
        }
        return result;
    }

    /**
     * Adds an element to the lineup while maintaining sorting order.
     *
     * @param newElement element to add
     * @return boolean
     */
    public boolean add(T newElement) {
        if (lineup.size() >= 4 || newElement == null) {
            return false;
        }

        int position = 0;
        for (int i = 0; i < lineup.size(); i++) {
            int comparison = newElement.compareTo(lineup.get(i));
            if ((isAscending && comparison <= 0) || (!isAscending && comparison >= 0)) {
                break;
            }
            position++;
        }

        lineup.add(position, newElement);
        return true;
    }

    /**
     * Removes the first occurrence of the specified element.
     *
     * @param element element to remove
     * @return boolean
     */
    public boolean remove(T element) {
        return lineup.remove(element);
    }

    /**
     * Reverses the lineup.
     *
     */
    public void reverseLineup() {
        Collections.reverse(lineup);
        isAscending = !isAscending;
    }

    /**
     * Checks if the lineup contains the specified element.
     *
     * @param element the element to check
     * @return boolean
     */
    public boolean contains(T element) {
        return lineup.contains(element);
    }

    /**
     * Returns the number of elements in the lineup.
     *
     * @return int
     */
    public int size() {
        return lineup.size();
    }

    /**
     * Main method to demonstrate the Lineup class functionality.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Lineup<Integer> lineup1 = new Lineup<>(1, 2, 3, 4);
        Lineup<String> lineup2 = new Lineup<>("apple", "banana", "cherry", "date");

        System.out.println("Initial lineup1: " + lineup1);
        lineup1.remove(2);
        System.out.println("After removing 2: " + lineup1);
        lineup1.add(5);
        System.out.println("After adding 5: " + lineup1);
        lineup1.reverseLineup();
        System.out.println("After reversing: " + lineup1);
        System.out.println("Contains 3? " + lineup1.contains(3)); // Check contains
        System.out.println("Size of lineup1: " + lineup1.size()); // Check size

        System.out.println("Initial lineup2: " + lineup2);
        lineup2.remove("banana");
        System.out.println("After removing 'banana': " + lineup2);
        lineup2.add("fig");
        System.out.println("After adding 'fig': " + lineup2);
        lineup2.reverseLineup();
        System.out.println("After reversing: " + lineup2);
        System.out.println("Contains 'apple'? " + lineup2.contains("apple")); // Check contains
        System.out.println("Size of lineup2: " + lineup2.size()); // Check size
    }
}
