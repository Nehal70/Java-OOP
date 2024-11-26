/**
 * This class defines a cellPhone object.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class CellPhone extends Device {
    private int tasksCompleted = 0;

    /**
     * This is a constructor for the cellPhone class.
     *
     * @param serialNumber the serial number of the device
     * @param cpuCapacity the CPU capacity of the device
     * @param length the number of tasks
     */
    public CellPhone(int serialNumber, int cpuCapacity, int length) {
        super(serialNumber, cpuCapacity, length);
    }

    /**
     * This is an overloaded constructor for the CellPhone class.
     *
     * @param serialNumber the serial number of the device
     * @param cpuCapacity the CPU capacity of the device
     */
    public CellPhone(int serialNumber, int cpuCapacity) {
        super(serialNumber, cpuCapacity, 10);
    }

    /**
     * This is to override the ProcessTask method to modify tasks completed.
     *
     * @param task the task being processed
     * @return boolean
     */
    public boolean processTask(Task task) {
        boolean isItProcessed = super.processTask(task);
        if (isItProcessed) {
            tasksCompleted++;
            return true;
        }
        return false;
    }
    /**
     * Implements the abstract method from the Device class.
     *
     * @param task the task being checked if it can be added
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
        return task.getCpuCost() < this.cpuRemaining && nullCount > 0;
    }

    /**
     * Implements the abstract method from the Device class.
     *
     * @param task the task being added
     * @return boolean true if the task is added successfully, false otherwise
     */
    @Override
    public boolean addTask(Task task) {
        if (canAddTask(task)) {
            for (int i = 0; i < this.tasks.length; i++) {
                if (this.tasks[i] == null) {
                    this.tasks[i] = task;
                    this.cpuRemaining -= task.getCpuCost();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * This method overrides the equals method from the Device class.
     *
     * @param obj the object being compared
     * @return boolean true if the cell phones are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        CellPhone cellPhone = (CellPhone) obj;
        return super.equals(cellPhone) && this.tasksCompleted == cellPhone.tasksCompleted;
    }

    /**
     * This method overrides the toString method from the Device class.
     *
     * @return String representation of the cell phone
     */
    @Override
    public String toString() {
        return super.toString() + " It has completed "
            + this.tasksCompleted + " tasks.";
    }
}
