/**
 * This class is a subclass of the Fish Class of Catfish type.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Catfish extends Fish {
    private Double whiskerLength;
    /**
     * This constructor takes in all variables and creates a catfish object.
     *
     * @param name the name of the catfish
     * @param length the length of the catfish
     * @param weight the weight of the catfish
     * @param whiskerLength the whiskerLength of the catfish
     */
    public Catfish(String name, Double length, Double weight, Double whiskerLength) {
        super(name, length, weight);
        this.whiskerLength = (whiskerLength == null
                            || whiskerLength <= 0
                            || whiskerLength.isInfinite()
                            || whiskerLength.isNaN()) ? 8.0 : whiskerLength;
    }
    /**
     * This constructor takes in no parameters and creates a default catfish object.
     */
    public Catfish() {
        this("Bubba", 52.0, 720.0, 5.0);
    }
    /**
     * This constructor creates a catfish object deep copying from another object.
     *
     * @param other the object it copies from
     */
    public Catfish(Catfish other) {
        this(other.name, other.length, other.weight, other.whiskerLength);
    }
    /**
     * This method returns a boolean reflecting if this catfish is shaggy.
     *
     * @return boolean
     */
    public boolean isShaggy() {
        return whiskerLength > length;
    }
    /**
     * This method overrides the corresponding method in its super class.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" I'm a catfish whose longest whisker is %.2f, so I %s shaggy.",
                whiskerLength, isShaggy() ? "am" : "am not");
    }
}
