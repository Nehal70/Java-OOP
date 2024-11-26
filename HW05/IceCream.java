/**
 * Icecream subclass of Dessert superclass.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class IceCream extends Dessert {

    private int scoops;
    private boolean cone;

    /**
     * Constructor taking in all fields.
     *
     * @param flavor String
     * @param sweetness double
     * @param scoops int
     * @param cone boolean
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }

    /**
     * Constructor taking in 2 fields.
     *
     * @param scoops int
     * @param cone boolean
     */
    public IceCream(int scoops, boolean cone) {
        this("vanilla", 45.0, scoops, cone);
    }

    /**
     * Default constructor.
     *
     */
    public IceCream() {
        this("vanilla", 45.0, 1, false);
    }

    /**
     * Overrides toString method of Dessert class.
     *
     * @return String
     */
    @Override
    public String toString() {
        String scoopString = this.cone ? "has" : "does not have";
        return String.format("%s ice cream with %d scoops and %s a cone.", this.getFlavor(), this.scoops, scoopString);
    }

    /**
     * Overrides equals method.
     *
     * @param obj Object being compared
     * @return boolean indicating equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof IceCream) {
            IceCream other = (IceCream) obj;
            return this.scoops == other.scoops && this.cone == other.cone;
        }
        return false;
    }
}
