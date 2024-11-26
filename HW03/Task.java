/**
 * Class that defines a Task object.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public final class Task {
    private final String name;
    private final int cpuCost;

    /**
     * Constructor for the Task object that sets defaults in case inputs
     * do not fit specified conditions.
     *
     * @param name task name
     * @param cpuCost task CPU cost
     */
    public Task(String name, int cpuCost) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "GEN_TASK";
        }

        if (cpuCost < 8) {
            this.cpuCost = 8;
        } else {
            this.cpuCost = cpuCost;
        }
    }

    /**
     * This method returns the CPU cost.
     *
     * @return integer CPU cost
     */
    public int getCpuCost() {
        return this.cpuCost;
    }

    /**
     * Overrides the equals method from the Object class.
     *
     * @param obj the task being compared
     * @return boolean true if tasks are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        Task task = (Task) obj;
        return this.name.equals(task.name) && this.cpuCost == task.cpuCost;
    }

    /**
     * Overrides the toString method from the Object class.
     *
     * @return String representation of the task
     */
    @Override
    public String toString() {
        return this.name + " has CPU cost of " + this.cpuCost;
    }
}
