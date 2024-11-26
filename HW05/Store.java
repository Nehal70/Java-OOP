import java.util.ArrayList;

/**
 * Store class.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Store {
    private String name;
    private ArrayList<Dessert> desserts;

    /**
     * Constructor taking name field.
     *
     * @param name String
     */
    public Store(String name) {
        this.name = name;
        this.desserts = new ArrayList<>();
    }

    /**
     * To add dessert to desserts.
     *
     * @param dessert Dessert
     */
    public void addDessert(Dessert dessert) {
        desserts.add(dessert);
    }

    /**
     * To remove a dessert from desserts.
     *
     * @param dessert Dessert
     * @return Dessert removed
     */
    public Dessert removeDessert(Dessert dessert) {
        for (int i = 0; i < this.desserts.size(); i++) {
            if (this.desserts.get(i).equals(dessert)) {
                return desserts.remove(i);
            }
        }
        return null;
    }

    /**
     * To find a dessert in desserts.
     *
     * @param dessert Dessert
     * @return Dessert found
     */
    public Dessert findDessert(Dessert dessert) {
        int left = 0;
        int right = desserts.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = desserts.get(mid).compareTo(dessert);

            if (comparison == 0) {
                return desserts.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    /**
     * Method to sort a store.
     *
     */
    public void sortStore() {
        for (int i = 0; i < desserts.size() - 1; i++) {
            for (int j = 0; j < desserts.size() - i - 1; j++) {
                if (desserts.get(j).compareTo(desserts.get(j + 1)) > 0) {
                    Dessert temp = desserts.get(j);
                    desserts.set(j, desserts.get(j + 1));
                    desserts.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * To count desserts greater.
     *
     * @param dessert Dessert
     * @return int count of desserts greater than or equal to the given dessert
     */
    public int countGreaterDesserts(Dessert dessert) {
        int count = 0;
        for (Dessert d : desserts) {
            if (d.compareTo(dessert) >= 0) {  // Counts desserts greater than or equal
                count++;
            }
        }
        return count;
    }

    /**
     * Method to print menu.
     *
     */
    public void showMenu() {
        System.out.println(name + "'s Menu of the Day:");
        for (Dessert dessert : desserts) {
            System.out.println(dessert.toString());
        }
    }

    /**
     * Getter method for desserts.
     *
     * @return ArrayList of desserts
     */
    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}

