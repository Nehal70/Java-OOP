/**
 * Dessert Class.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public abstract class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;

    /**
     * Constructor for Dessert Class.
     * @param flavor String
     * @param sweetness double
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }

    /**
     * default constructor.
     *
     */
    public Dessert() {
        this("vanilla", 25.0);
    }

    /**
     * getter method for flavor.
     *
     * @return String
     */
    public String getFlavor() {
        return this.flavor;
    }

    /**
     * getter method for sweetness.
     *
     * @return String
     */
    public double getSweetness() {
        return this.sweetness;
    }

    /**
     * Overrides Object Class' toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s dessert with a sweetness of %.2f.", this.flavor, this.sweetness);
    }


    /**
     * Overrides Object Class' equals method.
     *
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }
        Dessert other = (Dessert) obj;
        return this.flavor.equals(other.flavor) && this.sweetness == other.sweetness;
    }

    /**
     * Overrides compareTo method from comparable interface.
     *
     * @return int
     */
    @Override
    public int compareTo(Dessert other) {
        if (this.sweetness > other.sweetness) {
            return 1;
        } else if (this.sweetness < other.sweetness) {
            return -1;
        } else {
            return this.flavor.compareTo(other.flavor);
        }
    }
}
