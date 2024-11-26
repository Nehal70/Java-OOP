import java.util.NoSuchElementException;

public class Driver{

    public static void main(String[] args) {
        /* Testing LinkedList() */
        LinkedList<String> list = new LinkedList<>();

        System.out.println(list); /* [] */

        list = new LinkedList<>(new String[] {});

        System.out.println(list); /* [] */

        list = new LinkedList<>(new String[] {"a"});

        System.out.println(list); /* [a] */

        list = new LinkedList<>(new String[] {"a", "b", "c", "d"});

        System.out.println(list); /* [a b c d] */

        /* Testing void add(E element) */
        list = new LinkedList<>();

        try { list.add(null); } catch (IllegalArgumentException e) { System.out.println("Illegal argument"); }
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list); /* [a b c] */

        /* Testing void add(int index, E element) */
        list = new LinkedList<>();

        try { list.add(0, null); } catch (IllegalArgumentException e) { System.out.println("Illegal argument"); }
        try { list.add(-1, null); } catch (IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }
        try { list.add(1, null); } catch (IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }
        list.add(0, "a");
        list.add(0, "b");
        list.add(2, "c");
        list.add(1, "d");

        System.out.println(list); /* [b d a c] */

        /* Testing E remove() */
        list = new LinkedList<>();

        try { list.remove(); } catch (NoSuchElementException e) { System.out.println("No such element"); }

        list = new LinkedList<>(new String[] {"a", "b", "c", "d"});
        
        /* Expected: a b c d */
        for (int i = 0; i < 4; i ++) {
            System.out.print(list.remove() + " ");
        }
        System.out.println();

        System.out.println(list); /* [] */

        /* Testing E remove(int index) */
        list = new LinkedList<>();

        try { list.remove(-1); } catch (NoSuchElementException e) { System.out.println("No such element"); }
        
        list = new LinkedList<>(new String[] {"a", "b", "c", "d"});

        try { list.remove(-1); } catch (IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }
        try { list.remove(4); } catch (IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }

        System.out.println(list.remove(0)); /* a */
        System.out.println(list); /* [b c d] */
        System.out.println(list.remove(1)); /* c */
        System.out.println(list); /* [b d] */
        System.out.println(list.remove(1)); /* d */
        System.out.println(list.remove(0)); /* b */
        System.out.println(list); /* [] */

        /* Testing E remove(E element) */
        list = new LinkedList<>();

        try { list.remove("a"); } catch (NoSuchElementException e) { System.out.println("No such element"); }
        try { list.remove(null); } catch (IllegalArgumentException e) { System.out.println("Illegal argument"); }

        list = new LinkedList<>(new String[] {"a", "b", "c", "d"});

        try { list.remove("e"); } catch (NoSuchElementException e) { System.out.println("No such element"); }

        System.out.println(list.remove("d")); /* d */
        System.out.println(list); /* [a b c] */
        System.out.println(list.remove("b")); /* b */
        System.out.println(list); /* [a c] */
        System.out.println(list.remove("a")); /* a */
        System.out.println(list.remove("c")); /* c */
        System.out.println(list); /* [] */

        /* Testing E set(int index, E element) */

        list = new LinkedList<>(new String[] {});
        
        try { list.set(0, "x"); } catch (IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }

        list = new LinkedList<>(new String[] {"a", "b", "c", "d"});

        try { list.set(-1, "x"); } catch (IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }
        try { list.set(4, "x"); } catch (IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }
        try { list.set(4, null); } catch (IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }
        try { list.set(2, null); } catch (IllegalArgumentException e) { System.out.println("Illegal argument"); }

        System.out.println(list.set(0, "d")); /* a */
        System.out.println(list.set(1, "c")); /* b */
        System.out.println(list.set(2, "b")); /* c */
        System.out.println(list.set(3, "a")); /* d */
        System.out.println(list); /* [d c b a] */

        /* Testing E get(int index) */

        list = new LinkedList<>(new String[] {});

        try { list.get(0); } catch(IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }

        list = new LinkedList<>(new String[] {"a", "b", "c", "d"});

        try { list.get(-1); } catch(IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }
        try { list.get(4); } catch(IndexOutOfBoundsException e) { System.out.println("Index out of bounds"); }

        System.out.println(list.get(0)); /* a */
        System.out.println(list.get(1)); /* b */
        System.out.println(list.get(2)); /* c */
        System.out.println(list.get(3)); /* d */
        System.out.println(list); /* [a b c d] */

        /* Testing boolean contains(E element) */

        list = new LinkedList<>(new String[] {});

        try { list.contains(null); } catch (IllegalArgumentException e) { System.out.println("Illegal argument"); }
        
        System.out.println(list.contains("a")); /* false */

        list = new LinkedList<>(new String[] {"a", "b", "c"});

        System.out.println(list.contains("a")); /* true */
        System.out.println(list.contains("b")); /* true */
        System.out.println(list.contains("c")); /* true */
        System.out.println(list.contains("A")); /* false */

        /* Testing void clear() and isEmpty() */
        list = new LinkedList<>(new String[] {});
        
        System.out.println(list.isEmpty()); /* true */
        list.clear();
        System.out.println(list.isEmpty()); /* true */
        System.out.println(list); /* [] */

        list = new LinkedList<>(new String[] {"a", "b", "c"});

        System.out.println(list.isEmpty()); /* false */
        list.clear();
        System.out.println(list.isEmpty()); /* true */
        System.out.println(list); /* [] */
    }
}
