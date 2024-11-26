/**
 * This class creates a witch object.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Witch extends TrickOrTreater implements Robbable {

    private String signatureCackle;

    /**
     * Initialises a witch object.
     *
     * @param name name of the witch
     * @param age age of the witch
     * @param numCandy number of Candy
     * @param signatureCackle the cackle of the witch
     */
    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        this.signatureCackle = (signatureCackle == null || signatureCackle.isEmpty()) ? "Bwahaha" : signatureCackle;
    }

    /**
     * Initialises a witch object using default values.
     *
     */
    public Witch() {
        this("Maleficent", 7, 0, "Bwahaha");
    }

    /**
     * Method to perform a trickorTreat task using signature cackle.
     *
     */
    @Override
    public void trickOrTreat() {
        System.out.printf("%s! I'll get you my pretty!%n", signatureCackle);
        gainCandy(3);
    }

    /**
     * Method through which witch loses candy.
     *
     */
    @Override
    public int beRobbed() {
        int candyToLose = 6 < getNumCandy() ? 6 : getNumCandy();
        loseCandy(candyToLose);
        return candyToLose;
    }

    /**
     * Overrides the compareTo method of trickortreater class.
     *
     * @param other trickortreater being compared to
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        int result = super.compareTo(other);
        if (result == 0 && other instanceof Witch) {
            return Integer.compare(this.signatureCackle.length(), ((Witch) other).signatureCackle.length());
        }
        return result;
    }
}
