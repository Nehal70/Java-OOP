public class driver {
    public static void main(String[] args) {
        // Create several Task objects with varying cpuCost
        Task task1 = new Task("Task1", 20);
        Task task2 = new Task("Task2", 15);
        Task task3 = new Task("Task3", 5); // This should set cpuCost to 8

        // Create 2 CellPhone objects
        CellPhone cellPhone1 = new CellPhone(101, 256, 5);
        CellPhone cellPhone2 = new CellPhone(102, 128, 3);

        // Use addTask() on at least one of the CellPhone objects
        System.out.println("Adding Task1 to CellPhone1: " + cellPhone1.addTask(task1)); // Expect true
        System.out.println("Adding Task2 to CellPhone1: " + cellPhone1.addTask(task2)); // Expect true

        // Use processTask() on at least one of the CellPhone objects
        System.out.println("Processing Task1 from CellPhone1: " + cellPhone1.processTask(task1)); // Expect true

        // Call toString() on at least one of the CellPhone objects
        System.out.println(cellPhone1.toString()); // Check the state of CellPhone1

        // Check to see if the 2 CellPhone objects are equal
        System.out.println("CellPhone1 equals CellPhone2: " + cellPhone1.equals(cellPhone2)); // Expect false

        // Create 2 Laptop objects
        Laptop laptop1 = new Laptop(201, 512, 4, true);
        Laptop laptop2 = new Laptop(202, 1024, 6, false);

        // Use addTask() on at least one of the Laptop objects
        System.out.println("Adding Task3 to Laptop1: " + laptop1.addTask(task3)); // Expect true

        // Use processTask() on at least one of the Laptop objects
        System.out.println("Processing Task3 from Laptop1: " + laptop1.processTask(task3)); // Expect true

        // Call toString() on at least one of the Laptop objects
        System.out.println(laptop1.toString()); // Check the state of Laptop1

        // Check to see if the 2 Laptop objects are equal
        System.out.println("Laptop1 equals Laptop2: " + laptop1.equals(laptop2)); // Expect false
    }
}
