/**
 * Class for a Ghost trickortreater.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Ghost extends TrickOrTreater {

    private int robberiesConducted;

    /**
     * Initialises a ghost object taking in name, age, numcandy variables.
     *
     * @param name name of ghost
     * @param age age of ghost
     * @param numCandy number of candy
     */
    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = 0;
    }

    /**
     * Initialises a ghost object without parameters.
     *
     */
    public Ghost() {
        this("Casper the Unfriendly Ghost", 12, 0);
    }

    /**
     * Carries out a trickortreat task implemented from superclass.
     *
     */
    @Override
    public void trickOrTreat() {
        gainCandy(2);
        System.out.println("BOO! Trick or treat!");
    }

    /**
     * robs a trickortreater.
     *
     * @param victim the trickortreater being robbed
     */
    public void rob(TrickOrTreater victim) {
        if (victim instanceof Robbable) {
            Robbable robbableVictim = (Robbable) victim;
            int candyLostDuringRobbery = robbableVictim.beRobbed();
            if (candyLostDuringRobbery > 0) {
                gainCandy(candyLostDuringRobbery);
                this.robberiesConducted++;
            }
        }
    }

    /**
     * Overrides the toString method.
     *
     * @return String
     */
    public String toString() {
        return String.format("%s/%d", super.toString(), this.robberiesConducted);
    }

    @Override
    public int compareTo(TrickOrTreater other) {
        int initialResult = super.compareTo(other);
        if (initialResult == 0 && other instanceof Ghost) {
            Ghost ghost = (Ghost) other;
            if (this.robberiesConducted > ghost.robberiesConducted) {
                return 1;
            } else if (this.robberiesConducted < ghost.robberiesConducted) {
                return -1;
            } else {
                return 0;
            }
        }
        return initialResult;
    }
}

