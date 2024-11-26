import java.util.ArrayList;

/**
 * Vending Machine Class.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class VendingMachine {
    private ArrayList<String> stock;
    private int cost;

    /**
     * Constructor for Vending Machine.
     *
     * @param stock arraylist
     * @param cost int
     */
    public VendingMachine(ArrayList<String> stock, int cost) {
        this.stock = stock;
        this.cost = cost;
    }

    /**
     * The checkStock method to check if its in stock.
     *
     * @param order the order you're checking
     * @throws OutOfStockException exception to check if order exists
     */
    public void checkStock(ArrayList<String> order) throws OutOfStockException {
        if (order == null) {
            throw new IllegalArgumentException("Order can't be null.");
        }
        for (String item : order) {
            if (!stock.contains(item)) {
                throw new OutOfStockException(item);
            }
        }
        System.out.println("All items are in stock!");
    }

    /**
     * Method to buy an item.
     *
     * @param item string describing item.
     * @param money cost of item.
     * @throws OutOfStockException exception to check if order exists.
     */
    public void buyItem(String item, int money) throws OutOfStockException {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        if (!stock.contains(item)) {
            throw new OutOfStockException(item);
        }
        if (money < cost) {
            throw new NotEnoughMoneyException();
        }
        stock.remove(item);
        System.out.println(item + " successfully vended!");
    }

    /**
     * Method to check if favourite items are in list.
     *
     * @param favoriteItems arraylist of favourite items
     * @return ArrayList
     */
    public ArrayList<String> availableFavorites(ArrayList<String> favoriteItems) {
        if (favoriteItems == null) {
            throw new IllegalArgumentException("Favorite items list cannot be null.");
        }
        ArrayList<String> availableItems = new ArrayList<>();
        for (String item : favoriteItems) {
            if (stock.contains(item)) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    /**
     * Method being run.
     *
     * @param args args argument.
     */
    public static void main(String[] args) {
        ArrayList<String> vendingItems = new ArrayList<>();
        vendingItems.add("Soda");
        vendingItems.add("Chips");
        vendingItems.add("Candy");
        vendingItems.add("Water");
        vendingItems.add("Juice");

        ArrayList<String> favorites = new ArrayList<>();
        favorites.add("Candy");
        favorites.add("Juice");
        favorites.add("Ice Cream");

        VendingMachine machine = new VendingMachine(vendingItems, 100);

        try {
            machine.checkStock(vendingItems);
            machine.buyItem("Soda", 100);
            machine.buyItem("Candy", 50); // This should throw NotEnoughMoneyException
            machine.buyItem("Ice Cream", 100); // This should throw OutOfStockException

            ArrayList<String> availableFavorites = machine.availableFavorites(favorites);
            for (String item : availableFavorites) {
                System.out.println(item);
            }
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Took a trip to the vending machine!");
        }
    }
}
