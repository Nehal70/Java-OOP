public class Driver {
    public static void main(String[] args) {
        SushiRoll s1 = new SushiRoll("a", Color.RED);
        SushiRoll s2 = new SushiRoll("b", Color.GREEN);
        SushiRoll s3 = new SushiRoll("d", Color.RED);
        SushiRoll s4 = new SushiRoll("c", Color.BLUE);
        SushiRoll[] array1 = {s1, s2, s3, s4};

        SushiRoll s5 = new SushiRoll("p", Color.RED);
        SushiRoll s6 = new SushiRoll("l", Color.BLUE);
        SushiRoll s7 = new SushiRoll("x", Color.RED);
        SushiRoll[] array2 = {s5, s6, s7};

        SushiRoll s9 = new SushiRoll("l", Color.RED);
        SushiRoll s10 = new SushiRoll("p", Color.BLUE);
        SushiRoll s11 = new SushiRoll("x", Color.RED);
        SushiRoll s12 = new SushiRoll("q", Color.BLUE);
        SushiRoll[] array3 = {s9, s10, s11, s12};

        System.out.println("Testing mergeSortRolls, expecting a b c d");
        for (SushiRoll s : Restaurant.mergeSortRolls(array1)) {
            System.out.println(s); //a b c d
        }

        array1 = Restaurant.mergeSortRolls(array1);
        array2 = Restaurant.mergeSortRolls(array2);
        array3 = Restaurant.mergeSortRolls(array3);
        SushiRoll[][] order = {array3, array1, array2};
        SushiRoll[] sortedRoll = Restaurant.mergeOrders(order);
        System.out.println("Testing mergeOrders, expecting a b c d l l p p q x x");
        for (SushiRoll s : sortedRoll) {
            System.out.println(s); //a b c d l l p p q x x
        }

        SushiRoll[] empty1 = {};
        SushiRoll[] empty2 = {};
        SushiRoll[][] emptyOrder = {empty1, empty2};
        SushiRoll[] sortedEmptyOrder = Restaurant.mergeOrders(emptyOrder);
        System.out.println("Testing mergeOrders, expecting 0 outputs");
        for (SushiRoll s : sortedEmptyOrder) {
            System.out.println(s); //blank
        }

        SushiRoll[] redColors = Restaurant.platesOfColor(array1, Color.RED);
        System.out.println("Testing platesOfColor, expecting a d");
        for (SushiRoll s : redColors) {
            System.out.println(s); //a d
        }
        System.out.println("Testing platesOfColor, expecting 0 outputs");
        SushiRoll[] greenColors = Restaurant.platesOfColor(array3, Color.GREEN);
        for (SushiRoll s : greenColors) {
            System.out.println(s); // blank
        }

        System.out.println("Testing total price, expecting 11.5, 8.5, 12.0");
        System.out.println(Restaurant.totalPrice(array1)); // 11.5
        System.out.println(Restaurant.totalPrice(array2)); // 8.5
        System.out.println(Restaurant.totalPrice(array3)); // 12.0

        System.out.println("Testing flip: Even array");
        System.out.println("Initial array: ");
        for (SushiRoll s : array1) {
            System.out.println(s); // a b c d
        }
        Restaurant.flip(array1);
        System.out.println("After flip, expecting d c b a");
        for (SushiRoll s : array1) {
            System.out.println(s); // d c b a
        }
        System.out.println("Testing flip: Odd array");
        System.out.println("Initial array: ");
        for (SushiRoll s : array2) {
            System.out.println(s); // l p x
        }
        Restaurant.flip(array2);
        System.out.println("After flip, expecting x p l");
        for (SushiRoll s : array2) {
            System.out.println(s); // x p l
        }
    }
}