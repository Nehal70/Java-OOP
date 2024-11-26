/**
 * This class defines a Laptop Object.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Laptop extends Device {
    private boolean overclockable;
    /**
     * This method constructs a laptop object.
     *
     * @param serialNumber serialNumber of device
     * @param cpuCapacity cpuCapacity of device
     * @param length length of tasks array
     * @param overclockable indicates if the laptop is overclockable
     */
    public Laptop(int serialNumber, int cpuCapacity, int length, boolean overclockable) {
        super(serialNumber, cpuCapacity, length);
        this.overclockable = overclockable;
    }

    /**
     * This constructor sets overClockable to default.
     *
     * @param serialNumber serialNumber of the device
     * @param cpuCapacity cpuCapacity of the device
     * @param length length of tasks array
     */
    public Laptop(int serialNumber, int cpuCapacity, int length) {
        this(serialNumber, cpuCapacity, length, false);
    }

    /**
     * This method calculates how many task slots should be left empty.
     *
     * @param cpuRemaining the amount of CPU remaining
     * @return the number of buffer slots required
     */
    public int bufferSlotsRequired(int cpuRemaining) {
        if (this.tasks.length <= 4) {
            return 0;
        } else if (cpuRemaining < 128) {
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * This method overrides canAddTask from devices.
     *
     * @param task takes a task to check if it can be added
     * @return boolean true if the task can be added, false otherwise
     */
    @Override
    public boolean canAddTask(Task task) {
        int nullCount = 0;
        for (int i = 0; i < this.tasks.length; i++) {
            if (this.tasks[i] == null) {
                nullCount++;
            }
        }

        int bufferCalcValue = cpuRemaining - task.getCpuCost();
        int neededBufferSlots = bufferSlotsRequired(bufferCalcValue);

        // Directly return the result of the conditions
        return nullCount > neededBufferSlots
            && (task.getCpuCost() < this.cpuRemaining
            || (overclockable && task.getCpuCost() < (0.25 * task.getCpuCost() + this.cpuRemaining)));
    }

    /**
     * Implements abstract method from Device class.
     *
     * @param task task being added
     * @return boolean true if the task is added successfully, false otherwise
     */
    @Override
    public boolean addTask(Task task) {
        if (!canAddTask(task)) {
            return false;
        }

        int firstNullSlot = -1;
        for (int i = 0; i < this.tasks.length; i++) {
            if (this.tasks[i] == null) {
                firstNullSlot = i;
                break;
            }
        }

        if (firstNullSlot != -1) {
            tasks[firstNullSlot] = task;
            cpuRemaining -= task.getCpuCost();
            if (cpuRemaining < 0 && overclockable) {
                cpuRemaining += (cpuCapacity / 4);
                overclockable = false; // Overclocking can happen only once
            }
            return true;
        }

        return false;
    }

    /**
     * Overrides the equals method.
     *
     * @param obj laptop being compared
     * @return boolean true if the laptops are equal, false otherwise
     */
    public boolean equals(Object obj) {
        Laptop laptop = (Laptop) obj;
        return super.equals(laptop) && this.overclockable == laptop.overclockable;
    }

    /**
     * Overrides the toString method.
     *
     * @return the string representation of the laptop
     */
    @Override
    public String toString() {
        String overClockability = overclockable ? "does" : "does not";
        return super.toString() + " This laptop " + overClockability + " have overclocking.";
    }
}
