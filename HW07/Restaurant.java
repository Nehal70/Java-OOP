/**
 * This is a restaraunt class.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Restaurant {
    /**
     * to sort rolls using mergeSort.
     *
     * @param rolls SushiRoll being sorted
     * @return SushiRoll recursively
     */
    public static SushiRoll[] mergeSortRolls(SushiRoll[] rolls) {
        if (rolls.length <= 1) {
            return rolls;
        }
        int midIndex = rolls.length / 2;
        SushiRoll[] left = mergeSortRolls(RecursionUtils.copyOfRange(rolls, 0, midIndex));
        SushiRoll[] right = mergeSortRolls(RecursionUtils.copyOfRange(rolls, midIndex, rolls.length));
        return RecursionUtils.merge(left, right);
    }
    /**
     * Helper method for mergeOrders.
     *
     * @param rolls array to be sorted.
     * @param start index
     * @param end index
     * @return array
     */
    private static SushiRoll[] mergeOrdersHelper(SushiRoll[][] rolls, int start, int end) {
        if (start > end) {
            return new SushiRoll[0];
        }
        if (start == end) {
            return rolls[start];
        }
        int mid = (start + end) / 2;
        SushiRoll[] left = mergeOrdersHelper(rolls, start, mid);
        SushiRoll[] right = mergeOrdersHelper(rolls, mid + 1, end);
        return RecursionUtils.merge(left, right);
    }
    /**
     * The mergeOrders method.
     *
     * @param rolls the orders array to be merged
     * @return SushiRoll array
     */
    public static SushiRoll[] mergeOrders(SushiRoll[][] rolls) {
        return mergeOrdersHelper(rolls, 0, rolls.length - 1);
    }
    /**
     * Method getting count of color.
     *
     * @param rolls the array taken as input
     * @param color color being checked for
     * @return SushiRoll
     */
    public static SushiRoll[] platesOfColor(SushiRoll[] rolls, Color color) {
        int count = countColorMatches(rolls, color, 0);
        return platesOfColorHelper(rolls, color, 0, count, new SushiRoll[count]);
    }
    /**
     * Counting color matches.
     *
     * @param rolls SushiRoll being checked
     * @param color the color being matched
     * @param index index being checked
     * @return int
     */
    private static int countColorMatches(SushiRoll[] rolls, Color color, int index) {
        if (index == rolls.length) {
            return 0;
        }
        int count = rolls[index].getColor().equals(color) ? 1 : 0;
        return count + countColorMatches(rolls, color, index + 1);
    }
    /**
     * Helper method for platesofColor.
     *
     * @param rolls SushiRoll being checked
     * @param color color being checked
     * @param index index of roll
     * @param count count of color
     * @param result sushiroll resultant
     * @return SushiRoll array
     */
    private static SushiRoll[] platesOfColorHelper(SushiRoll[] rolls, Color color,
                                                    int index, int count, SushiRoll[] result) {
        if (index == rolls.length) {
            return result;
        }
        if (rolls[index].getColor().equals(color)) {
            result[result.length - count] = rolls[index];
            return platesOfColorHelper(rolls, color, index + 1, count - 1, result);
        }
        return platesOfColorHelper(rolls, color, index + 1, count, result);
    }
    /**
     * total Price method.
     *
     * @param rolls SushiRoll being calculated for
     * @return double
     */
    public static double totalPrice(SushiRoll[] rolls) {
        return totalPriceHelper(rolls, 0);
    }
    /**
     * helper method for price.
     *
     * @param rolls SushiRoll being checked for
     * @param index index being checked currently
     * @return double
     */
    private static double totalPriceHelper(SushiRoll[] rolls, int index) {
        if (index == rolls.length) {
            return 0.0;
        }
        return rolls[index].getColor().getPrice() + totalPriceHelper(rolls, index + 1);
    }
    /**
     * Helper method for flip method.
     *
     * @param rolls SushiRoll being flipped
     * @param left left index
     * @param right right index
     */
    private static void flipHelper(SushiRoll[] rolls, int left, int right) {
        if (left >= right) {
            return;
        }
        SushiRoll temp = rolls[left];
        rolls[left] = rolls[right];
        rolls[right] = temp;

        flipHelper(rolls, left + 1, right - 1);
    }
    /**
     * The Flip method.
     *
     * @param rolls SushiRoll being flipped
     */
    public static void flip(SushiRoll[] rolls) {
        flipHelper(rolls, 0, rolls.length - 1);
    }
}

