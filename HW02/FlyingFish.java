import java.util.Random;
/**
 * This class is a subclass of the Fish class.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class FlyingFish extends Fish {
    private int flightTime;

    /**
     * This constructor creates a Flyingfish object after taking in all parameters.
     *
     * @param name the name of the flyingfish
     * @param length the length of the flyingfish
     * @param weight the weight of the flyingfish
     * @param flightTime the flightTime of the flyingfish
     */
    public FlyingFish(String name, Double length, Double weight, int flightTime) {
        super(name, length, weight);

        if (flightTime <= 0) {
            this.flightTime = 30;
        } else {
            this.flightTime = flightTime;
        }
    }

    /**
     * This constructor takes in no parameters and creates a default flyingfish object.
     */
    public FlyingFish() {
        this("Gilbert", 12.0, 24.0, 36);
    }

    /**
     * This constructor creates a flyingfish by deep copying properties from another object.
     *
     * @param other the object it deep copies from
     */
    public FlyingFish(FlyingFish other) {
        this(other.name, other.length, other.weight, other.flightTime);
    }

    /**
     * This method returns the power.
     *
     * @return double
     */
    public double calculatePower() {
        return weight * flightTime;
    }

    /**
     * This method prints a message followed by a newline.
     */
    public void fly() {
        Random random = new Random();
        double time = random.nextDouble() * flightTime;
        System.out.printf("Woohoo! %s flew for %.2f seconds.%n", name, time);
    }

    /**
     * Overrides the corresponding method in its superclass.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(
            " I'm a flying fish, and my flight time record is %d, so my power is %.2f.",
        flightTime, calculatePower());
    }
}
