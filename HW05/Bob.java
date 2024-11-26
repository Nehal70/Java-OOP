import java.util.ArrayList;
/**
 * Bob Class.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Bob {

    /**
     * Method to compare 2 stores.
     *
     * @param store1 Store
     * @param store2 Store
     * @return boolean
     */
    public static boolean compareStores(Store store1, Store store2) {
        for (Dessert dessert : store1.getDesserts()) {
            if (store2.findDessert(dessert) == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to check if dessert is in shop.
     *
     * @param store Store
     * @param dessert Dessert
     * @return boolean
     */
    public static boolean shop(Store store, Dessert dessert) {
        store.sortStore();
        return store.findDessert(dessert) != null;
    }

    /**
     * Method to find available stores.
     *
     * @param stores Store
     * @param target Dessert
     * @return Arraylist
     */
    public static ArrayList<Store> findAvailableStores(ArrayList<Store> stores, Dessert target) {
        ArrayList<Store> availableStores = new ArrayList<>();
        for (Store store : stores) {
            if (store.findDessert(target) != null) {
                availableStores.add(store);
            }
        }
        return availableStores;
    }
}
