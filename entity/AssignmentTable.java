package entity;

import java.util.Arrays;

public class AssignmentTable {
    private Driver driver;
    private Assignment[] assignments;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Assignment[] getAssignments() {
        return assignments;
    }

    public void setAssignments(Assignment[] assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "AssignmentTable{" +
                "driver=" + driver +
                ", assignments=" + Arrays.toString(assignments) +
                '}';
    }

    public int sumGland() {
        if (AssignmentTable.isNullOrEmpty(assignments)) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < assignments.length; ++i) {
            sum += assignments[i].getBuses().getDistance();

        }
        return sum;
    }

    public static boolean isNullOrEmpty(Object[] obj) {
        return obj == null && obj.length == 0;
    }
}
