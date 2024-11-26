/**
 * Subclass Cake of Dessert.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Cake extends Dessert {

    private String frosting;

    /**
     * Constructor taking in all variables.
     *
     * @param flavor String
     * @param sweetness double
     * @param frosting String
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }

    /**
     * Constructor taking in only flavor field.
     *
     * @param flavor String
     */
    public Cake(String flavor) {
        this(flavor, 45.0, "vanilla");
    }

    /**
     * Overrides Dessert Class' toString method.
     */
    @Override
    public String toString() {
        return String.format("%s cake with a %s frosting and has a sweetness of %.2f.",
                this.getFlavor(), this.frosting, this.getSweetness());

    }

    /**
     * Overrides equals method.
     *
     * @param obj Object being compared
     * @return boolean indicating equality
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Cake cake = (Cake) obj;
            return cake.frosting.equals(this.frosting);
        }
        return super.equals(obj);
    }
}

