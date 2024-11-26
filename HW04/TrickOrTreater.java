/**
 * abstract class that defines a trickortreater.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public abstract class TrickOrTreater implements Comparable<TrickOrTreater> {

    private String name;
    private int age;
    private int numCandy;

    /**
     * Constructs a trickortreater object.
     *
     * @param name name of trickOrTreater
     * @param age age of trickOrTreater
     * @param numCandy numCandy possessed by trickOrTreater
     */
    public TrickOrTreater(String name, int age, int numCandy) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Chowder";
        } else {
            this.name = name;
        }

        if (age < 0 || age > 12) {
            this.age = 8;
        } else {
            this.age = age;
        }

        if (numCandy < 0) {
            this.numCandy = 0;
        } else {
            this.numCandy = numCandy;
        }
    }

    /**
     * Abstract method to be implemented in subclasses defining a trickortreat task.
     *
     */
    public abstract void trickOrTreat();

    /**
     * Method through which a trickortreater gains candy.
     *
     * @param candyAmount amount to be gained
     */
    protected void gainCandy(int candyAmount) {
        if (candyAmount > 0) {
            this.numCandy += candyAmount;
        }
    }

    /**
     * Method through which a trickortreater loses candy.
     *
     * @param lostAmount the amount to be lost
     * @return int
     */
    protected int loseCandy(int lostAmount) {
        int lostCandy;
        if (lostAmount > 0) {
            if (this.numCandy < lostAmount) {
                lostCandy = this.numCandy;
                this.numCandy = 0;
            } else {
                lostCandy = lostAmount;
                this.numCandy -= lostCandy;
            }
        } else {
            lostCandy = 0;
        }
        return lostCandy;
    }

    /**
     * Returns the number of Candy instance method.
     *
     * @return int 'num candy' instance variable return
     */
    public int getNumCandy() {
        return this.numCandy;
    }

    /**
     * Overrides compareTo method.
     *
     * @param other TrickOrTreater object being compared.
     * @return int according to comparison
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        if (this.numCandy > other.numCandy) {
            return 1;
        } else if (this.numCandy < other.numCandy) {
            return -1;
        } else {
            if (this.age > other.age) {
                return 1;
            } else if (this.age < other.age) {
                return -1;
            } else {
                return 0; // They are equal
            }
        }
    }


    /**
     * Overrides the toString method.
     *
     */
    @Override
    public String toString() {
        return String.format("%s/%d/%d", this.name, this.age, this.numCandy);
    }
}
