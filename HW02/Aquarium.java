/**
 * This class creates an aquarium of Fish.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Aquarium {
    /**
     * The main method for this class.
     *
     * @param args args
     */
    public static void main(String[] args) {

        Fish fish1 = new Fish("Goldie", 25.0, 16.0);
        Fish fish2 = new Fish();
        Fish fish3 = new Fish(fish1);

        System.out.println(fish1);
        System.out.println(fish2);
        System.out.println(fish3);

        Catfish catfish1 = new Catfish("Whiskers", 20.0, 15.0, 10.0);
        Catfish catfish2 = new Catfish();
        Catfish catfish3 = new Catfish(catfish1);

        System.out.println(catfish1);
        System.out.println(catfish2);
        System.out.println(catfish3);
        System.out.println("Is catfish1 shaggy? " + catfish1.isShaggy());

        StripedBass stripedBass1 = new StripedBass("Stripy", 30.0, 40.0, 20, true, catfish1);
        StripedBass stripedBass2 = new StripedBass();
        StripedBass stripedBass3 = new StripedBass(stripedBass1);

        System.out.println(stripedBass1);
        System.out.println(stripedBass2);
        System.out.println(stripedBass3);
        stripedBass2.migrate();
        System.out.println("After migration: " + stripedBass2);

        FlyingFish flyingFish1 = new FlyingFish("Skippy", 15.0, 10.0, 20);
        FlyingFish flyingFish2 = new FlyingFish();
        FlyingFish flyingFish3 = new FlyingFish(flyingFish1);

        System.out.println(flyingFish1);
        System.out.println(flyingFish2);
        System.out.println(flyingFish3);
        flyingFish1.fly();
    }
}
