/**
 * This creates a StripedBass subclass from a Fish type object.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class StripedBass extends Fish {
    private int stripeCount;
    private boolean isSaltwater;
    private Catfish bestFriend;

    /**
     * This is a constructor for a StripedBass object taking in all parameters.
     *
     * @param name name of the stripedFish variable
     * @param length langth of the stripedFish variable
     * @param weight weight of the stripedFish variable
     * @param stripeCount stripeCount of the stripedFish variable
     * @param isSaltwater isSaltwater of the stripedFish variable
     * @param bestFriend bestFriend of the stripedFish variable
     */
    public StripedBass(String name,
                    Double length,
                    Double weight,
                    int stripeCount,
                    boolean isSaltwater,
                    Catfish bestFriend) {
        super(name, length, weight);

        if (stripeCount <= 0) {
            this.stripeCount = 25;
        } else {
            this.stripeCount = stripeCount;
        }

        this.isSaltwater = isSaltwater;

        if (bestFriend != null) {
            this.bestFriend = new Catfish(bestFriend);
        } else {
            this.bestFriend = null;
        }
    }

    /**
     * This is the stripedBass constructor without any parameters.
     */
    public StripedBass() {
        this("Striper", 30.0, 320.0, 14, false, null);
    }

    /**
     * This StripedBass object deep copies properties from another object.
     *
     * @param other the object
     */
    public StripedBass(StripedBass other) {
        this(other.name, other.length, other.weight, other.stripeCount, other.isSaltwater, other.bestFriend);
    }

    /**
     * The stripedBass moves to the opp kind of water body if and only if doesnt have a best friend.
     */
    public void migrate() {
        if (bestFriend == null) {
            isSaltwater = !isSaltwater;
        }
    }

    /**
     * This overrides the toString method of the parent class.
     */
    @Override
    public String toString() {
        String waterType = isSaltwater ? "saltwater" : "freshwater";
        String bestFriendInfo = (bestFriend == null) ? "no best friend" : "a best friend named " + bestFriend.name;
        return super.toString() + String.format(" I'm a %s striped bass with %d stripes. I have %s.",
        waterType, stripeCount, bestFriendInfo);
    }
}
