public class Driver {
    public static void main(String[] args) {
        // Test 1: Initialize a Lineup with integers
        Lineup<Integer> intLineup = new Lineup<>(1, 2, 3, 4);
        System.out.println("Initial integer lineup: " + intLineup); // Expected: 1 -> 2 -> 3 -> 4

        // Test 2: Add an element to a full lineup
        System.out.println("Adding 5 to full lineup: " + intLineup.add(5)); // Expected: false
        System.out.println("Lineup after trying to add 5: " + intLineup); // Expected: 1 -> 2 -> 3 -> 4

        // Test 3: Remove an element
        System.out.println("Removing 3: " + intLineup.remove(3)); // Expected: true
        System.out.println("Lineup after removing 3: " + intLineup); // Expected: 1 -> 2 -> 4 -> null

        // Test 4: Add an element after removal
        System.out.println("Adding 0: " + intLineup.add(0)); // Expected: true
        System.out.println("Lineup after adding 0: " + intLineup); // Expected: 0 -> 1 -> 2 -> 4

        // Test 5: Reverse the lineup
        intLineup.reverseLineup();
        System.out.println("Reversed lineup: " + intLineup); // Expected: 4 -> 2 -> 1 -> 0

        // Test 6: Check contains
        System.out.println("Lineup contains 2? " + intLineup.contains(2)); // Expected: true
        System.out.println("Lineup contains 5? " + intLineup.contains(5)); // Expected: false

        // Test 7: Check size
        System.out.println("Size of lineup: " + intLineup.size()); // Expected: 4

        // Test 8: Add null element
        System.out.println("Adding null: " + intLineup.add(null)); // Expected: false
        System.out.println("Lineup after adding null: " + intLineup); // Expected: 4 -> 2 -> 1 -> 0

        // Test 9: Initialize a Lineup with strings
        Lineup<String> stringLineup = new Lineup<>("apple", "banana", "cherry", "date");
        System.out.println("Initial string lineup: " + stringLineup); // Expected: apple -> banana -> cherry -> date

        // Test 10: Remove an element from the string lineup
        System.out.println("Removing 'banana': " + stringLineup.remove("banana")); // Expected: true
        System.out.println("String lineup after removal: " + stringLineup); // Expected: apple -> cherry -> date -> null

        // Test 11: Add an element to the string lineup
        System.out.println("Adding 'fig': " + stringLineup.add("fig")); // Expected: true
        System.out.println("String lineup after adding 'fig': " + stringLineup); // Expected: apple -> cherry -> date -> fig

        // Test 12: Reverse the string lineup
        stringLineup.reverseLineup();
        System.out.println("Reversed string lineup: " + stringLineup); // Expected: fig -> date -> cherry -> apple
    }
}
