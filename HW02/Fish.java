/**
 * This class is for a Fish type object.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Fish {
    protected final String name;
    protected Double length;
    protected Double weight;
    private static int totalFish = 0;

    /**
     * This is a constructor for the fish class.
     *
     * @param name the name of the fish
     * @param length the length of the fish in inches
     * @param weight the weight of the fish
     */
    public Fish(String name, Double length, Double weight) {
        if (name == null || name.isBlank()) {
            this.name = "Nemo";
        } else {
            this.name = name;
        }

        if (length == null) {
            this.length = 8.0;
        } else if (length <= 0 || length.isInfinite() || length.isNaN()) {
            this.length = 8.0;
        } else {
            this.length = length;
        }

        if (weight == null) {
            this.weight = 2.0;
        } else if (weight <= 0 || weight.isInfinite() || weight.isNaN()) {
            this.weight = 2.0;
        } else {
            this.weight = weight;
        }
        totalFish++;
    }

    /**
     * This constructor takes in no parameters and sets name to Nemo, length to 5.0 and weight to 12.0.
     */
    public Fish() {
        this("Nemo", 5.0, 12.0);
    }

    /**
     * This constructor deep copies all neccessary instance fields assuming the input wont be null.
     *
     * @param other includes name, length, weight
     */
    public Fish(Fish other) {
        this(other.name, other.length, other.weight);
    }

    /**
     * Returns the end-to-end length of this fish as a String, formatted precisely as feet ft inches in.
     *
     * @return string
     */
    public String formatLength() {
        int feet = (int) (length / 12);
        double inches = length % 12;
        return String.format("%d ft %.2f in", feet, inches);
    }

    /**
     * Returns the weight of this fish as a String, formatted precisely as pounds lbs ounces oz.
     *
     * @return String
     */
    public String formatWeight() {
        int pounds = (int) (weight / 16);
        double ounces = weight % 16;
        return String.format("%d lb%s %.2f oz", pounds, pounds == 1 ? "" : "s", ounces);
    }

    /**
     * Overrides the corresponding method in its super class.
     */
    @Override
    public String toString() {
        return String.format("I'm a talking fish named %s. My length is %s and my weight is %s.",
                name, formatLength(), formatWeight());
    }
}
