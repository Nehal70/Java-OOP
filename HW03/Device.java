/**
 * This class defines a Device object.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public abstract class Device {
    private final int serialNumber;
    protected final int cpuCapacity;
    protected int cpuRemaining;
    protected Task[] tasks;

    /**
     * This is a constructor that takes in all data fields except cpuRemaining.
     *
     * @param serialNumber serial number of the device
     * @param cpuCapacity cpuCapacity of the device
     * @param length length of the tasks array
     */
    public Device(int serialNumber, int cpuCapacity, int length) {
        this.serialNumber = serialNumber;
        this.cpuCapacity = cpuCapacity;
        this.tasks = new Task[length];
        this.cpuRemaining = cpuCapacity;
    }

    /**
     * This is an overloaded constructor that takes in only serialNumber and length.
     *
     * @param serialNumber serial number of the device
     * @param length length of the tasks array
     */
    public Device(int serialNumber, int length) {
        this.serialNumber = serialNumber;
        this.cpuCapacity = 512;
        this.cpuRemaining = 512;
        this.tasks = new Task[length];
    }

    /**
     * Abstract method to check if a task can be added.
     *
     * @param task the task being checked
     * @return boolean true if the task can be added, false otherwise
     */
    public abstract boolean canAddTask(Task task);

    /**
     * Abstract method to add a task to the list of tasks.
     *
     * @param task the task which is being added
     * @return boolean true if the task is added successfully, false otherwise
     */
    public abstract boolean addTask(Task task);

    /**
     * This method processes the task.
     *
     * @param task the task being processed
     * @return boolean true if the task is processed, false otherwise
     */
    public boolean processTask(Task task) {
        if (task == null) {
            return false;
        } else {
            for (int i = 0; i < this.tasks.length; i++) {
                if (this.tasks[i] != null && this.tasks[i].equals(task)) {
                    this.cpuRemaining += task.getCpuCost();
                    this.tasks[i] = null;
                    System.out.println("Processed: " + task.toString());
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * This method overrides the equals method from the Object class.
     *
     * @param obj the device being compared
     * @return boolean true if devices are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        Device device = (Device) obj;
        return this.serialNumber == device.serialNumber
            && this.cpuCapacity == device.cpuCapacity
            && this.cpuRemaining == device.cpuRemaining;
    }

    /**
     * Overrides the toString method from the Object class.
     *
     * @return string representation of the device
     */
    @Override
    public String toString() {
        return "Device with serial number " + this.serialNumber
                + " has " + this.cpuRemaining + " of "
                + this.cpuCapacity + " CPU remaining.";
    }
}
